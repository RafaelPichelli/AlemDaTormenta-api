package io.github.RafaelPichelli.AlemDaTormentaAPI.controller;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.MagicSchoolDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.mapper.MagicSchoolMapper;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;
import io.github.RafaelPichelli.AlemDaTormentaAPI.service.MagicSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/magicSchool")
@RequiredArgsConstructor
public class MagicSchoolController {

    private final MagicSchoolService magicSchoolService;

    private final MagicSchoolMapper mapper;

    @PostMapping
    public ResponseEntity save(@RequestBody MagicSchoolDto dto) {
        try {
            MagicSchool magicSchool = mapper.mapToMagicSchool(dto);
            magicSchoolService.save(magicSchool);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DuplicatedTupleException e) {
            Map<String, String> jsonResultado = Map.of("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping
    public ResponseEntity<List<MagicSchoolDto>> search(@RequestParam(value = "nome", defaultValue = "") String nome){
        List<MagicSchool> result;
        if (nome.equals("")){
            result = magicSchoolService.findAll();
        }else {
            result = magicSchoolService.findByNome(nome);
        }
        var response = result.stream().map(item-> mapper.mapToDto(item)).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
