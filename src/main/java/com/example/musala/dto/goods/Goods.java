package com.example.musala.dto.goods;

import com.example.musala.dto.drone.DroneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract sealed class Goods permits Medication {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DroneEntity drone;
}
