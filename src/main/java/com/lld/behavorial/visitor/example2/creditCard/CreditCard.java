package com.lld.behavorial.visitor.example2.creditCard;

import com.lld.behavorial.visitor.example2.offeres.OfferVisitor;

public interface CreditCard {
    String getName();

    //accepts the operation
    void accept(OfferVisitor offerVisitor);

}
