package com.actuator.Monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseServer implements HealthIndicator{

    @Override
    public Health health() {
        if(isDatabaseHealthGood()){
            return Health
                    .up()
                    .withDetail("DatabaseService", "Service is ruuning")
                    .build();
        }

        return Health
                .down()
                .withDetail("DatabaseService", "Service is not available")
                .build();
    }

    public boolean isDatabaseHealthGood(){
        return true;
    }
    
}
