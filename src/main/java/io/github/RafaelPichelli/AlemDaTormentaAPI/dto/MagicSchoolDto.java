package io.github.RafaelPichelli.AlemDaTormentaAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MagicSchoolDto {
    private String nome;
    private String descricao;
}
