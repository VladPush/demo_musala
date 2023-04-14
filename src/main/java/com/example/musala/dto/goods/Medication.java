package com.example.musala.dto.goods;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public final class Medication extends Goods {
    private String name;
    private int weight;
    private String code;
    private byte[] image;

}