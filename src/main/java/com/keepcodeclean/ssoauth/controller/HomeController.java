package com.keepcodeclean.ssoauth.controller;

import com.keepcodeclean.ssoauth.domain.User;
import com.keepcodeclean.ssoauth.service.SocialAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private SocialAuthService authService;
    
    @RequestMapping(value = "/")
    public String home(Principal principal, Model model) {
        User user = authService.extractUserFromAuthInfo(principal);
        
        model.addAttribute("user", user);
        
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }
}
