package gioelefriggia.u5v3d5.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import gioelefriggia.u5v3d5.model.User;
import gioelefriggia.u5v3d5.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Controlla se l'utente esiste già nel database
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Codifica la password prima di salvarla
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));


        user.setRole("ROLE_USER");

        // Salva l'utente nel database
        return userRepository.save(user);
    }

}