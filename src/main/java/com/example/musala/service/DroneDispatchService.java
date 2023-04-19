package com.example.musala.service;

import com.example.musala.dto.drone.DroneEntity;
import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.dto.drone.DroneState;
import com.example.musala.dto.goods.Goods;
import com.example.musala.dto.goods.Medication;
import com.example.musala.repository.DroneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DroneDispatchService {

    private final DroneRepository repository;

    public DroneEntity register(final DroneModelDto model) {
        DroneEntity droneEntity = DroneEntity.builder()
                .serialNumber(model.serial())
                .model(model.type())
                .weight(model.maxWeight())
                .batteryCapacity(100.0f)
                .state(DroneState.IDLE)
                .build();
        return repository.save(droneEntity);
    }

    @Transactional
    public boolean load(long id, List<Medication> goods) {
        DroneEntity droneEntity = repository.findById(id).get();
        if (droneEntity.getBatteryCapacity() < 25.0f) {
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

    public List<Medication> getCargo(UUID id) {
        //   return repository.get(id).getCargo();
        return Collections.emptyList();
    }

    public List<DroneEntity> getAvailableDrones() {
        return null;
    }

    public DroneEntity get(long id) {
        return repository.findById(id).get();
    }
}
