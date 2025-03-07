package com.example.agregioV2.parc.entities;

public record WindParcDto(
        String id,
        Integer megaWatt
) implements ParcDto {
}