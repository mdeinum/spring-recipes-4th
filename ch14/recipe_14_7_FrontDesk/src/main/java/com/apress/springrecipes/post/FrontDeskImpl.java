package com.apress.springrecipes.post;

import java.util.concurrent.ExecutionException;

import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class FrontDeskImpl implements FrontDesk {

    private final KafkaOperations<Integer, Mail> kafkaOperations;

    public FrontDeskImpl(KafkaOperations<Integer, Mail> kafkaOperations) {
        this.kafkaOperations = kafkaOperations;
    }

    public void sendMail(final Mail mail) {
        ListenableFuture<SendResult<Integer, Mail>> future = kafkaOperations.sendDefault(mail);
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, Mail>>() {

            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<Integer, Mail> result) {
                System.out.println("Result (success): " + result);
            }
        });
        kafkaOperations.flush();
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
