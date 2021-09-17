package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {



    @GetMapping("add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify, String username, String email) {
        model.addAttribute("user", user);
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        if (verify.equals(user.getPassword())){
            return "/user/index";
        } else if (!verify.equals(user.getPassword())){
            String error = "Passwords must match";
            model.addAttribute("error", error);
        }
        return "/user/add";
    }
}
