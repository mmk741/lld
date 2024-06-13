package com.lld.behavorial.visitor.example2.offeres;

import com.lld.behavorial.visitor.example2.creditCard.BronzeCreditCard;
import com.lld.behavorial.visitor.example2.creditCard.GoldCreditCard;
import com.lld.behavorial.visitor.example2.creditCard.SilverCreditCard;

public class GasOfferVisitor implements OfferVisitor{
    @Override
    public void visit(BronzeCreditCard bronzeCreditCard) {
        System.out.println("compute cashback for bronze card buying gas");
    }

    @Override
    public void visit(SilverCreditCard silverCreditCard) {
        System.out.println("compute cashback for silver card buying gas");

    }

    @Override
    public void visit(GoldCreditCard goldCreditCard) {
        System.out.println("compute cashback for silver card buying gas");

    }
}
