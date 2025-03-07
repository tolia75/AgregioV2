package com.example.agregioV2.parc;

import com.example.agregioV2.parc.entities.ParcDto;
import com.example.agregioV2.parc.repository.InMemoryParcRepository;
import com.example.agregioV2.parc.request.ParcCreationRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/parc")
class ParcController {

    private final InMemoryParcRepository inMemoryParcRepository;

    public ParcController(InMemoryParcRepository inMemoryParcRepository) {
        this.inMemoryParcRepository = inMemoryParcRepository;
    }

    @PostMapping
    ResponseEntity<String> create(@RequestBody ParcCreationRequestDto requestDto) {
        String uuid = UUID.randomUUID().toString();
        inMemoryParcRepository.create(requestDto, uuid);
        return new ResponseEntity<>(uuid, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    ResponseEntity<ParcDto> get(@PathVariable("uuid") String uuid) {
        ParcDto parc = inMemoryParcRepository.findByUuid(uuid);
        return ResponseEntity.ok(parc);
    }
}
