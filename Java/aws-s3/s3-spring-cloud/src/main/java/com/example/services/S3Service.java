package com.example.services;

import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class S3Service {
    private final S3Client s3Client;
    @Autowired
    private S3Template s3Template;

    public S3Service(S3Client s3Client, S3Template s3Template) {
        this.s3Client = s3Client;
        this.s3Template = s3Template;
    }

    public List<Bucket> getBuckets() {
        ListBucketsResponse response = s3Client.listBuckets();

        return response.buckets();
    }

    public void uploadFile(String bucketName, String keyName, String filePath) {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            s3Template.upload(bucketName, keyName, inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file to S3 via S3Template", e);
        }
    }

    public void downloadFile(String bucketName, String keyName, String downloadPath) {
        S3Resource s3Resource = s3Template.download(bucketName, keyName);

        try (InputStream inputStream = s3Resource.getInputStream()) {
            Files.copy(inputStream, Paths.get(downloadPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to download file from S3 via S3Template", e);
        }
    }

    public File downloadFileAsFile(String bucketName, String keyName) throws IOException {
        File tempFile = Files.createTempFile("s3-download-", "-" + keyName).toFile();

        S3Resource s3Resource = s3Template.download(bucketName, keyName);

        try (InputStream inputStream = s3Resource.getInputStream()) {
            Files.copy(inputStream, tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        }

        return tempFile;
    }

    public File downloadFileAsFileAndBytes(String bucketName, String keyName) throws IOException {
        File tempFile = Files.createTempFile("s3-download-bytes-", "-" + keyName).toFile();

        S3Resource s3Resource = s3Template.download(bucketName, keyName);

        try (InputStream inputStream = s3Resource.getInputStream()) {
            byte[] fileBytes = inputStream.readAllBytes();
            Files.write(tempFile.toPath(), fileBytes);
        }

        return tempFile;
    }
}
