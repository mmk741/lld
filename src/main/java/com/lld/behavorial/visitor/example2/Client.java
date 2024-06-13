package com.lld.behavorial.visitor.example2;

import com.lld.behavorial.visitor.example2.creditCard.BronzeCreditCard;
import com.lld.behavorial.visitor.example2.creditCard.CreditCard;
import com.lld.behavorial.visitor.example2.offeres.HotelOfferVisitor;
import com.lld.behavorial.visitor.example2.offeres.OfferVisitor;

public class Client {
    public static void main(String[] args) {
        OfferVisitor hotelOfferVisitor=new HotelOfferVisitor();

        CreditCard bronzeCreditCard=new BronzeCreditCard();

        bronzeCreditCard.accept(hotelOfferVisitor);
    }
}
