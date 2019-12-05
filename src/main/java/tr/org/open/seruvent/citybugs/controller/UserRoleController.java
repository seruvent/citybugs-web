package tr.org.open.seruvent.citybugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.org.open.seruvent.citybugs.model.UserRole;
import tr.org.open.seruvent.citybugs.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/user/roles")
    public List<UserRole> getAllUserRoles(){
        return userRoleService.getUserRoleList();
    }

    @RequestMapping("/user/role/{id}")
    public UserRole getUser(@PathVariable int id){
        return userRoleService.getUserRoleById(id);
    }

    @RequestMapping(method=RequestMethod.POST , value="/user/roles")
    public void addUser(@RequestBody UserRole userRole){
        userRoleService.addUserRole(userRole);
    }

    @RequestMapping(method=RequestMethod.PUT , value="/user/roles/{id}")
    public void updateUser(@RequestBody UserRole userRole, @PathVariable int id){
        userRoleService.updateUserRole(id,userRole);
    }

    @RequestMapping(method=RequestMethod.DELETE , value="/user/roles/{id}" )
    public void removeUser(@PathVariable int id){
        userRoleService.removeUserRole(id);
    }

}
