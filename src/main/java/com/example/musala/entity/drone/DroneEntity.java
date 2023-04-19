package com.example.musala.entity.drone;

import com.example.musala.entity.goods.MedicationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "drone")
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
    private Set<MedicationEntity> cargo; // TODO (biggest problem) now we can add only medication cargo )) but drone should be cargo-type agnostic
    private float batteryLevel;
    private DroneState state;

}
