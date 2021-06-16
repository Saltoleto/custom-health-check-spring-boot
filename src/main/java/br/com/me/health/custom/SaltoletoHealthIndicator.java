package br.com.me.health.custom;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Fernando Saltoleto
 */
@Component
@ConditionalOnEnabledHealthIndicator("saltoleto")
public class SaltoletoHealthIndicator implements HealthIndicator {

    private final String message_key = "Service Saltoleto";

    @Override
    public Health health() {
        if (!isRunningServiceSaltoleto()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private Boolean isRunningServiceSaltoleto() {
        return ThreadLocalRandom.current().nextDouble() > 0.6;
    }
}
