package com.example.musala.repository;

import com.example.musala.entity.product.MedicationEntity;

import java.util.List;

public interface MedicationRepository extends ProductRepository {
    List<MedicationEntity> findAllByDroneId(long droneId);
}
