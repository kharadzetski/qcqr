package by.ld38.game.core.system.rad;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import static java.lang.Math.*;

/**
 * @author SharK729
 * @since 1.0
 */
public class Rad2PositionSystem extends IteratingSystem {
    public Rad2PositionSystem() {
        super(Aspect.all(Position.class, RadPosition.class));
    }

    private RadPosition camera = new RadPosition(); // TODO implement with correct cam

    @Override
    protected void process(int entityId) {
        Position p = world.getMapper(Position.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        float alpha = rp.alpha + camera.alpha;
        float beta = (float) ( rp.beta * cos(camera.beta) + rp.alpha * sin(camera.beta) );
        float radius = rp.radius;
        p.x = (float) ( sin(alpha) * cos(beta) ) * radius;
        p.y = (float) ( sin(beta) ) * radius;
        p.z = (float) ( cos(alpha) * cos(beta) ) * radius;
    }


}
