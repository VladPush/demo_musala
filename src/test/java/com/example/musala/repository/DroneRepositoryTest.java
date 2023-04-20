package com.example.musala.repository;

import com.example.musala.entity.drone.DroneEntity;
import com.example.musala.entity.drone.DroneState;
import com.example.musala.entity.drone.DroneType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DroneRepositoryTest {

    @Autowired
    private DroneRepository droneRepository;

    @Test
    void getAllByBatteryLevelAfterAndState() {
        prepareDrones();
        List<DroneEntity> result = droneRepository.getAllByBatteryLevelAfterAndState(25, DroneState.IDLE);
        assertEquals(2, result.size());
    }

    private void prepareDrones() {
        DroneEntity droneEntity0 = droneRepository.save(DroneEntity.builder().serialNumber("SERIAL")
                .model(DroneType.LIGHTWEIGHT)
                .weight(500)
                .batteryLevel(40.0f)
                .state(DroneState.IDLE)
                .build());
        DroneEntity droneEntity1 = droneRepository.save(DroneEntity.builder().serialNumber("SERIAL")
                .model(DroneType.LIGHTWEIGHT)
                .weight(500)
                .batteryLevel(10.0f)
                .state(DroneState.IDLE)
                .build());
        DroneEntity droneEntity2 = droneRepository.save(DroneEntity.builder().serialNumber("SERIAL")
                .model(DroneType.LIGHTWEIGHT)
                .weight(500)
                .batteryLevel(100.0f)
                .state(DroneState.DELIVERED)
                .build());
        DroneEntity droneEntity3 = droneRepository.save(DroneEntity.builder().serialNumber("SERIAL")
                .model(DroneType.LIGHTWEIGHT)
                .weight(500)
                .batteryLevel(50.0f)
                .state(DroneState.IDLE)
                .build());
        droneRepository.saveAll(List.of(droneEntity0, droneEntity1, droneEntity2, droneEntity3));
    }
}