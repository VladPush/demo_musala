package com.example.musala.repository.mock;

import com.example.musala.entity.drone.DroneEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockDroneRepository { // TODO do normal mock with real repo and inside it mock mechanism

    private final List<DroneEntity> droneStorage = new ArrayList<>(); // TODO here i dont care about concurrency of course, it is a test program.

/*    public UUID save(DroneEntity entity) {
        if (Objects.isNull(entity.getId())) {
            UUID uuid = UUID.randomUUID();
            entity.setId(uuid);
            droneStorage.add(entity);
            return uuid;
        }
        return entity.getId();
    }


    public DroneEntity get(UUID id) {
        return droneStorage.stream().filter(e -> e.getId() == id).findFirst().get(); // and about exceptions too )
    }*/
}
