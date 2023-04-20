package com.example.musala.entity.drone;

import com.example.musala.entity.goods.MedicationEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
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
    @Size(max = 100)
    private String serialNumber;
    private DroneType model;
    @Max(500)
    private int weight;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id")
    @ToString.Exclude
    private Set<MedicationEntity> cargo; // TODO (biggest problem) now we can add only medication cargo )) but drone should be cargo-type agnostic
    private float batteryLevel;
    private DroneState state;

}
