package com.example.musala.entity.product;


import com.example.musala.entity.product.core.Product;
import com.example.musala.entity.product.core.ProductType;
import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue(value = ProductType.Values.MEDICATION)
public final class MedicationEntity extends Product {

    @Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;
    private byte[] image;
}