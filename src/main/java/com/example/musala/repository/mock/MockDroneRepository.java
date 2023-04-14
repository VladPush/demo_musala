package com.example.musala.repository.mock;

import com.example.musala.dto.drone.DroneDto;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MockDroneRepository {

    private final ConcurrentHashMap<UUID, DroneDto> droneStorage = new ConcurrentHashMap<>();

    public UUID save(DroneDto model) {
        UUID uuid = UUID.randomUUID();
        droneStorage.put(uuid, model);
        return uuid;
    }
}
