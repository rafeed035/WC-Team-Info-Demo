package com.rafeed.wcteaminfodemo.Controller;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.User;
import com.rafeed.wcteaminfodemo.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody @Valid User user) throws EntityAlreadyExistsException {
        return userService.saveUser(user);
    }

    @GetMapping("/getById")
    public User getUserById(@RequestParam int userId) throws EntityNotFoundException {
        return userService.getUserById(userId);
    }

    @GetMapping("/getByEmail")
    public User getUserByEmail(@RequestParam @Valid String email) throws EntityNotFoundException {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam int userId,
                           @RequestBody @Email User user) throws EntityNotFoundException {
        return userService.updateUser(userId, user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public String updateUser(@RequestParam int userId) throws EntityNotFoundException {
        userService.deleteUser(userId);
        return "Deleted Successfully!";
    }
}
