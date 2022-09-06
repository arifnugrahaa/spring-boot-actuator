package com.actuator.Monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class OtherServer implements HealthIndicator {

    private boolean status = true;

    @Override
    public Health health() {
        if(isOtherServiceHealthGood()){
            return Health
                    .up()
                    .withDetail("OtherService", "Service is ruuning")
                    .build();
        }

        return Health
                .down()
                .withDetail("OtherService", "Service is not available")
                .build();
    }

    public boolean isOtherServiceHealthGood(){
        return status = !status;
    }

    
}
