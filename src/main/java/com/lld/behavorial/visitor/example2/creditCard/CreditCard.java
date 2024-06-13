package com.lld.behavorial.visitor.example2.creditCard;

import com.lld.behavorial.visitor.example2.offeres.OfferVisitor;

public interface CreditCard {
    String getName();
    void accept(OfferVisitor offerVisitor);

}
