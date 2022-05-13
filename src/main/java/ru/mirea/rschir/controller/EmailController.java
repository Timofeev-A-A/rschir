package ru.mirea.rschir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.mirea.rschir.model.Mailbox;
import ru.mirea.rschir.repository.MailboxRepository;

@Controller
public class EmailController {

    @Autowired
    MailboxRepository mailboxRepository;

    @GetMapping("/email/{mailId}")
    public String email(@PathVariable String mailId, Model model) {
        if (mailboxRepository.findById(mailId).isPresent()) {
            Mailbox oneMail = mailboxRepository.findById(mailId).get();
            model.addAttribute("oneMail",oneMail);
            return "email";
        }
        return "emailbox";
    }
}
