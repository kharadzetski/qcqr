package by.ld38.game.core.system.rad;

import by.ld38.game.core.component.rad.RadForce;
import by.ld38.game.core.component.rad.RadPosition;
import by.ld38.game.core.component.rad.RadVelocity;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * @author SharK729
 * @since 1.0
 */
public class RadForceSystem extends IteratingSystem {
    public RadForceSystem() {
        super(Aspect.all(RadForce.class, RadPosition.class, RadVelocity.class));
    }

    private float slowCoef = .001f;
    private float maxVelocity = .2f;

    @Override
    protected void process(int entityId) {
        RadForce rf = world.getMapper(RadForce.class).get(entityId);
        RadVelocity rv = world.getMapper(RadVelocity.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        rv.alpha += rf.alpha ;
        rv.beta += rf.beta;
        rv.gamma += rf.gamma;
        rf.reset();

        rv.alpha = slowVelocity(rv.alpha);
        rv.beta = slowVelocity(rv.beta);
        rv.gamma = slowVelocity(rv.gamma);

        rp.alpha += rv.alpha;
        rp.beta += rv.beta;
        rp.gamma += rv.gamma;
    }

    private float slowVelocity(float value) {
        if (Math.abs(value) > slowCoef) {
            value -= Math.signum(value) * slowCoef;
        } else value = 0;
        value = Math.signum(value) * Math.min( maxVelocity, Math.abs(value));
        return value;
    }
}
