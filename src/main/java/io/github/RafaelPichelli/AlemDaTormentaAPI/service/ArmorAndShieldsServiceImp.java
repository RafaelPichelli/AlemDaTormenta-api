package io.github.RafaelPichelli.AlemDaTormentaAPI.service;

import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.ArmorAndShields;
import io.github.RafaelPichelli.AlemDaTormentaAPI.repository.ArmorAndShieldsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArmorAndShieldsServiceImp implements ArmorAndShieldsService{

    private final ArmorAndShieldsRepository armorAndShieldsRepository;

    @Override
    public List<ArmorAndShields> findByNomeAndTipoLike(String nomeiItem, ArmorAndShieldType tipo) {
        return armorAndShieldsRepository.findByNomeAndTipoLike(nomeiItem,tipo);
    }

    @Override
    public ArmorAndShields save(ArmorAndShields armorAndShields) {
        return armorAndShieldsRepository.save(armorAndShields);
    }
}
