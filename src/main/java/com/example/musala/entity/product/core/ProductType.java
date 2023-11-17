package com.example.musala.entity.product.core;

public enum ProductType {
    MEDICATION(Values.MEDICATION),
    CONSUMER_GOODS(Values.CONSUMER_GOODS);


    ProductType(String medication) {
    }

    public static class Values {
        public static final String MEDICATION = "MEDICATION";
        public static final String CONSUMER_GOODS = "CONSUMER_GOODS";
    }
}
