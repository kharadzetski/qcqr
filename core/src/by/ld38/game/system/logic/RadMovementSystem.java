package by.ld38.game.system.logic;

import by.ld38.game.component.base.RadPosition;
import by.ld38.game.component.base.Velocity;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class RadMovementSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;
    private ComponentMapper<RadPosition> rpm;

    /**
     * Creates a new EntityProcessingSystem.
     */
    public RadMovementSystem() {
        super(Aspect.all(RadPosition.class, Velocity.class));
    }

    @Override
    protected void process(int entityId) {
        Velocity v = vm.get(entityId);
        RadPosition rp = rpm.get(entityId);
        rp.radX += v.radVX;
        rp.radY += v.radVY;
    }
}
