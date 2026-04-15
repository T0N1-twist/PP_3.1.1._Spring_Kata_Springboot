package org.kata.springboot.controller;


import org.kata.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String redirectToUsers() {
        return "redirect:/users";
    }

    @GetMapping
    public String getUsersPage(Model model) {
      model.addAttribute("users", userService.getAllUsers());
      return "users";
    }


    @PostMapping("/add")
    public String addUser(@RequestParam String username,@RequestParam int age) {
        userService.addUser(username,age);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String username, @RequestParam int age) {
        userService.updateUserById(id, username, age);
        return "redirect:/users";
    }

}

