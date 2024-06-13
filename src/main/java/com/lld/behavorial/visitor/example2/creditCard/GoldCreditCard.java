package com.lld.behavorial.visitor.example2.creditCard;

import com.lld.behavorial.visitor.example2.offeres.OfferVisitor;

public class GoldCreditCard implements CreditCard{
    @Override
    public String getName() {
        return "Gold";
    }

    @Override
    public void accept(OfferVisitor offerVisitor) {
        offerVisitor.visit(this);
    }
}
