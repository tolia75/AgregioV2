package com.example.agregioV2.offer.unit.port.user_side;

import com.example.agregioV2.offer.hexagone.models.CreateOfferCommand;
import com.example.agregioV2.offer.hexagone.models.Offer;
import com.example.agregioV2.offer.hexagone.models.OfferUuid;
import com.example.agregioV2.offer.hexagone.port.server_side.OfferRepository;
import com.example.agregioV2.offer.hexagone.port.server_side.OfferUuidGenerator;
import com.example.agregioV2.offer.hexagone.port.user_side.CreateOffer;
import com.example.agregioV2.offer.hexagone.use_case.CreateOfferUseCase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CreateOfferTest {

    @Test
    void it_creates_primary_offer() {
//        Given
        SpyOfferRepository offerRepository = new SpyOfferRepository();
        OfferUuidGenerator offerUuidGenerator = new OfferUuidGeneratorStub();
        CreateOffer createOffer = new CreateOfferUseCase(offerUuidGenerator, offerRepository);
        CreateOfferCommand createOfferCommand = new CreateOfferCommand(20, 2);

//        When
        OfferUuid uuid = createOffer.execute(createOfferCommand);

//        Then
        assertAll(
                () -> assertThat(uuid).isEqualTo(new OfferUuid("uuid")),
                () -> assertThat(offerRepository.persistHasBeenCalled()).isEqualTo(1)
        );
    }

    private static class OfferUuidGeneratorStub implements OfferUuidGenerator {
        @Override
        public OfferUuid generate() {
            return new OfferUuid("uuid");
        }
    }

    private static class SpyOfferRepository implements OfferRepository {
        private int count;

        public int persistHasBeenCalled() {
            return count;
        }

        @Override
        public void persist(Offer offer) {
            count++;
        }
    }
}
