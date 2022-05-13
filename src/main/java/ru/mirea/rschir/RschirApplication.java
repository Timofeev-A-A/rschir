package ru.mirea.rschir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class RschirApplication {

	@GetMapping("/")
	public String index(){
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(RschirApplication.class, args);
	}

}
