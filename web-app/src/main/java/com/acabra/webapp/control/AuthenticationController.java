package com.acabra.webapp.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    static final String TEMPLATE_NAME = "login";

    @GetMapping("/login")
    public String getLogin() {
        return TEMPLATE_NAME;
    }
}
