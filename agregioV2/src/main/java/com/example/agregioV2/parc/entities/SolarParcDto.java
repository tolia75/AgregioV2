package com.example.agregioV2.parc.entities;

public record SolarParcDto(
        String id,
        Integer megaWatt
) implements ParcDto {
}