package io.github.RafaelPichelli.AlemDaTormentaAPI.repository;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagicSchoolRepository extends JpaRepository<MagicSchool,String> {
    List<MagicSchool> findByNome(String nome);

    List<MagicSchool> findAll();
}
