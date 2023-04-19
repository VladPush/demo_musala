package com.example.musala.dto.goods;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "medication")
public final class Medication extends Goods {
    private String code;
    private byte[] image;
}