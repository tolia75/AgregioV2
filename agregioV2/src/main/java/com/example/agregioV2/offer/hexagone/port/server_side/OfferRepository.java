package com.example.agregioV2.offer.hexagone.port.server_side;

import com.example.agregioV2.offer.hexagone.models.Offer;

public interface OfferRepository {

    void persist(Offer offer);
}
