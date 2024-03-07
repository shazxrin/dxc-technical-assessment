package me.shazxrin.dxctechnicalassessment.controller;

import me.shazxrin.dxctechnicalassessment.model.AppUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getIndex(@AuthenticationPrincipal AppUserDetails appUserDetails, Model model) {
        model.addAttribute(appUserDetails);
        return "home";
    }
}
