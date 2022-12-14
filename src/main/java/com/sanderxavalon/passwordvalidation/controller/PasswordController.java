package com.sanderxavalon.passwordvalidation.controller;

import com.sanderxavalon.passwordvalidation.core.validation.PasswordValidator;
import com.sanderxavalon.passwordvalidation.entity.Config;
import com.sanderxavalon.passwordvalidation.service.ConfigService;
import com.sanderxavalon.passwordvalidation.service.PasswordValidationService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class PasswordController {

    @Autowired
    PasswordValidationService passwordValidationService;

    @Autowired
    ConfigService configService;

    @PostMapping("/changeMinMaxValue")
    public String changeMinMaxValue(){

        return null;
    }


    @PostMapping("/passwordvalidation")
    public String passwordValidation(@RequestBody Map<String, String> parameter) {

        String password = parameter.get("password");
        System.out.println(password);
        passwordValidationService.validatePassword(password);

        return null;
    }
}
