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
@Deprecated
public class MoveRadDirection extends IteratingSystem {
    public MoveRadDirection() {
        super(Aspect.all(RadDirection.class, RadPosition.class));
    }

    @Override
    protected void process(int entityId) {
        RadDirection rd = world.getMapper(RadDirection.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        float round = (float) (360 * Math.PI / 180);

        rp.alpha += rd.speed * cos(rd.angle) ;
        rp.beta += rd.speed * sin(rd.angle);

        //float nA = (float) (rp.alpha * cos(rd.angle) - rp.beta * sin(rd.angle));
        //float nB = (float) (rp.alpha * sin(rd.angle) + rp.beta * cos(rd.angle));
        //nB += rd.speed;
        //rp.alpha = (float) (nA * cos(round - rd.angle) - nB * sin(round - rd.angle));
        //rp.beta = (float) (nA * sin(round - rd.angle) + nB * cos(round - rd.angle));

        //rp.alpha = (float) (rp.beta * cos(rp.alpha) + rp.alpha * sin(rp.beta) );

        if (rd.angle > round) rd.angle -= round;
        if (rd.angle < 0) rd.angle = round - rd.angle;
        if (rp.alpha > round) rp.alpha -= round;
        if (rp.alpha < 0) rp.alpha = round - rp.alpha;
        if (rp.beta > round) rp.beta -= round;
        if (rp.beta < 0) rp.beta = round - rp.beta;
    }
}
