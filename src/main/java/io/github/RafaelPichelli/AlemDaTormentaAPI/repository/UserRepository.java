package io.github.RafaelPichelli.AlemDaTormentaAPI.repository;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByNomeUsuario(String nomeUsuario);
}
