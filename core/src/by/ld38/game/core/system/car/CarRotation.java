package by.ld38.game.core.system.car;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by m_katlinski on 24.04.2017.
 */
public class CarRotation extends IteratingSystem {
    public CarRotation() {
        super(Aspect.all(Car.class, Force.class, Velocity.class , Position.class));}
        @Override
        protected void process(int entityId) {
            Car car = world.getMapper(Car.class).get(entityId);
            Force force = world.getMapper(Force.class).get(entityId);
            Position pos = world.getMapper(Position.class).get(entityId);
            Velocity vel = world.getMapper(Velocity.class).get(entityId);
            pos.angle = (float) Math.acos( ((double) vel.y/ Math.sqrt( vel.x*vel.x +vel.y*vel.y)));
            pos.angle = -1*(float)Math.toDegrees(pos.angle);
            if (vel.x < 0 )
                pos.angle *=-1;
    }
}
