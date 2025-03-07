package com.example.agregioV2.parc.entities;

public record HydraulicParcDto(
        String id,
        Integer megaWatt
) implements ParcDto {
}