package by.ld38.game.core2.system.car;

import by.ld38.game.core2.component.car.Health;
import by.ld38.game.core2.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class HealthCheckSystem extends IteratingSystem {
    public HealthCheckSystem() {
        super(Aspect.all(Health.class, RadPosition.class));
    }

    @Override
    protected void process(int entityId) {
        Health health = world.getMapper(Health.class).get(entityId);
        if (health.value < 0) destroy(entityId);
    }

    private void destroy(int id) {
        RadPosition position = world.getMapper(RadPosition.class).get(id);
        createPopUp(position);
        world.delete(id);
    }

    private void createPopUp(RadPosition position) {

    }
}
