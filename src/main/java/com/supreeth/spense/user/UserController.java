package com.supreeth.spense.user;

import com.supreeth.spense.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
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
        User user = this.userService.register(first_name, last_name, email, password);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Validated @RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.login(email, password);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.SECRET_KEY).
                setIssuedAt(new Date(timestamp)).setExpiration(new Date(timestamp + Constants.TOKEN_EXPIRY))
                .claim("user_id", user.getId())
                .claim("email", user.getEmail())
                .claim("first_name", user.getFirstName())
                .claim("last_name", user.getLastName()).compact();
        Map<String, String> map = new HashMap();
        map.put("token", token);
        return map;
    }
}
