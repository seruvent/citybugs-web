package tr.org.open.seruvent.citybugs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUserById(int i){
        return userRepository.findById(i).get();
    }

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(int id, User user){
        userRepository.save(user);
    }

    public void removeUser(int id){
        userRepository.deleteById(id);
    }


}


