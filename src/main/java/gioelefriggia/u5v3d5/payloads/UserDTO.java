package gioelefriggia.u5v3d5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    @NotBlank(message = "Il nome utente non può essere vuoto.")
    @Size(min = 4, max = 20, message = "Il nome utente deve avere tra 4 e 20 caratteri.")
    private String username;

    @NotBlank(message = "La password non può essere vuota.")
    @Size(min = 6, message = "La password deve avere almeno 6 caratteri.")
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}