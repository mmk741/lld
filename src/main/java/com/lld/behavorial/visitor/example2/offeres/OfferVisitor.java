package com.lld.behavorial.visitor.example2.offeres;

import com.lld.behavorial.visitor.example2.creditCard.BronzeCreditCard;
import com.lld.behavorial.visitor.example2.creditCard.GoldCreditCard;
import com.lld.behavorial.visitor.example2.creditCard.SilverCreditCard;

public interface OfferVisitor {
    void visit(BronzeCreditCard bronzeCreditCard);
    void visit(SilverCreditCard silverCreditCard);
    void visit(GoldCreditCard goldCreditCard);
}
