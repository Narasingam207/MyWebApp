package com.myCompany.MyWebApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> ListAll()
    {
       return (List<User>) userRepository.findAll();
    }

    public void save(User user)
    {
        userRepository.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result=userRepository.findById(id);
        if(result.isPresent())
        {
            return  result.get();
        }
         throw new UserNotFoundException("could not find the user by id "+id+"not available");
    }
    public void delete(Integer id)
    {
        userRepository.deleteById(id);
    }



}
