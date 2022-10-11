package com.example.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    ///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("login/{name}")
    public String gotoLoginPage(@PathVariable String name, ModelMap modelMap) {
        logger.debug("Path variable {}",name);
        modelMap.put("name", name);
        return "login";
    }
}
