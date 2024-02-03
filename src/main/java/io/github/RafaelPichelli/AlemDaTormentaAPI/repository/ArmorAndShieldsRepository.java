package io.github.RafaelPichelli.AlemDaTormentaAPI.repository;

import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.ArmorAndShields;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.RafaelPichelli.AlemDaTormentaAPI.specs.ArmorAndShieldsSpecs.nomeLike;
import static io.github.RafaelPichelli.AlemDaTormentaAPI.specs.ArmorAndShieldsSpecs.tipoEqual;
import static io.github.RafaelPichelli.AlemDaTormentaAPI.specs.GenericSpecs.conjunction;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ArmorAndShieldsRepository extends JpaRepository<ArmorAndShields, String>, JpaSpecificationExecutor<ArmorAndShields> {

    default List<ArmorAndShields>findByNomeAndTipoLike(String nomeItem, ArmorAndShieldType tipo){
        Specification<ArmorAndShields> spec = where(conjunction());

        if (tipo != null){
            spec = spec.and(tipoEqual(tipo));
        }
        if (StringUtils.hasText(nomeItem)){
            spec = spec.and(nomeLike(nomeItem));
        }

        return findAll(spec);
    };
}
