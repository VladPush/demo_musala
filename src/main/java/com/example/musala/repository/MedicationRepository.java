package com.example.musala.repository;

import com.example.musala.entity.goods.MedicationEntity;

import java.util.List;

public interface MedicationRepository extends GoodsRepository {
    List<MedicationEntity> findAllByDroneId(long droneId);
}
