package me.shazxrin.dxctechnicalassessment.controller;

import jakarta.validation.Valid;
import me.shazxrin.dxctechnicalassessment.dto.RegisterAppUserDto;
import me.shazxrin.dxctechnicalassessment.exception.UserExistsException;
import me.shazxrin.dxctechnicalassessment.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class AuthController {
    private final AppUserService appUserService;
    private final MessageSource messageSource;

    @Autowired
    public AuthController(AppUserService appUserService, MessageSource messageSource) {
        this.appUserService = appUserService;
        this.messageSource = messageSource;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("registerAppUserDto", new RegisterAppUserDto());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(
            @ModelAttribute @Valid RegisterAppUserDto registerAppUserDto,
            BindingResult bindingResult,
            Locale locale
    ) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            appUserService.registerUser(
                    registerAppUserDto.getName(),
                    registerAppUserDto.getUsername(),
                    registerAppUserDto.getPassword(),
                    registerAppUserDto.getAppUserAuthority()
            );
        } catch (UserExistsException e) {
            bindingResult.addError(
                    new FieldError(
                            "registerAppUserDto",
                            "username",
                            messageSource.getMessage("auth.register.error-username-taken", null, locale)
                    )
            );

            return "register";
        }

        return "registerSuccess";
    }
}
