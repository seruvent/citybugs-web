package tr.org.open.seruvent.citybugs.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value ="/")
    public String admin(){
        return "admin/index";
    }

    @RequestMapping(value ="/profile")
    public String profile(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("username" , currentPrincipalName);
        return "admin/profile";
    }

    @RequestMapping(value ="/profile/1")
    public String profileDetail(Principal principal,ModelMap model){

        model.addAttribute("username" ,  principal.getName());
        return "admin/profile";
    }


    @RequestMapping(value = "/profile/2")
    public String currentUserName(Authentication authentication,ModelMap model) {
        model.addAttribute("username" , authentication.getName());
        return "admin/profile";
    }
}
