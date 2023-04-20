package com.example.musala.entity.goods;

import com.example.musala.entity.drone.DroneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;

@Data
@Inheritance(strategy = SINGLE_TABLE) //TODO INHERITANCE USAGE FOR FUTURE
@DiscriminatorColumn(name = "goodsType",
        discriminatorType = DiscriminatorType.STRING)
@SuperBuilder
@NoArgsConstructor
@Entity
public abstract class Goods {
    @Id
    @GeneratedValue
    private Long id;

    @Column(insertable = false, updatable = false, nullable = false)
    private String goodsType;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;
    private int weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DroneEntity drone;
}
