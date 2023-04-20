package com.example.musala.repository;

import com.example.musala.entity.drone.BatteryLevelView;
import com.example.musala.entity.drone.DroneEntity;
import com.example.musala.entity.drone.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DroneRepository extends JpaRepository<DroneEntity, Long> {

    List<DroneEntity> getAllByBatteryLevelAfterAndState(float batteryLevel, DroneState state);

    @Query(value = "SELECT batteryLevel FROM drone where id = ?1")
    float getBatteryLevel(long id);

    @Transactional(readOnly = true)
    List<BatteryLevelView> getAllBy();
}