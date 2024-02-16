package io.github.RafaelPichelli.AlemDaTormentaAPI.model;

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
public class MagicSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "reference_id", referencedColumnName = "id")
    private Reference referencia;

    @Column
    private Integer pagina;
}
