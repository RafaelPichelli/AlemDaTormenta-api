package io.github.RafaelPichelli.AlemDaTormentaAPI.controller;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.MagicSchoolDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.mapper.MagicSchoolMapper;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.MagicSchool;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;
import io.github.RafaelPichelli.AlemDaTormentaAPI.service.MagicSchoolService;
import io.github.RafaelPichelli.AlemDaTormentaAPI.service.ReferenceService;
import io.github.RafaelPichelli.AlemDaTormentaAPI.utils.TextFormatter;
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

    private final ReferenceService referenceService;

    private final MagicSchoolMapper mapper;

    @PostMapping
    public ResponseEntity save(@RequestBody MagicSchoolDto dto) {
        try {
            dto.setNome(TextFormatter.formatInput(dto.getNome()));
            dto.setDescricao(TextFormatter.formatInput(dto.getDescricao()));

            Reference referencia = referenceService.findById(dto.getReferencia());

            MagicSchool magicSchool = mapper.mapToMagicSchool(dto, referencia);
            magicSchoolService.save(magicSchool);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DuplicatedTupleException e) {
            Map<String, String> jsonResultado = Map.of("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping
    public ResponseEntity<List<MagicSchool>> search(@RequestParam(value = "nome", defaultValue = "") String nome){
        List<MagicSchool> result = magicSchoolService.findByNome(nome);

        return ResponseEntity.ok(result);
    }
}
