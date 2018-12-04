package bcntec.training.springboot.microservices.intro;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
class TPSHealth implements HealthIndicator {
    TPSCounter counter;


    @Override
    public Health health() {
        boolean health = howGoodIsHealth(); // perform some specific health check
        if (health) {
            return Health.outOfService().withDetail("Too many requests", "OutofService").build();
        }
        return Health.up().build();
    }

    void updateTx() {
        if (counter == null || counter.isExpired()) {
            counter = new TPSCounter();

        }
        counter.increment();
    }


    boolean howGoodIsHealth() {
        return counter != null && counter.isWeak();
    }

}
