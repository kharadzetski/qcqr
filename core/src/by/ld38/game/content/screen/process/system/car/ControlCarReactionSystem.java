package by.ld38.game.content.screen.process.system.car;

import by.ld38.game.content.constant.GameEnv;
import by.ld38.game.content.screen.process.component.CarControl;
import by.ld38.game.content.screen.process.component.Force;
import by.ld38.game.content.screen.process.component.RadPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class ControlCarReactionSystem extends IteratingSystem {
    public ControlCarReactionSystem() {
        super(Aspect.all(CarControl.class, Force.class));
    }

    private float coef = 0.003f;

    @Override
    protected void process(int entityId) {
        CarControl cc = world.getMapper(CarControl.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);
        float coefX;
        if (rp.radY < GameEnv.RadMax/2)
            coefX = coef;
        else
            coefX = -coef;
        Force f = world.getMapper(Force.class).get(entityId);
        f.reset();
        if (cc.right) f.a += coefX;
        if (cc.left) f.a -= coefX;
        if (cc.up) f.b += coef;
        if (cc.down) f.b -= coef;
    }
}
