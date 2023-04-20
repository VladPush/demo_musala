package com.example.musala.entity.goods;

import com.example.musala.entity.drone.DroneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@MappedSuperclass
public abstract sealed class Goods permits MedicationEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DroneEntity drone;
}
