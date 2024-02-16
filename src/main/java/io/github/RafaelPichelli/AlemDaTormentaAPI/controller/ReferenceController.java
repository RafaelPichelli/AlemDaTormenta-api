package io.github.RafaelPichelli.AlemDaTormentaAPI.controller;

import io.github.RafaelPichelli.AlemDaTormentaAPI.dto.ReferenceDto;
import io.github.RafaelPichelli.AlemDaTormentaAPI.exception.DuplicatedTupleException;
import io.github.RafaelPichelli.AlemDaTormentaAPI.mapper.ReferenceMapper;
import io.github.RafaelPichelli.AlemDaTormentaAPI.model.Reference;
import io.github.RafaelPichelli.AlemDaTormentaAPI.service.ReferenceService;
import io.github.RafaelPichelli.AlemDaTormentaAPI.utils.TextFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reference")
@RequiredArgsConstructor
public class ReferenceController {

    private final ReferenceService service;
    private final ReferenceMapper mapper;
    @PostMapping
    public ResponseEntity save(@RequestBody ReferenceDto dto){
        try {
            dto.setNome(TextFormatter.formatInput(dto.getNome()));
            Reference reference = mapper.mapToReference(dto);
            service.save(reference);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (DuplicatedTupleException e){
            Map<String, String> jsonResultado = Map.of("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping
    public ResponseEntity<List<Reference>> search(@RequestParam(name = "nome") String nome){
        var result = service.findByNome(nome);

        return ResponseEntity.ok(result);
    }

}
