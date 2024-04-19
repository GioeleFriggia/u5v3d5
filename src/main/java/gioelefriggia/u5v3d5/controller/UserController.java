package gioelefriggia.u5v3d5.controller;

import gioelefriggia.u5v3d5.model.User;
import gioelefriggia.u5v3d5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        // Implementazione del login
        // Nota: Spring Security normalmente gestisce il login, quindi potrebbe non essere necessario implementarlo manualmente a meno che non ci siano requisiti specifici
        return new ResponseEntity<>("Login endpoint to be implemented", HttpStatus.OK);
    }
}