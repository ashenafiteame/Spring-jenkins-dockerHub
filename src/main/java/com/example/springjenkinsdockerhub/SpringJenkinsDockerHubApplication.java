package com.example.springjenkinsdockerhub;

import com.example.springjenkinsdockerhub.domain.User;
import com.example.springjenkinsdockerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJenkinsDockerHubApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJenkinsDockerHubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.save(new User(1L, "ashenafi", "ashu", "asheanfi@gmail.com"));
        userService.save(new User(2L, "Hagos", "hagos", "hagos@gmail.com"));
        userService.save(new User(3L, "Belay", "belay", "belay@gmail.com"));
    }
}
