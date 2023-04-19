package com.example.musala.repository;

import com.example.musala.dto.goods.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findAllByDroneId(long droneId);
}
