package ru.mirea.rschir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.rschir.model.Users;
import ru.mirea.rschir.repository.UsersRepository;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping
    public String logForm(Model model) {
        model.addAttribute("logForm", new Users());
        return "login";
    }

    @PostMapping
    public String LoggingUIn(@ModelAttribute("logForm") Users fUser, HttpSession session) {
        if (usersRepository.existsUsersByEmail(fUser.getEmail())) {
            Users checker = usersRepository.findByEmail(fUser.getEmail());
            if (Objects.equals(fUser.getPassword(), checker.getPassword())) {
                session.setAttribute("cEmail", fUser.getEmail());
                System.out.println("Logged in");
                return "redirect:/emailbox";
            }
        }
        System.out.println("Not logged");
        return "redirect:/index";
    }
}
