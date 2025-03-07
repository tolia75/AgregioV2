package com.example.agregioV2.offer.hexagone.models;

import java.util.List;

public class PrimaryOffer extends Offer {
    public PrimaryOffer(OfferUuid uuid, List<TimeBlock> timeBlocks) {
        super(uuid, timeBlocks);
    }
}