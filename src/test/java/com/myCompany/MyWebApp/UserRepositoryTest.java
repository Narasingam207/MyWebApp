package com.myCompany.MyWebApp;

import com.myCompany.MyWebApp.user.User;
import com.myCompany.MyWebApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testAddOne()
    {
        User user= new User();
        user.setEmail("sanna@gmail.com");
        user.setPassword("I Wont Say");
        user.setFirstName("uppuluru");
        user.setLastName("prasanna");
     User savedUser=   userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }
    @Test
    public void testListAll()
    {
    Iterable<User>  users=  userRepository.findAll();
    Assertions.assertThat(users).hasSizeGreaterThan(0);
    for (User user:users)
    {
        System.out.println(user);
    }
    }

    @Test
    public void testUpdate()
    {
        Integer userId=1;
     Optional<User> userOptional= userRepository.findById(userId);
     User user= userOptional.get();
     user.setPassword("i will say");
     userRepository.save(user);
     User updateUser= userRepository.findById(userId).get();
     Assertions.assertThat(updateUser.getPassword()).isEqualTo("i will say");
    }
    @Test
    public void testGet()
    {
        Integer userId=1    ;
        Optional<User> optionalUser=userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

   /* @Test
    public void testDelete()
    {
        Integer userId=1;
        userRepository.deleteById(userId);
     Optional<User> optionalUser=userRepository.findById(userId);
     Assertions.assertThat(optionalUser).isNotPresent();

    }*/
}
