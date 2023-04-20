package com.example.musala.dto;

import com.example.musala.entity.drone.DroneType;

public record DroneCreateDto(DroneType type, int maxWeight, String serial) {
}
