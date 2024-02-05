package io.github.RafaelPichelli.AlemDaTormentaAPI.mapper;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.ReferenceDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;
import org.springframework.stereotype.Component;

@Component
public class ReferenceMapper {
    public Reference mapToReference(ReferenceDto dto){
        return new Reference().builder()
                .nome(dto.getNome())
                .build();
    }

    public ReferenceDto mapToDto(Reference reference) {
        return ReferenceDto.builder()
                .nome(reference.getNome())
                .build();
    }
}
