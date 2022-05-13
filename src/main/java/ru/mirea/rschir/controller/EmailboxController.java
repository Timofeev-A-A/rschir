package ru.mirea.rschir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mirea.rschir.model.Mailbox;
import ru.mirea.rschir.repository.MailboxRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmailboxController {

    @Autowired
    MailboxRepository mailboxRepository;

    @GetMapping("/emailbox")
    public String emailbox(Model model, HttpSession session) {
        List<Mailbox> inBox = mailboxRepository.findAllByReceiver((String) session.getAttribute("cEmail"));
        List<Mailbox> outBox = mailboxRepository.findAllBySender((String) session.getAttribute("cEmail"));
        model.addAttribute("inBox", inBox);
        model.addAttribute("outBox", outBox);
        return "emailbox";
    }
}
