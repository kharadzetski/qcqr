package by.ld38.game.content.screen.process.system.car;

import by.ld38.game.content.screen.process.component.CarControl;
import by.ld38.game.content.screen.process.component.Velocity;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class SlowdownVelocitySystem extends IteratingSystem {
    public SlowdownVelocitySystem() {
        super(Aspect.all(Velocity.class));
    }

    private float slowCoef = 0.0003f;

    @Override
    protected void process(int entityId) {
        CarControl cc = world.getMapper(CarControl.class).get(entityId);

        Velocity v = world.getMapper(Velocity.class).get(entityId);
        if (v.radVX > 0 && (!cc.isAnyX())) {
            if (v.radVX > slowCoef) v.radVX -= slowCoef;
            else v.radVX = 0;
        }
        if (v.radVX < 0 && (!cc.isAnyX()) ) {
            if (v.radVX < slowCoef) v.radVX += slowCoef;
            else v.radVX = 0;
        }

        if (v.radVY > 0 && (!cc.isAnyY())) {
            if (v.radVY > slowCoef) v.radVY -= slowCoef;
            else v.radVY = 0;
        }
        if (v.radVY < 0 && (!cc.isAnyX()))  {
            if (v.radVY < slowCoef) v.radVY += slowCoef;
            else v.radVY = 0;
        }
    }
}
