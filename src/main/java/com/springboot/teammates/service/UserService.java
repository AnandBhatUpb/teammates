package com.springboot.teammates.service;

import com.springboot.teammates.model.User;
import com.springboot.teammates.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userToUpdate = userRepository.findById(id);

        if (userToUpdate.isPresent()) {
            User _user = userToUpdate.get();
            _user.setFirstName(user.getFirstName());
            _user.setSurname(user.getSurname());
            _user.setPosition(user.getPosition());
            _user.setGithubProfile(user.getGithubProfile());
            return userRepository.save(_user);
        } else {
            return null;
        }
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
