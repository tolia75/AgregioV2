package com.example.agregioV2.parc.request;

import com.example.agregioV2.parc.entities.HydraulicParcDto;
import com.example.agregioV2.parc.entities.ParcDto;

public record HydraulicParcCreationRequestDto(Integer megaWatt) implements ParcCreationRequestDto {
    @Override
    public ParcDto toParc(String uuid) {
        return new HydraulicParcDto(uuid, megaWatt);
    }
}
