package by.ld38.game.content.screen.process.system.rad;

import by.ld38.game.content.constant.GameEnv;
import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.content.screen.process.component.Velocity;
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
        rp.oldRadX = rp.radX;
        rp.oldRadY = rp.radY;
        rp.radX += v.radVX;
        rp.radY += v.radVY;
        if (rp.radX > GameEnv.RadMax) {
            rp.radX -= GameEnv.RadMax;
        }
        if (rp.radX < GameEnv.RadMin) {
            rp.radX += GameEnv.RadMax;
        }
        if (rp.radY > GameEnv.RadMax) {
            rp.radY -= GameEnv.RadMax;
        }
        if (rp.radY <GameEnv. RadMin) {
            rp.radY += GameEnv.RadMax;
        }
    }
}
