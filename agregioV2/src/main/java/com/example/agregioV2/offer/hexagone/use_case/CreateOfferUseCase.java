package com.example.agregioV2.offer.hexagone.use_case;

import com.example.agregioV2.offer.hexagone.models.CreateOfferCommand;
import com.example.agregioV2.offer.hexagone.models.Offer;
import com.example.agregioV2.offer.hexagone.models.OfferUuid;
import com.example.agregioV2.offer.hexagone.port.server_side.OfferRepository;
import com.example.agregioV2.offer.hexagone.port.server_side.OfferUuidGenerator;
import com.example.agregioV2.offer.hexagone.port.user_side.CreateOffer;

public class CreateOfferUseCase implements CreateOffer {

    private final OfferUuidGenerator offerUuidGenerator;
    private final OfferRepository offerRepository;

    public CreateOfferUseCase(OfferUuidGenerator offerUuidGenerator, OfferRepository offerRepository) {
        this.offerUuidGenerator = offerUuidGenerator;
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferUuid execute(CreateOfferCommand command) {
        OfferUuid uuid = offerUuidGenerator.generate();
        Offer offer = Offer.create(command, uuid);
        offerRepository.persist(offer);
        return uuid;
    }
}
