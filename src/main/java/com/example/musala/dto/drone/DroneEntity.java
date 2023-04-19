package com.example.musala.dto.drone;

import com.example.musala.dto.goods.Medication;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "drone_entity")
@EqualsAndHashCode(exclude = "cargo")
public class DroneEntity {
    @Id
    @GeneratedValue
    private long id;
    private String serialNumber;
    private DroneType model;

    private int weight;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id")
    @ToString.Exclude
    private Set<Medication> cargo; // TODO (biggest problem) now we can add only medication cargo )) but drone should be cargo-type agnostic
    private float batteryCapacity;
    private DroneState state;

}
