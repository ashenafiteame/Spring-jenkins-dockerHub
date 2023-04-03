package com.example.springjenkinsdockerhub.service;

import com.example.springjenkinsdockerhub.domain.User;
import com.example.springjenkinsdockerhub.integration.EmailSender;
import com.example.springjenkinsdockerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSender emailSender;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void removeUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            emailSender.sendEmail("good buy ", user.get().getEmail());
            userRepository.deleteById(id);
        }


    }
}
