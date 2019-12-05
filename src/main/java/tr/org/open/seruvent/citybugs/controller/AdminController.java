package tr.org.open.seruvent.citybugs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value ="/")
    public String admin(){
        return "admin";
    }

}
