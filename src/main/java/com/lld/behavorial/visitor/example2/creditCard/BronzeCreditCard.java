package com.lld.behavorial.visitor.example2.creditCard;

import com.lld.behavorial.visitor.example2.offeres.OfferVisitor;

public class BronzeCreditCard implements CreditCard{
    @Override
    public String getName() {
        return "Bronze";
    }

    @Override
    public void accept(OfferVisitor offerVisitor) {
        offerVisitor.visit(this);
    }
}
