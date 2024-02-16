package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;

import java.util.List;

public interface MagicSchoolService {
    List<MagicSchool> findByNome(String nome);

    MagicSchool save (MagicSchool magicSchool);
}
