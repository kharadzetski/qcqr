package by.ld38.game.content.screen.process.system;

import by.ld38.game.content.screen.process.component.Acceleration;
import by.ld38.game.content.screen.process.component.Velocity;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class VelocityDeltaSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;
    private ComponentMapper<Acceleration> am;

    /**
     * Creates a new EntityProcessingSystem.
     */
    public VelocityDeltaSystem() {
        super(Aspect.all(Velocity.class, Acceleration.class));
    }

    @Override
    protected void process(int entityId) {
        Velocity v = vm.get(entityId);
        Acceleration a = am.get(entityId);
        float delta = getWorld().getDelta();
        v.radVX += a.deltaRadX * delta;
        v.radVY += a.deltaRadY * delta;
    }
}
