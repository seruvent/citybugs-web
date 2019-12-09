package tr.org.open.seruvent.citybugs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.repository.UserRepository;
import tr.org.open.seruvent.citybugs.repository.UserRoleRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

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
        user.setRole(userRoleRepository.findById(1).get());
        userRepository.save(user);
    }

    public void addUser(User user , int roleId){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(userRoleRepository.findById(roleId).get());
        userRepository.save(user);
    }

    public void updateUser(int id, User user){
        userRepository.save(user);
    }

    public void removeUser(int id){
        userRepository.deleteById(id);
    }


    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String userEmail){
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserBuilder builder = null;
        User user = userRepository.findByUsername(username);

        if (user==null) {
            throw new UsernameNotFoundException(username);
        }else{
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.roles(user.getRole().getName());
        }

        return builder.build();
    }


}


