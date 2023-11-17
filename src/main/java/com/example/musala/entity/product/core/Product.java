package com.example.musala.entity.product.core;

import com.example.musala.entity.drone.DroneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.DiscriminatorType.STRING;
import static jakarta.persistence.InheritanceType.JOINED;

@Data
@Inheritance(strategy = JOINED)
@DiscriminatorColumn(name = "productType", discriminatorType = STRING)
@SuperBuilder
@NoArgsConstructor
@Entity
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(insertable = false, updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DroneEntity drone;
}
