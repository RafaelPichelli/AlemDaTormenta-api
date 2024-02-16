package io.github.RafaelPichelli.AlemDaTormentaAPI.mapper;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.MagicSchoolDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;
import org.springframework.stereotype.Component;

@Component
public class MagicSchoolMapper {

    public MagicSchool mapToMagicSchool(MagicSchoolDto dto, Reference referencia){
        return new MagicSchool().builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .referencia(referencia)
                .pagina(dto.getPagina())
                .build();
    }

    public MagicSchoolDto mapToDto(MagicSchool item) {
        return MagicSchoolDto.builder()
                .nome(item.getNome())
                .descricao(item.getDescricao())
                .build();
    }
}
