package com.example.musala.service;

import com.example.musala.dto.MedicationDto;
import com.example.musala.entity.drone.DroneEntity;
import com.example.musala.entity.drone.DroneState;
import com.example.musala.entity.drone.DroneType;
import com.example.musala.entity.goods.MedicationEntity;
import com.example.musala.exception.LowBatteryException;
import com.example.musala.repository.DroneRepository;
import com.example.musala.repository.MedicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@DataJpaTest // TODO do we need it?
@SpringBootTest
class DroneDispatchServiceTest {

    @Autowired
    private DroneDispatchService service;

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;


    @Test
    void loadSuccessful() {
        DroneEntity droneEntity = prepareDrone();

        boolean result = service.load(droneEntity.getId(), List.of(MedicationDto.builder().weight(150).build()));

        int size = medicationRepository.findAllByDroneId(droneEntity.getId()).size();

        assertEquals(2, size);
        assertTrue(result);
    }

    @Test
    void loadOverload() {
        DroneEntity droneEntity = prepareDrone();

        boolean result = service.load(droneEntity.getId(), List.of(MedicationDto.builder().weight(350).build()));

        int size = medicationRepository.findAllByDroneId(droneEntity.getId()).size();

        assertEquals(1, size);
        assertFalse(result);
    }


    @Test
    void loadLowBattery() {
        DroneEntity droneEntity = prepareDrone(20);

        LowBatteryException thrown = Assertions.assertThrows(LowBatteryException.class, () -> {
            service.load(droneEntity.getId(), List.of(MedicationDto.builder().weight(0).build()));
        });

        Assertions.assertEquals("Battery level is low for loading. Current level = 20.0%", thrown.getMessage());
    }

    private DroneEntity prepareDrone() {
        return prepareDrone(100.0f);
    }

    private DroneEntity prepareDrone(float batteryLevel) {
        DroneEntity droneEntity = droneRepository.save(DroneEntity.builder().serialNumber("SERIAL")
                .model(DroneType.LIGHTWEIGHT)
                .weight(500)
                .batteryLevel(batteryLevel)
                .state(DroneState.IDLE)
                .build());
        droneRepository.save(droneEntity);
        MedicationEntity medicationEntity = MedicationEntity.builder()
                .weight(300)
                .drone(droneEntity)
                .build();
        medicationRepository.save(medicationEntity);
        return droneEntity;
    }
}