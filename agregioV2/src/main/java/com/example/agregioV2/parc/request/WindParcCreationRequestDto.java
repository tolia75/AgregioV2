package com.example.agregioV2.parc.request;

import com.example.agregioV2.parc.entities.ParcDto;
import com.example.agregioV2.parc.entities.WindParcDto;

public record WindParcCreationRequestDto(Integer megaWatt) implements ParcCreationRequestDto {
    @Override
    public ParcDto toParc(String uuid) {
        return new WindParcDto(uuid, megaWatt);
    }
}
