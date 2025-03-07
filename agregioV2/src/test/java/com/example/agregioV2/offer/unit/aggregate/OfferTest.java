package com.example.agregioV2.offer.unit.aggregate;

import com.example.agregioV2.offer.hexagone.models.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.NOON;
import static org.assertj.core.api.Assertions.assertThat;

class OfferTest {

    @Nested
    class PrimaryOfferTest {

        @Test
        void create_primary_offer_with_one_time_block() {
//         Given
            CreateOfferCommand createOfferCommand = new CreateOfferCommand(20, 1);
            OfferUuid uuid = new OfferUuid("uuid");

            //         When
            Offer result = Offer.create(createOfferCommand, uuid);

//         Then
            OfferUuid offerUuid = new OfferUuid("uuid");
            Price floorPrice = Price.ofEuros(20);
            TimeBlock dayBlock = new TimeBlock(MIDNIGHT, MIDNIGHT, floorPrice);
            List<TimeBlock> oneTimeBlock = List.of(dayBlock);
            PrimaryOffer expectedOffer = new PrimaryOffer(offerUuid, oneTimeBlock);
            assertThat(result)
                    .usingRecursiveComparison()
                    .isEqualTo(expectedOffer);
        }

        @Test
        void create_primary_offer_with_two_time_block() {
//         Given
            CreateOfferCommand createOfferCommand = new CreateOfferCommand(20, 2);
            OfferUuid uuid = new OfferUuid("uuid");

//         When
            Offer result = Offer.create(createOfferCommand, uuid);

//         Then
            OfferUuid offerUuid = new OfferUuid("uuid");
            Price floorPrice = Price.ofEuros(20);
            TimeBlock firstHalfDayBlock = new TimeBlock(MIDNIGHT, NOON, floorPrice);
            TimeBlock lastHalfDayBlock = new TimeBlock(NOON, MIDNIGHT, floorPrice);
            List<TimeBlock> twoTimeBlocks = List.of(firstHalfDayBlock, lastHalfDayBlock);
            PrimaryOffer expectedOffer = new PrimaryOffer(offerUuid, twoTimeBlocks);
            assertThat(result)
                    .usingRecursiveComparison()
                    .isEqualTo(expectedOffer);
        }
    }
}
