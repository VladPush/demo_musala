package com.example.musala.dto.goods;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "medication")
public final class Medication extends Goods {
    private String name;
    private int weight;
    private String code;
    private byte[] image;
    @Id
    @GeneratedValue
    private Long id;

}