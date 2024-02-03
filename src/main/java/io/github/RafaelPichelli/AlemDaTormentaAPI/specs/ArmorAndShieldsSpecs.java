package io.github.RafaelPichelli.AlemDaTormentaAPI.specs;

import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.ArmorAndShields;
import org.springframework.data.jpa.domain.Specification;

public class ArmorAndShieldsSpecs {
    private ArmorAndShieldsSpecs(){}

    public static Specification<ArmorAndShields> tipoEqual(ArmorAndShieldType tipo){
        return (root, q, cb) -> cb.equal(root.get("tipo"), tipo);
    }

    public static Specification<ArmorAndShields> nomeLike(String nome){
        return (root, q, cb) -> cb.like(cb.upper(root.get("nome")),"%" + nome.toUpperCase() + "%");
    }
}