package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;
import io.github.RafaelPichelli.AlemDaTormentaAPI.repository.MagicSchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MagicSchoolServiceImp implements MagicSchoolService{

    private final MagicSchoolRepository magicSchoolRepository;

    @Override
    public List<MagicSchool> findByNome(String nome) {
        return magicSchoolRepository.findByNome(nome);
    }

    @Override
    public List<MagicSchool> findAll() {
        return magicSchoolRepository.findAll();
    }

    @Override
    public MagicSchool save(MagicSchool magicSchool) {
        var possibleSchool = findByNome(magicSchool.getNome());

        if (!possibleSchool.isEmpty()){
            throw new DuplicatedTupleException("Escola já existe");
        }
        return magicSchoolRepository.save(magicSchool);
    }
}
