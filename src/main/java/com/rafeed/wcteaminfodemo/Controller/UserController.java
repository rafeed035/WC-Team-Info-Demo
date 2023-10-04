package com.rafeed.wcteaminfodemo.Controller;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.User;
import com.rafeed.wcteaminfodemo.Service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) throws EntityAlreadyExistsException {
        return userService.saveUser(user);
    }

    @GetMapping("/by-id")
    public User getUserById(@RequestParam int userId) throws EntityNotFoundException {
        return userService.getUserById(userId);
    }

    @GetMapping("/by-email")
    public User getUserByEmail(@RequestParam String email) throws EntityNotFoundException {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam int userId,
                           @RequestBody User user) throws EntityNotFoundException {
        return userService.updateUser(userId, user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public String updateUser(@RequestParam int userId) throws EntityNotFoundException {
        userService.deleteUser(userId);
        return "Deleted Successfully!";
    }
}
