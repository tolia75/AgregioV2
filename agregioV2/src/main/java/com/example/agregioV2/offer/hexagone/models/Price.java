package com.example.agregioV2.offer.hexagone.models;

import java.util.Objects;

public class Price {
    private final int valueInEuro;

    public Price(int valueInEuro) {
        this.valueInEuro = valueInEuro;
    }

    public static Price ofEuros(int value) {
        return new Price(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return valueInEuro == price.valueInEuro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueInEuro);
    }
}
