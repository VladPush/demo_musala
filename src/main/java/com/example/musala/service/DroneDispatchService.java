package com.example.musala.service;

import com.example.musala.dto.DroneCreateDto;
import com.example.musala.dto.MedicationDto;
import com.example.musala.entity.drone.DroneEntity;
import com.example.musala.entity.drone.DroneState;
import com.example.musala.entity.product.MedicationEntity;
import com.example.musala.exception.LowBatteryException;
import com.example.musala.repository.DroneRepository;
import com.example.musala.repository.MedicationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DroneDispatchService {

    private final DroneRepository repository;
    private final MedicationRepository medicationRepository;

    public DroneEntity register(final DroneCreateDto model) {
        DroneEntity droneEntity = DroneEntity.builder()
                .serialNumber(model.serial())
                .model(model.type())
                .weight(model.maxWeight())
                .batteryLevel(100.0f)
                .state(DroneState.IDLE)
                .build();
        return repository.save(droneEntity);
    }

    private static List<MedicationEntity> mapToEntity(List<MedicationDto> goods, DroneEntity droneEntity) {
        return goods.stream()
                .map(it -> MedicationEntity.builder()
                        .name(it.name())
                        .code(it.code())
                        .image(it.image())
                        .weight(it.weight())
                        .drone(droneEntity)
                        .build()
                ).collect(Collectors.toList());
    }

    @Transactional
    public boolean load(long id, List<MedicationDto> goods) {
        DroneEntity droneEntity = repository.findById(id).get();
        if (droneEntity.getBatteryLevel() < 25.0f) {
            throw new LowBatteryException(String.format("Battery level is low for loading. Current level = %s%%", droneEntity.getBatteryLevel()));
        }
        droneEntity.setState(DroneState.LOADING);
        int maxWeight = droneEntity.getWeight();
        int additionalWeight = goods.stream().mapToInt(MedicationDto::weight).sum();
        int currentWeight = droneEntity.getCargo().stream().mapToInt(MedicationEntity::getWeight).sum();

        if (maxWeight >= additionalWeight + currentWeight) {
            List<MedicationEntity> medicationEntities = mapToEntity(goods, droneEntity);
            droneEntity.getCargo().addAll(medicationEntities);
            droneEntity.setState(DroneState.LOADED);
            return true;
        }
        return false;
    }

    public List<MedicationDto> getCargo(long id) {
        return medicationRepository.findAllByDroneId(id)
                .stream()
                .map(it -> MedicationDto.builder() // TODO replace to mapstruct
                        .id(it.getId())
                        .droneId(it.getId())
                        .image(it.getImage())
                        .code(it.getCode())
                        .weight(it.getWeight())
                        .name(it.getName())
                        .build()
                ).collect(Collectors.toList());
    }

    public List<DroneEntity> getAvailableDrones() {
        return repository.getAllByBatteryLevelAfterAndState(25, DroneState.IDLE);
    }

    public DroneEntity get(long id) {
        return repository.findById(id).get();
    }

    public float getBatteryLevel(long id) {
        return repository.getBatteryLevel(id);
    }
}
