package com.supreeth.spense.user;

import com.supreeth.spense.exceptions.SpenseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Validated @RequestBody Map<String, Object> userMap) {
        String first_name = (String) userMap.get("firstName");
        String last_name = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        Map<String, String> map = new HashMap<>();
        if (this.userService.register(first_name, last_name, email, password) != null) {
            map.put("message", "User registered successfully");
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Validated @RequestBody Map<String,Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.login(email,password);
        Map<String, String> map = new HashMap<>();
        map.put("message","Logged in successfully");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
