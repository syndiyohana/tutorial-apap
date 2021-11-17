package apap.tutorial.cineplux.repository;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}