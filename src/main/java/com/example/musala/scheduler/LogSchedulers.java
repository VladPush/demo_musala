package com.example.musala.scheduler;

import com.example.musala.entity.drone.BatteryLevelView;
import com.example.musala.repository.DroneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LogSchedulers {

    private final DroneRepository repository;

    @Scheduled(fixedRate = 5000)
    public void logBatteryLevels() {
        List<BatteryLevelView> allDrones = repository.getAllBy(); // TODO peagable
        int i = 0;
        StringBuilder builder = new StringBuilder(1000);
        for (BatteryLevelView drone : allDrones) {
            if (i < 25) {
                builder.append("DroneId = ")
                        .append(drone.getId())
                        .append(" battery level = ")
                        .append(drone.getBatteryLevel())
                        .append("\n");
                i++;
            } else {
                log.info(builder.toString());
                builder.setLength(0);
                i = 0;
            }
        }
        if (!builder.isEmpty()) {
            log.info(builder.toString());
        }
    }
}
