package com.example.musala.repository;

import com.example.musala.dto.drone.DroneEntity;
import com.example.musala.dto.drone.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DroneRepository extends JpaRepository<DroneEntity, Long> {

    List<DroneEntity> getAllByBatteryLevelAfterAndState(float batteryLevel, DroneState state);

    @Query(value = "SELECT batteryLevel FROM drone_entity where id = ?1")
    float getBatteryLevel(long id);
}