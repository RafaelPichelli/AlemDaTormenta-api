package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;

import java.util.List;

public interface ReferenceService {
    List<Reference> findByNome(String nome);

    Reference findById(Integer id);

    Reference save (Reference reference);
}
