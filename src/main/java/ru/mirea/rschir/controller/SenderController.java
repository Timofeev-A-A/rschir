package ru.mirea.rschir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.rschir.model.Mailbox;
import ru.mirea.rschir.repository.MailboxRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sender")
public class SenderController {

    @Autowired
    MailboxRepository mailboxRepository;

    @GetMapping
    public String sendForm(Model model) {
        model.addAttribute("sendForm", new Mailbox());
        return "sender";
    }

    @PostMapping
    public String SendMail(@ModelAttribute("sendForm") Mailbox sMail, HttpSession session) {
        sMail.setSender((String) session.getAttribute("cEmail"));
        mailboxRepository.save(sMail);
        System.out.println("Mail sent");
        return "redirect:/emailbox";
    }
}
