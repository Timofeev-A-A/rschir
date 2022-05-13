package ru.mirea.rschir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.rschir.model.Users;
import ru.mirea.rschir.repository.UsersRepository;

@Controller
@RequestMapping("/signin")
public class SigninController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping
    public String signForm(Model model) {
        model.addAttribute("signForm", new Users());
        return "signin";
    }

    @PostMapping
    public String signYouIn(@ModelAttribute("signForm") Users yrUser) {
        if (usersRepository.existsUsersByEmail(yrUser.getEmail())){
            return "signin";
        }
        else {
            usersRepository.save(yrUser);
            return "redirect:/login";
        }
    }

}
