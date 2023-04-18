package com.example.musala.repository;

import com.example.musala.dto.drone.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<DroneEntity, Long> {
}
