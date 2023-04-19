package com.example.musala.repository;

import com.example.musala.entity.goods.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {
    List<MedicationEntity> findAllByDroneId(long droneId);
}
