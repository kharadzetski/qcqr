package by.ld38.game.core.system.physic;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * @author SharK729
 * @since 1.0
 */
public class MoveObjectSystem extends IteratingSystem {
    public MoveObjectSystem() {
        super(Aspect.all(Force.class, Velocity.class, Position.class));
    }

    @Override
    protected void process(int entityId) {
        Force force = world.getMapper(Force.class).get(entityId);
        Velocity velocity = world.getMapper(Velocity.class).get(entityId);
        Position position = world.getMapper(Position.class).get(entityId);
        velocity.x += force.x;
        velocity.y += force.y;
        force.reset();

    }


    private boolean checkCollision() {

        return true;
    }
}
