package com.example.springjenkinsdockerhub;

import com.example.springjenkinsdockerhub.domain.User;
import com.example.springjenkinsdockerhub.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJenkinsDockerHubApplicationTests {

    @Autowired
    private UserService userService;
   @Test
    public void testUserCreation(){
       User user=new User(99L,"hello","world","hello@World.com");
       userService.save(user);
       assertEquals(user,userService.findById(user.getUserId()));
   }


}
