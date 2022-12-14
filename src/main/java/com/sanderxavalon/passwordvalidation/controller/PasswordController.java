package com.sanderxavalon.passwordvalidation.controller;

import com.sanderxavalon.passwordvalidation.core.common.response.Result;
import com.sanderxavalon.passwordvalidation.core.validation.PasswordValidator;
import com.sanderxavalon.passwordvalidation.entity.Config;
import com.sanderxavalon.passwordvalidation.service.ConfigService;
import com.sanderxavalon.passwordvalidation.service.PasswordValidationService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class PasswordController {

    @Autowired
    PasswordValidationService passwordValidationService;

    @Autowired
    ConfigService configService;

    @GetMapping("/getAllConfig")
    public Result getAllConfig(){
        return Result.QuickSuccess(configService.getAllConfigs());
    }

    @PostMapping("/changeMinMaxValue")
    public Result changeMinMaxValue(@RequestBody List<Config> configs){
        configService.updateConfigs(configs);
        return Result.QuickSuccess();
    }


    @PostMapping("/passwordvalidation")
    public Result passwordValidation(@RequestBody Map<String, String> parameter) {
        passwordValidationService.validatePassword(parameter.get("password"));
        return Result.QuickSuccess();
    }
}
