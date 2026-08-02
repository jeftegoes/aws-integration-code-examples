package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;

public class ExampleCdkProjectApp {
    public static void main(final String[] args) {
        App app = new App();

        new QueueStack(app, "QueueStack", StackProps.builder().build());

        app.synth();
    }
}