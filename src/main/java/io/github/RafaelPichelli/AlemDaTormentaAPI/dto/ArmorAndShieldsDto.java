package io.github.RafaelPichelli.AlemDaTormentaAPI.dto;

import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArmorAndShieldsDto {
    private ArmorAndShieldType tipo;
    private String nome;
    private Integer preco;
    private Integer bonusDefesa;
    private Integer penalidade;
    private Integer espacos;
    private String referencia;

}
