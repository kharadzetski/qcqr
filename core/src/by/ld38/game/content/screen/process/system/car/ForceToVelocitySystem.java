package by.ld38.game.content.screen.process.system.car;

import by.ld38.game.content.screen.process.component.Force;
import by.ld38.game.content.screen.process.component.Velocity;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class ForceToVelocitySystem extends IteratingSystem {
    public ForceToVelocitySystem() {
        super(Aspect.all(Force.class, Velocity.class));
    }

    @Override
    protected void process(int entityId) {
        Force f = world.getMapper(Force.class).get(entityId);
        Velocity v = world.getMapper(Velocity.class).get(entityId);
        v.radVX += f.a;
        v.radVY += f.b;
        f.reset();
    }
}
