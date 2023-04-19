package com.example.musala.entity.goods;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "medication")
public final class MedicationEntity extends Goods {
    private String code;
    private byte[] image;
}