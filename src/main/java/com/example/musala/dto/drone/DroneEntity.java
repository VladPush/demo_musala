package com.example.musala.dto.drone;

import com.example.musala.dto.goods.Medication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class DroneEntity {

    private final String serialNumber;
    private final DroneModelDto model;
    private final List<Medication> cargo; // TODO (biggest problem) now we can add only medication cargo )) but drone should be cargo-type agnostic
    private float batteryCapacity;
    private DroneState state;
    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}
