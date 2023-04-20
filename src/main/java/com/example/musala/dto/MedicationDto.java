package com.example.musala.dto;

import lombok.Builder;

@Builder
public record MedicationDto(long id, String code, String name, int weight, long droneId, byte[] image) {
}
