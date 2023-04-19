package com.example.musala.entity.goods;

import com.example.musala.entity.drone.DroneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract sealed class Goods permits MedicationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DroneEntity drone;
}
