package io.github.RafaelPichelli.AlemDaTormentaAPI.model;


import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.Ranges;
import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.SpellCircle;
import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.SpellType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@TODO: Falta fazer toda a persistencia desse modelo
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private SpellType tipo;

    @Column
    @Enumerated(EnumType.STRING)
    private SpellCircle circulo;

    @ManyToOne
    @JoinColumn(name = "magic_school_id", referencedColumnName = "id")
    private MagicSchool escola;

    @Column
    private String execucao;

    @Column
    @Enumerated(EnumType.STRING)
    private Ranges alcance;

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
    @OneToMany(mappedBy = "spell", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enhancement> aprimoramento;

    @ManyToOne
    @JoinColumn(name = "reference_id", referencedColumnName = "id")
    private Reference referencia;

    @Column
    private Integer pagina;
    
}
