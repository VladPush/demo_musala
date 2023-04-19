package com.example.musala.service;

import com.example.musala.entity.drone.DroneEntity;
import com.example.musala.entity.drone.DroneModelDto;
import com.example.musala.entity.drone.DroneState;
import com.example.musala.entity.goods.Goods;
import com.example.musala.entity.goods.MedicationEntity;
import com.example.musala.repository.DroneRepository;
import com.example.musala.repository.MedicationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DroneDispatchService {

    private final DroneRepository repository;
    private final MedicationRepository medicationRepository;

    public DroneEntity register(final DroneModelDto model) {
        DroneEntity droneEntity = DroneEntity.builder()
                .serialNumber(model.serial())
                .model(model.type())
                .weight(model.maxWeight())
                .batteryLevel(100.0f)
                .state(DroneState.IDLE)
                .build();
        return repository.save(droneEntity);
    }

    @Transactional
    public boolean load(long id, List<MedicationEntity> goods) {
        DroneEntity droneEntity = repository.findById(id).get();
        if (droneEntity.getBatteryLevel() < 25.0f) {
            throw new IllegalStateException("Battery capacity is low for loading");
        }
        droneEntity.setState(DroneState.LOADING);
        int maxWeight = droneEntity.getWeight();
        int additionalWeight = goods.stream().mapToInt(Goods::getWeight).sum();
        int currentWeight = droneEntity.getCargo().stream().mapToInt(MedicationEntity::getWeight).sum();

        if (maxWeight >= additionalWeight + currentWeight) {
            droneEntity.getCargo().addAll(goods);
            droneEntity.setState(DroneState.LOADED);
            return true;
        }
        return false;
    }

    public List<MedicationEntity> getCargo(long id) {
        return medicationRepository.findAllByDroneId(id);
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
