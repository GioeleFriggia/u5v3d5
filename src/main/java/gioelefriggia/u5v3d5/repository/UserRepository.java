package gioelefriggia.u5v3d5.repository;

import gioelefriggia.u5v3d5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Qui potresti voler aggiungere metodi per cercare gli utenti per username, ecc.
    User findByUsername(String username);
}