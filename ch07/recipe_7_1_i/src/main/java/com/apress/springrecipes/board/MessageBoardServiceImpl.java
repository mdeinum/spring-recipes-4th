package com.apress.springrecipes.board;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
class MessageBoardServiceImpl implements MessageBoardService {

    private final MessageRepository messageRepository;

    MessageBoardServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> listMessages() {
        return messageRepository.findAll();
    }

    public void postMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(Message message) {
        this.messageRepository.remove(message.getId());
    }

    public Message findMessageById(Long messageId) {
        return messageRepository.findOne(messageId);
    }
}

