package com.example.agregioV2.offer.hexagone.models;

import java.util.Objects;

public class OfferUuid {

    private final String value;

    public OfferUuid(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferUuid offerUuid = (OfferUuid) o;
        return Objects.equals(value, offerUuid.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
