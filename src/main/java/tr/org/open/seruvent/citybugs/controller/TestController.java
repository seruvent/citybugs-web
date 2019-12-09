package tr.org.open.seruvent.citybugs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/getuser")
public class TestController {

    @GetMapping
    public Principal getUser(Principal user) {
        return user;
    }
}
