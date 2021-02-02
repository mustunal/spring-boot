package com.mustunal.trackzilla.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PeopleHealthIndicator implements HealthIndicator {

    private final String message_key = "PeopleService";

    @Override
    public Health health() {
        if(!isRunningServicePeopleService()){
            return Health.up().withDetail(message_key,"Available").build();
        }
        return Health.down().withDetail(message_key,"Not Available").build();
    }

    private boolean isRunningServicePeopleService(){
        // Custom health check
        return true;
    }
}
