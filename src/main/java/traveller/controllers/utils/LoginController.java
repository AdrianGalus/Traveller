package traveller.controllers.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.UserDTO;
import traveller.dtos.UserLoginDTO;
import traveller.services.LoginService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public String login(Model model) {

        model.addAttribute("userForm", new UserLoginDTO());
        return "login";
    }
    @PostMapping
    public String login(@ModelAttribute("userForm") @Valid UserLoginDTO form, BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "login";
        }
        boolean correctCredentials = loginService.checkCredentials(form.getLogin(), form.getPassword());
        if(!correctCredentials) {
            result.rejectValue("password", "errors.invalid", "Login i/lub hasło nie są poprawne");
            return "login";
        }
        UserDTO user = loginService.login(form.getLogin());
        session.setAttribute("loggedUser", user);
        return "redirect:/";
    }
}
