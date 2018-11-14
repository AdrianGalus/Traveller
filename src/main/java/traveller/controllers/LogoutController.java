package traveller.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpSession;

@RestControllerAdvice
public class LogoutController {

    @GetMapping
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/home";
    }
}
