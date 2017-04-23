package by.ld38.game.core.system.rad;

import by.ld38.game.core.component.rad.RadDirection;
import by.ld38.game.core.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import static java.lang.Math.*;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class MoveRadDirection extends IteratingSystem {
    public MoveRadDirection() {
        super(Aspect.all(RadDirection.class, RadPosition.class));
    }

    @Override
    protected void process(int entityId) {
        RadDirection rd = world.getMapper(RadDirection.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        rp.alpha += rd.speed * cos(rd.angle);
        rp.beta += rd.speed * sin(rd.angle);
    }
}
