package io.github.RafaelPichelli.AlemDaTormentaAPI.mapper;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.ArmorAndShieldsDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.ArmorAndShields;
import org.springframework.stereotype.Component;

@Component
public class ArmorAndShieldsMapper {

    public ArmorAndShieldsDto mapToDto(ArmorAndShields armorAndShields){
        return   ArmorAndShieldsDto.builder()
                .tipo(armorAndShields.getTipo())
                .nome(armorAndShields.getNome())
                .preco(armorAndShields.getPreco())
                .bonusDefesa(armorAndShields.getBonusDefesa())
                .penalidade(armorAndShields.getPenalidade())
                .espacos(armorAndShields.getEspacos())
                .referencia(armorAndShields.getReferencia())
                .build();
    }

    public ArmorAndShields mapToArmorAndShields(ArmorAndShieldsDto dto) {
        return   ArmorAndShields.builder()
                .tipo(dto.getTipo())
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .bonusDefesa(dto.getBonusDefesa())
                .penalidade(dto.getPenalidade())
                .espacos(dto.getEspacos())
                .referencia(dto.getReferencia())
                .build();
    }
}
