package by.ld38.game.content.screen.process.system.rad;

import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.content.screen.process.component.Velocity;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class RadMovementSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;
    private ComponentMapper<RadPosition> rpm;

    private float max = 6.28318306054f;
    private float min = 0;
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
        if (rp.radX > max) {
            rp.radX -= max;
        }
        if (rp.radX < min) {
            rp.radX += max;
        }
        if (rp.radY > max) {
            rp.radY -= max;
        }
        if (rp.radY < min) {
            rp.radY += max;
        }
    }
}
