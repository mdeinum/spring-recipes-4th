package com.apress.springrecipes.board;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class MessageBoardDataInitializer {

    private final MessageBoardService messageBoardService;

    MessageBoardDataInitializer(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    @PostConstruct
    public void setup() {

        Message msg = new Message();
        msg.setAuthor("marten@apressmedia.net");
        msg.setTitle("Message #1");
        msg.setBody("This is test.");

        messageBoardService.postMessage(msg);

        msg = new Message();
        msg.setAuthor("marten@apressmedia.net");
        msg.setTitle("Message #2");
        msg.setBody("This is another test.");

        messageBoardService.postMessage(msg);

        msg = new Message();
        msg.setAuthor("marten@apressmedia.net");
        msg.setTitle("Message on Security");
        msg.setBody("How is that security thing coming along?");

        messageBoardService.postMessage(msg);

        msg = new Message();
        msg.setAuthor("jlong@pivotal.io");
        msg.setTitle("Are you ready?");
        msg.setBody("Are you ready, to go?");

        messageBoardService.postMessage(msg);

        msg = new Message();
        msg.setAuthor("rwinch@pivotal.io");
        msg.setTitle("How is your XSS coming along?");
        msg.setBody("How about this? <script>window.alert('hello there!');</script>");

        messageBoardService.postMessage(msg);


    }
}
