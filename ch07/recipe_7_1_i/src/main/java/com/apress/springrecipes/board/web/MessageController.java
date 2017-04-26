package com.apress.springrecipes.board.web;

import com.apress.springrecipes.board.Message;
import com.apress.springrecipes.board.MessageBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageBoardService messageBoardService;

    public MessageController(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    @GetMapping
    public String list(Model model) {
        List<Message> messages = messageBoardService.listMessages();
        model.addAttribute("messages", messages);
        return "messageList";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("message", new Message());
        return "messagePost";
    }

    @PostMapping
    public String newMessage(@ModelAttribute @Valid Message message, BindingResult errors, Principal principal) {
        if (errors.hasErrors()) {
            return "messagePost";
        }
        message.setAuthor(principal.getName());
        messageBoardService.postMessage(message);
        return "redirect:/messages";
    }

    @DeleteMapping("/{messageId}")
    public String delete(@PathVariable("messageId") long messageId, HttpServletRequest request) {
        Message message = messageBoardService.findMessageById(messageId);
        if (message != null) {
            messageBoardService.deleteMessage(message);
        }
        return "redirect:/messages";
    }

}
