package tr.org.open.seruvent.citybugs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping(value ="/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value ="/document")
    public String document(){
        return "document";
    }

    @RequestMapping(value ="/terms-conditions")
    public String termsConditions(){
        return "terms-conditions";
    }

    @RequestMapping(value ="/privacy-policy")
    public String privacyPolicy(){
        return "privacy-policy";
    }

}
