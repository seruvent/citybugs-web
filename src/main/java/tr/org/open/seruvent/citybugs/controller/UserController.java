package tr.org.open.seruvent.citybugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tr.org.open.seruvent.citybugs.model.JwtRequest;
import tr.org.open.seruvent.citybugs.model.JwtResponse;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.service.UserService;
import tr.org.open.seruvent.citybugs.util.JWTTokenUtil;

import java.util.List;

/**
 *
 *  @Controller
 *  @ResponseBody
 *      yerine sadece
 *  @RestController
 *      kullanılmıştır
 *
 *  https://stackoverflow.com/questions/25242321/difference-between-spring-controller-and-restcontroller-annotation
 */



@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    /**
     * @RequestMapping
     *  -1- Default olarak GET methodları tanımlanmıştır
     *  -2- List return etmesi durumunda JSON olarak dönmesi sağlanmıştır
     *  -3- Parametre alınabilmesi için {} kullanılır
     *  -4- Parametrenin method içerisinde kullanılabilmesi için @PathVariable unutulmamalıdır
     *  -5- @RequestBody ile JSON objesi post edilmesi durumunda addUser methodunda oldugu gibi otomatik objeleştirir
     */

    @RequestMapping("/users")
    public List<User> getAllUser(){
        return userService.getUserList();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(method=RequestMethod.POST , value="/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method=RequestMethod.PUT , value="/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        userService.updateUser(id,user);
    }

    @RequestMapping(method=RequestMethod.DELETE , value="/users/{id}" )
    public void removeUser(@PathVariable int id){
        userService.removeUser(id);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }




    @RequestMapping(method=RequestMethod.PUT, value="/test" )
    public List<User> test(){
        return userService.getUserList();
    }

}
