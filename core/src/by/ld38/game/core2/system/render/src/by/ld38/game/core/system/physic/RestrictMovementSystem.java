package by.ld38.game.core2.system.render.src.by.ld38.game.core.system.physic;

import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.base.Position;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics.WorldPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class RestrictMovementSystem extends IteratingSystem {
    public RestrictMovementSystem() {
        super(Aspect.all(WorldPosition.class, Position.class));
    }

    @Override
    protected void process(int entityId) {
        WorldPosition wp = world.getMapper(WorldPosition.class).get(entityId);
        Position pos = world.getMapper(Position.class).get(entityId);
        Velocity v = world.getMapper(Velocity.class).get(entityId);


        if ( wp.worldX < -1280/2 ) wp.worldX = 0;
        if ( wp.worldX > 1280/2 ) wp.worldX = 1280/2;

        if ( pos.x < -1280/2 )  {
            v.reset();
            pos.x = -1280/2;
        }
        if (  pos.x > 1280/2 ) {
            pos.x = 1280/2;
            v.reset();
        }

        if ( pos.y < -720/2 )  {
            v.reset();
            pos.y = -720/2;
        }
        if (  pos.y > 720/2 ) {
            pos.y = 720/2;
            v.reset();
        }
    }
}
