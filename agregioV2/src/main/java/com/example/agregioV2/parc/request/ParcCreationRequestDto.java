package com.example.agregioV2.parc.request;

import com.example.agregioV2.parc.entities.ParcDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HydraulicParcCreationRequestDto.class, name = "HYDRAULIC"),
        @JsonSubTypes.Type(value = SolarParcCreationRequestDto.class, name = "SOLAR"),
        @JsonSubTypes.Type(value = WindParcCreationRequestDto.class, name = "WIND"),
})
public interface ParcCreationRequestDto {

    Integer megaWatt();

    ParcDto toParc(String uuid);
}
