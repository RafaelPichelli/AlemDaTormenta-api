package io.github.RafaelPichelli.AlemDaTormentaAPI.model;


import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.SpellCircle;
import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.SpellType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Spells {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private SpellType tipo;

    @Column
    @Enumerated(EnumType.STRING)
    private SpellCircle circulo;

    @Column
    private String escola; //Tem que ser uma referencia para a tabela de escolas

    @Column
    private String execucao;

    @Column
    private String alcance;

    @Column
    private String efeito;

    @Column
    private String duracao;

    @Column
    private String resistencia;

    @Column
    private String descricao;

    @Column
    private String truque;

    @Column
    private Integer aprimoramento; //Precisa apontar para os aprimoramentos que tiver.

    @Column
    private String referencia;
    
}
