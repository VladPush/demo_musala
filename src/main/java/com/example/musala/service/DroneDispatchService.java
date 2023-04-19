package com.example.musala.service;

import com.example.musala.dto.drone.DroneEntity;
import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.dto.drone.DroneState;
import com.example.musala.dto.goods.Goods;
import com.example.musala.dto.goods.Medication;
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
    public boolean load(long id, List<Medication> goods) {
        DroneEntity droneEntity = repository.findById(id).get();
        if (droneEntity.getBatteryLevel() < 25.0f) {
            throw new IllegalStateException("Battery capacity is low for loading");
        }
        droneEntity.setState(DroneState.LOADING);
        int maxWeight = droneEntity.getWeight();
        int additionalWeight = goods.stream().mapToInt(Goods::getWeight).sum();
        int currentWeight = droneEntity.getCargo().stream().mapToInt(Medication::getWeight).sum();

        if (maxWeight >= additionalWeight + currentWeight) {
            droneEntity.getCargo().addAll(goods);
            droneEntity.setState(DroneState.LOADED);
            return true;
        }
        return false;
    }

    public List<Medication> getCargo(long id) {
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
