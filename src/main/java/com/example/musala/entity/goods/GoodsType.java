package com.example.musala.entity.goods;

public enum GoodsType {
    MEDICATION(Values.MEDICATION),
    CONSUMER_GOODS(Values.CONSUMER_GOODS);


    GoodsType(String medication) {
    }

    public static class Values {
        public static final String MEDICATION = "MEDICATION";
        public static final String CONSUMER_GOODS = "CONSUMER_GOODS";
    }
}
