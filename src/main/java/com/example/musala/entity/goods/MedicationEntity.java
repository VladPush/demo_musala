package com.example.musala.entity.goods;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity(name = "medication")
public final class MedicationEntity extends Goods {

    @Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;
    private byte[] image;
}