package io.github.RafaelPichelli.AlemDaTormentaAPI.repository;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReferenceRepository extends JpaRepository<Reference,String> {
    List<Reference> findByNomeContainingIgnoreCase(String nome);

    Reference findById(Integer id);
}
