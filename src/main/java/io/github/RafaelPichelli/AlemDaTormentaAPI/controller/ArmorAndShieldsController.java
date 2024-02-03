package io.github.RafaelPichelli.AlemDaTormentaAPI.controller;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.ArmorAndShieldsDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.UserDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.enums.ArmorAndShieldType;
import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.mapper.ArmorAndShieldsMapper;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.ArmorAndShields;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.User;
import io.github.RafaelPichelli.AlemDaTormentaAPI.service.ArmorAndShieldsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/armorAndShields")
@RequiredArgsConstructor
public class ArmorAndShieldsController {

    private final ArmorAndShieldsService service;
    private final ArmorAndShieldsMapper mapper;

    @PostMapping
    public ResponseEntity save(@RequestBody ArmorAndShieldsDto dto){
        ArmorAndShields item = mapper.mapToArmorAndShields(dto);
        service.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ArmorAndShieldsDto>> search(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                                           @RequestParam(value = "tipo", required = false, defaultValue = "") String tipo){
        var result = service.findByNomeAndTipoLike(nome, ArmorAndShieldType.ofName(tipo));

        var response = result.stream().map(item -> mapper.mapToDto(item)).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
