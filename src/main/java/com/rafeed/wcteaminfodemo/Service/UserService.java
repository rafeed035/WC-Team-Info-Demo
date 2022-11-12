package com.rafeed.wcteaminfodemo.Service;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws EntityAlreadyExistsException;
    User getUserById(int userId) throws EntityNotFoundException;
    User getUserByEmail(String email) throws EntityNotFoundException;
    List<User> getAllUsers();
    User updateUser(int userId, User user) throws EntityNotFoundException;
    void deleteUser(int userId) throws EntityNotFoundException;
}
