package edu.ucalgary.oop.flightapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import edu.ucalgary.oop.flightapp.logic.User;
import edu.ucalgary.oop.flightapp.logic.UserLogin;

@Controller
public class UserLoginController {

    private final UserLogin userLoginService = UserLogin.getInstance();

    @GetMapping("/login.html")
    public String loginForm(Model model) {
        // Add necessary attributes to the model if needed
        return "login.html"; // login.html in templates directory
    }

    @PostMapping("/login.html")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userLoginService.login(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/user_dashboard.html"; // Redirect to user dashboard
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "login.html";
        }
    }

    @GetMapping("/register.html")
    public String registrationForm(Model model) {
        // Add necessary attributes to the model if needed
        return "register.html"; // register.html in your templates directory
    }

    @PostMapping("/register.html")
    public String registerUser(@RequestParam String username, @RequestParam String email,
                               @RequestParam String phoneNumber, @RequestParam String password,
                               @RequestParam boolean hasCancellationInsurance, Model model) {
        boolean registered = userLoginService.register(username, email, phoneNumber, password, hasCancellationInsurance);
        if (registered) {
            return "redirect:/login.html"; // Redirect to login page after successful registration
        } else {
            model.addAttribute("registrationError", "User already exists or invalid data");
            return "register.html";
        }
    }
}

