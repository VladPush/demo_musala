package com.example.musala.service;

import com.example.musala.dto.drone.DroneEntity;
import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.dto.drone.DroneState;
import com.example.musala.dto.goods.Medication;
import com.example.musala.repository.mock.MockDroneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DroneDispatchService {

    private final MockDroneRepository repository;

    public UUID register(final DroneModelDto modelDto, final String serial) {
        DroneEntity droneEntity = DroneEntity.builder()
                .serialNumber(serial)
                .model(modelDto)
                .batteryCapacity(100.0f)
                .state(DroneState.IDLE)
                .build();
        return repository.save(droneEntity);
    }

    public boolean load(UUID id, List<Medication> goods) {
        DroneEntity droneEntity = repository.get(id);
        if (droneEntity.getBatteryCapacity() < 25.0f) {
            throw new IllegalStateException("Battery capacity is low for loading");
        }
        droneEntity.setState(DroneState.LOADING);
        int maxWeight = droneEntity.getModel().maxWeight();
        int additionalWeight = goods.stream().mapToInt(Medication::getWeight).sum();
        int currentWeight = droneEntity.getCargo().stream().mapToInt(Medication::getWeight).sum();

        if (maxWeight >= additionalWeight + currentWeight) {
            droneEntity.getCargo().addAll(goods);
            repository.save(droneEntity); // TODO we will dont need it when real JPA will work
            droneEntity.setState(DroneState.LOADED);
            return true;
        }
        return false;
    }

    public List<Medication> getCargo(UUID id) {
        return repository.get(id).getCargo();
    }

    public List<DroneEntity> getAvailableDrones() {
        return null;
    }
}
