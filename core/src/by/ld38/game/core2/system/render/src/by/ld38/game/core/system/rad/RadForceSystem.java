package by.ld38.game.core2.system.render.src.by.ld38.game.core.system.rad;

import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics.Unstopable;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.rad.RadForce;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.rad.RadPosition;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.rad.RadVelocity;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

import static by.ld38.game.util.DegreeUtil.round;

/**
 * @author SharK729
 * @since 1.0
 */
public class RadForceSystem extends IteratingSystem {
    public RadForceSystem() {
        super(Aspect.all(RadForce.class, RadPosition.class, RadVelocity.class));
    }

    private float slowCoef = .001f;
    private float maxVelocity = .05f;

    @Override
    protected void process(int entityId) {
        RadForce rf = world.getMapper(RadForce.class).get(entityId);
        RadVelocity rv = world.getMapper(RadVelocity.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        rv.alpha += rf.alpha ;
        rv.beta += rf.beta;
        rv.gamma += rf.gamma;
        rf.reset();

        if (!world.getMapper(Unstopable.class).has(entityId)) {
            rv.alpha = slowVelocity(rv.alpha);
            rv.beta = slowVelocity(rv.beta);
            rv.gamma = slowVelocity(rv.gamma);
        }

        rp.alpha += rv.alpha;
        rp.beta += rv.beta;
        rp.gamma += rv.gamma;


        if (rp.alpha > round) rp.alpha -= round;
        if (rp.alpha < 0) rp.alpha = round - rp.alpha;
        if (rp.beta > round) rp.beta -= round;
        if (rp.beta < 0) rp.beta = round - rp.beta;
    }

    private float slowVelocity(float value) {
        if (Math.abs(value) > slowCoef) {
            value -= Math.signum(value) * slowCoef;
        } else value = 0;
        value = Math.signum(value) * Math.min( maxVelocity, Math.abs(value));
        return value;
    }
}
