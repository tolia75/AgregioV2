package com.example.agregioV2.offer.hexagone.port.user_side;

import com.example.agregioV2.offer.hexagone.models.CreateOfferCommand;
import com.example.agregioV2.offer.hexagone.models.OfferUuid;

public interface CreateOffer {
    OfferUuid execute(CreateOfferCommand command);

}
