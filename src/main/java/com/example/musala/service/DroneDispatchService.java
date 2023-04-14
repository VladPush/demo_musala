package com.example.musala.service;

import com.example.musala.dto.drone.DroneDto;
import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.dto.drone.DroneState;
import com.example.musala.repository.mock.MockDroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DroneDispatchService {

    private final MockDroneRepository repository;

    public UUID register(final DroneModelDto modelDto, final String serial) {
        DroneDto droneDto = DroneDto.builder()
                .serialNumber(serial)
                .model(modelDto)
                .batteryCapacity(100.0f)
                .state(DroneState.IDLE)
                .build();
        return repository.save(droneDto);
    }

}
