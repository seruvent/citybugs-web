package tr.org.open.seruvent.citybugs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.model.UserRole;
import tr.org.open.seruvent.citybugs.repository.UserRepository;
import tr.org.open.seruvent.citybugs.repository.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getUserRoleList(){
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleRepository.findAll().forEach(userRoleList::add);
        return userRoleList;
    }

    public UserRole getUserRoleById(int i){
        return userRoleRepository.findById(i).get();
    }

    public void addUserRole(UserRole userRole){
        userRoleRepository.save(userRole);
    }

    public void updateUserRole(int id, UserRole userRole){
        userRoleRepository.save(userRole);
    }

    public void removeUserRole(int id){
        userRoleRepository.deleteById(id);
    }

}


