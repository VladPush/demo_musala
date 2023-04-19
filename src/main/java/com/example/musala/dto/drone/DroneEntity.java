package com.example.musala.dto.drone;

import com.example.musala.dto.goods.Medication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "drone_entity")
public class DroneEntity {
    @Id
    @GeneratedValue
    private long id;
    private String serialNumber;
    private DroneType model;

    private int weight;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id")
    private Set<Medication> cargo; // TODO (biggest problem) now we can add only medication cargo )) but drone should be cargo-type agnostic
    private float batteryCapacity;
    private DroneState state;

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setState(DroneState state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
