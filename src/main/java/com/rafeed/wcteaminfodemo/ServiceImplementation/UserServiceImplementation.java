package com.rafeed.wcteaminfodemo.ServiceImplementation;

import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import com.rafeed.wcteaminfodemo.Enity.User;
import com.rafeed.wcteaminfodemo.Repository.UserRepository;
import com.rafeed.wcteaminfodemo.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository,
                                     PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //save
    @Override
    public User saveUser(User user) throws EntityAlreadyExistsException {
        User checkUser = userRepository.getUserByEmailIgnoreCase(user.getEmail());
        if(checkUser != null){
            throw new EntityAlreadyExistsException("User with email: " + user.getEmail() + " already exists!");
        }
        else{
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            checkUser = user;
            checkUser.setPassword(encodedPassword);
            return userRepository.save(checkUser);
        }
    }

    //get user by id
    @Override
    public User getUserById(int userId) throws EntityNotFoundException {
        User checkUser = userRepository.getUserByUserId(userId);
        if(checkUser == null){
            throw new EntityNotFoundException("User with id: " + userId + " does not exist!");
        }
        return checkUser;
    }

    //get user by email
    @Override
    public User getUserByEmail(String email) throws EntityNotFoundException {
        User checkUser = userRepository.getUserByEmailIgnoreCase(email);
        if(checkUser == null){
            throw new EntityNotFoundException("User with email: " + email + " does not exist!");
        }
        return checkUser;
    }

    //get all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //update
    @Override
    public User updateUser(int userId, User user) throws EntityNotFoundException {
        User checkUser = userRepository.getUserByUserId(userId);
        if(checkUser == null){
            throw new EntityNotFoundException("User with id: " + userId + " does not exist!");
        }
        else{
            checkUser.setEmail(user.getEmail());
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            checkUser.setPassword(encodedPassword);
            return userRepository.save(checkUser);
        }
    }

    //delete
    @Override
    public void deleteUser(int userId) throws EntityNotFoundException {
        User checkUser = userRepository.getUserByUserId(userId);
        if(checkUser == null){
            throw new EntityNotFoundException("User with id: " + userId + " does not exist!");
        }
        userRepository.delete(checkUser);
    }
}
