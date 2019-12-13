package tr.org.open.seruvent.citybugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.org.open.seruvent.citybugs.model.AuthRequest;
import tr.org.open.seruvent.citybugs.model.JwtResponse;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/getuser")
    public Principal getUser(Principal user) {
        return user;
    }


    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET, value="/test" )
    public List<User> testget(){
        return userService.getUserList();
    }

    @RequestMapping(method= RequestMethod.POST, value="/test" )
    public ResponseEntity<?> testpost(@RequestBody AuthRequest authenticationRequest){
        
        String appUserId = authenticationRequest.getAppUserId();
        return ResponseEntity.ok(new JwtResponse(appUserId));
    }
}
