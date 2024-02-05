package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;

import java.util.List;

public interface MagicSchoolService {
    List<MagicSchool> findByNome(String nome);

    List<MagicSchool> findAll();
    MagicSchool save (MagicSchool magicSchool);
}
