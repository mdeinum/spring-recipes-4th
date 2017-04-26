package com.apress.springrecipes.board;

import java.util.List;

public interface MessageRepository {

    List<Message> findAll();
    Message findOne(long id);
    void remove(long id);
    Message save(Message message);

    List<Message> findByAuthor(String author);

}
