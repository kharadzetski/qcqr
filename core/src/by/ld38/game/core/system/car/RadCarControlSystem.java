package by.ld38.game.core.system.car;

import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.rad.RadDirection;
import by.ld38.game.util.DegreeUtil;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * @author SharK729
 * @since 1.0
 */
public class RadCarControlSystem extends IteratingSystem {
    public RadCarControlSystem() {
        super(Aspect.all(Car.class, RadDirection.class));
    }

    private float angleCoef = DegreeUtil.deg2rad(0.5f);
    private float spdCoef = 0.005f;

    @Override
    protected void process(int entityId) {
        Car car = world.getMapper(Car.class).get(entityId);
        RadDirection rd = world.getMapper(RadDirection.class).get(entityId);

        if (car.control.left) rd.angle -= angleCoef;
        if (car.control.right) rd.angle -= angleCoef;
        if (car.control.up) rd.speed += spdCoef;
        if (car.control.down) rd.speed -= spdCoef;

        car.control.reset();
    }
}
