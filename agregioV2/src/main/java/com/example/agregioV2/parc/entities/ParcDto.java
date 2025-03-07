package com.example.agregioV2.parc.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HydraulicParcDto.class, name = "HYDRAULIC"),
        @JsonSubTypes.Type(value = SolarParcDto.class, name = "SOLAR"),
        @JsonSubTypes.Type(value = WindParcDto.class, name = "WIND")
})
public interface ParcDto {
    String id();

    Integer megaWatt();

}