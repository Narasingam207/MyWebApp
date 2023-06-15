package com.myCompany.MyWebApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
  UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model)
    {
       List<User> userList= userService.ListAll();
       model.addAttribute("userList",userList);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(@Valid User user, RedirectAttributes redirectAttributes)
    {
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","The user As been Saved Successfully.");

        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes redirectAttributes)
    {
        try {
            User user=userService.get(id);
       model.addAttribute("user",user);
       model.addAttribute("pageTitle","Edit User(Id: "+id+")");
       return  "user_form";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message","The user As been Saved Successfully.");
return  "redirect:/users";
        }
    }


    @GetMapping("/users/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes)
    {
        userService.delete(id);
        redirectAttributes.addFlashAttribute("message","User By Id: "+id+" deleted successfully");
        return "redirect:/users";
    }
}
