package com.example.agregioV2.parc.repository;

import com.example.agregioV2.parc.entities.ParcDto;
import com.example.agregioV2.parc.request.ParcCreationRequestDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryParcRepository {

    Map<String, ParcDto> parcs = new HashMap<>();

    public void create(ParcCreationRequestDto request, String uuid) {
        ParcDto parc = request.toParc(uuid);
        parcs.put(uuid, parc);
    }

    public ParcDto findByUuid(String uuid) {
        return parcs.get(uuid);
    }
}

