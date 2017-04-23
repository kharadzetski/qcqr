package by.ld38.game.content.screen.process.system.car;

import by.ld38.game.content.screen.process.component.CarControl;
import by.ld38.game.content.screen.process.component.Force;
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
        Force f = world.getMapper(Force.class).get(entityId);


        if (cc.right) f.a += coef;
        if (cc.left) f.a -= coef;
        if (cc.up) f.b += coef;
        if (cc.down) f.b -= coef;
    }
}
