package com.myorg;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.services.sqs.Queue;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class QueueStack extends Stack {
    public QueueStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public QueueStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        final Queue queue = Queue.Builder.create(this, "orders-queue")
                .visibilityTimeout(Duration.seconds(300))
                .build();

    }
}