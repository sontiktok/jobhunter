package vn.theson.jobhunter.service;


import org.springframework.stereotype.Service;
import vn.theson.jobhunter.entity.User;
import vn.theson.jobhunter.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id) {
       Optional<User> user = this.userRepository.findById(id);
       if(user.isPresent()) {
            return user.get();
       }
       return null;
    }

    public List<User> fetchListUser() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User user){
        User currentUser = this.userRepository.findById(user.getId()).get();
        if(currentUser != null) {
            currentUser.setPassword(user.getPassword());
            currentUser.setEmail(user.getEmail());
            currentUser.setName(user.getName());

            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }

    public User handleGetUserByUsername(String username) {
        return this.userRepository.findByEmail(username);
    }


}
