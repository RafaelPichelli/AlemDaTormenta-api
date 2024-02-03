package io.github.RafaelPichelli.AlemDaTormentaAPI.model;

import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArmorAndShields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ArmorAndShieldType tipo;

    @Column
    private String nome;

    @Column
    private Integer preco;

    @Column
    private Integer bonusDefesa;

    @Column
    private Integer penalidade;

    @Column
    private Integer espacos;

    @Column
    private String referencia;

    @CreatedDate
    @Column
    private LocalDateTime criadoEm;
}
