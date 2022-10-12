package com.example.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class LoginController {

    ///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("login")
    public String gotoLoginPage() {
        return "login";
    }


    @PostMapping(value="login")
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password, ModelMap model) {

        if(authenticationService.authenticate(name, password)) {

            model.put("name", name);
            return "welcome";
        }
        model.put("errorMessage","Invalid credential");
        return "login";
    }
}
