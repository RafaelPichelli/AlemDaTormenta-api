package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.ArmorAndShields;

import java.util.List;

public interface ArmorAndShieldsService {
    List<ArmorAndShields> findByNomeAndTipoLike(String nomeiItem, ArmorAndShieldType tipo);

    ArmorAndShields save(ArmorAndShields armorAndShields);
}
