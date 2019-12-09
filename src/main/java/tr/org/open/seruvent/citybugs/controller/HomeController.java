package tr.org.open.seruvent.citybugs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value ="index")
    public String index(){
        return "welcome/index";
    }

    @RequestMapping(value ="document")
    public String document(){
        return "welcome/document";
    }

    @RequestMapping(value ="terms-conditions")
    public String termsConditions(){
        return "welcome/terms-conditions";
    }

    @RequestMapping(value ="privacy-policy")
    public String privacyPolicy(){
        return "welcome/privacy-policy";
    }

    @RequestMapping(value ="login")
    public String login(){
        return "login";
    }

    @GetMapping
    public Principal getUser(Principal user) {
        return user;
    }
}
