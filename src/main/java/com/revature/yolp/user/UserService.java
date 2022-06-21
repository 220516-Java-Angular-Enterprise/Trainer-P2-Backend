package com.revature.yolp.user;

import com.revature.yolp.auth.dtos.requests.LoginRequest;
import com.revature.yolp.user.dtos.requests.NewUserRequest;
import com.revature.yolp.common.annotations.Inject;
import com.revature.yolp.common.custom_exceptions.AuthenticationException;
import com.revature.yolp.common.custom_exceptions.InvalidRequestException;
import com.revature.yolp.common.custom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/* Purpose: validation ie. checks username, password, and retrieve data from our daos. */
@Service
@Transactional
public class UserService {

    @Inject
    private final UserRepository userRepo;

    @Inject
    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    public User login(LoginRequest request) {
        User user = null;
        if (!isValidUsername(request.getUsername()) || !isValidPassword(request.getPassword())) throw new InvalidRequestException("Invalid username or password");
        user = userRepo.getUserByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user == null) throw new AuthenticationException("Invalid credentials provided!");
        return user;
    }

    public User register(NewUserRequest request) {
        User user = request.extractUser();

        if (isNotDuplicateUsername(user.getUsername())) {
            if (isValidUsername(user.getUsername())) {
                if (isValidPassword(user.getPassword())) {
                    user.setId(UUID.randomUUID().toString());
                    userRepo.saveUser(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
                } else throw new InvalidRequestException("Invalid password. Minimum eight characters, at least one letter, one number and one special character.");
            } else throw new InvalidRequestException("Invalid username. Username needs to be 8-20 characters long.");
        } else throw new ResourceConflictException("Username is already taken :(");

        return user;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

//    public List<User> getUserByUsername(String name) {
//        return userDAO.getUsersByUsername(name);
//    }

    private boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    private boolean isNotDuplicateUsername(String username) {
        return !userRepo.getAllUsername().contains(username);
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
