package com.lld.behavorial.visitor.example2.creditCard;

import com.lld.behavorial.visitor.example2.offeres.OfferVisitor;

public class SilverCreditCard implements CreditCard{
    @Override
    public String getName() {
        return "Silver";
    }

    @Override
    public void accept(OfferVisitor offerVisitor) {
        offerVisitor.visit(this);
    }
}
