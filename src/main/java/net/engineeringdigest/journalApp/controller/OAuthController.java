package net.engineeringdigest.journalApp.controller;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OAuthController extends SimpleUrlAuthenticationSuccessHandler {
    @GetMapping("/login/google")
    public String redirectToGoogle() {
        return "redirect:/oauth2/authorization/google";
    }
}

