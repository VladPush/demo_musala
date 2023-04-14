package com.example.musala.dto.drone;

import com.example.musala.dto.goods.Medication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class DroneDto {
    private final DroneModelDto model;
    private String serialNumber;
    private float batteryCapacity;
    private DroneState state;

    private List<Medication> load;


}
