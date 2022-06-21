package com.revature.yolp.user;

import com.revature.yolp.auth.TokenService;
import com.revature.yolp.auth.dtos.responses.Principal;
import com.revature.yolp.common.util.web.Authenticated;
import com.revature.yolp.common.util.web.Secured;
import com.revature.yolp.user.dtos.requests.NewUserRequest;
import com.revature.yolp.common.custom_exceptions.InvalidRequestException;
import com.revature.yolp.common.custom_exceptions.ResourceConflictException;
import com.revature.yolp.common.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Inject
    private final UserService userService;

    @Inject
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @CrossOrigin
    @GetMapping
    public @ResponseBody List<User> getAllUsers(HttpServletResponse resp) {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody NewUserRequest request) {
        return userService.register(request).getId();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 409);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleBadRequestException(InvalidRequestException e) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }
}
