package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;
import io.github.RafaelPichelli.AlemDaTormentaAPI.repository.MagicSchoolRepository;
import io.github.RafaelPichelli.AlemDaTormentaAPI.repository.ReferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceServiceImp implements ReferenceService{

    private final ReferenceRepository repository;

    @Override
    public List<Reference> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Reference save(Reference reference) {
        var possibleReference = findByNome(reference.getNome());

        if (!possibleReference.isEmpty()){
            throw new DuplicatedTupleException("Referencia já existe");
        }
        return repository.save(reference);
    }
}