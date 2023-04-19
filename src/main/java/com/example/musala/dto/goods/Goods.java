package com.example.musala.dto.goods;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract sealed class Goods permits Medication {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int weight;
}
