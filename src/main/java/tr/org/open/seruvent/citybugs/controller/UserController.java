package tr.org.open.seruvent.citybugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @RequestMapping
     *  -1- Default olarak GET methodları tanımlanmıştır
     *  -2- List return etmesi durumunda JSON olarak dönmesi sağlanmıştır
     *  -3- Parametre alınabilmesi için {} kullanılır
     *  -4- Parametrenin method içerisinde kullanılabilmesi için @PathVariable unutulmamalıdır
     *  -5- @RequestBody ile JSON objesi post edilmesi durumunda addUser methodunda oldugu gibi otomatik objeleştirir
     */

    @RequestMapping("users")
    public List<User> getAllUser(){
        return userService.getUserList();
    }

    @RequestMapping("users/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(method=RequestMethod.POST , value="users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method=RequestMethod.PUT , value="users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        userService.updateUser(id,user);
    }

    @RequestMapping(method=RequestMethod.DELETE , value="users/{id}" )
    public void removeUser(@PathVariable int id){
        userService.removeUser(id);
    }

}
