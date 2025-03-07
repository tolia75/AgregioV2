package com.example.agregioV2.offer.hexagone.models;

import java.util.List;
import java.util.Objects;

public abstract class Offer {

    private final OfferUuid uuid;
    private final List<TimeBlock> timeBlocks;

    protected Offer(OfferUuid uuid, List<TimeBlock> timeBlocks) {
        this.uuid = uuid;
        this.timeBlocks = timeBlocks;
    }

    public static Offer create(CreateOfferCommand command, OfferUuid uuid) {
        Price floorPrice = new Price(command.floorPrice());
        List<TimeBlock> timeBlocks = TimeBlock.createTimeBlocks(command.blocksNumber(), floorPrice);
        return new PrimaryOffer(uuid, timeBlocks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(uuid, offer.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
