package com.supreeth.spense.user;

import com.supreeth.spense.exceptions.SpenseAuthException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) throws SpenseAuthException {
        try {
            if (email != null) {
                email = email.toLowerCase();
            }

            User user = userRepository.findByEmail(email);
            if (!BCrypt.checkpw(password, user.getPassword())) {
                throw new SpenseAuthException("Incorrect credentials.");
            }
            return user;
        } catch (Exception e) {
            throw new SpenseAuthException("Incorrect credentials.");
        }
    }

    public User register(String firstName, String lastName, String email, String password) throws SpenseAuthException {
        try {
            Pattern pattern = Pattern.compile("^(.+)@(.+)$");

            if (email != null) {
                email = email.toLowerCase();
            }

            if (!pattern.matcher(email).matches()) {
                throw new SpenseAuthException("Invalid email format");
            }

            User existing_user = userRepository.findByEmail(email);

            if (existing_user != null) {
                throw new SpenseAuthException("Email already exists.");
            }

            User user = new User(firstName, lastName, email, password);
            String encrypted_pwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
            user.setPassword(encrypted_pwd);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new SpenseAuthException("Email already exists.");
        }
    }

}
