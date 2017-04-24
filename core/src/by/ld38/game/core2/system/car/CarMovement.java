package by.ld38.game.core2.system.car;

import by.ld38.game.core2.component.car.Car;
import by.ld38.game.core2.component.physics.Force;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * @author SharK729
 * @since 1.0
 */
public class CarMovement extends IteratingSystem {
    public CarMovement() {
        super(Aspect.all(Car.class, Force.class));
    }

    @Override
    protected void process(int entityId) {
        Car car = world.getMapper(Car.class).get(entityId);
        Force force = world.getMapper(Force.class).get(entityId);



        if (car.control.up) { force.y += car.speedForce; }
        if (car.control.down) { force.y -= car.speedForce; }
        if (car.control.right) { force.x += car.speedForce; }
        if (car.control.left) { force.x -= car.speedForce; }
        car.control.reset();
    }
}
