package by.ld38.game.core.system.car;

import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.rad.RadDirection;
import by.ld38.game.core.component.rad.RadPosition;
import by.ld38.game.util.DegreeUtil;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import  static by.ld38.game.util.DegreeUtil.*;

/**
 * @author SharK729
 * @since 1.0
 */
public class RadCarControlSystem extends IteratingSystem {
    public RadCarControlSystem() {
        super(Aspect.all(Car.class, RadPosition.class, RadDirection.class));
    }

    private float angleCoef = DegreeUtil.deg2rad(0.5f);
    private float spdCoef = 0.0005f;

    @Override
    protected void process(int entityId) {
        Car car = world.getMapper(Car.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        if (car.control.up) rp.beta += angleCoef;
        if (car.control.down) rp.beta -= angleCoef;
        if (car.control.left) {
            rp.alpha -= angleCoef * Math.cos(rp.beta);
            rp.gamma -= angleCoef * Math.sin(rp.beta);
        }
        if (car.control.right) {
            rp.alpha += angleCoef * Math.cos(rp.beta);
            rp.gamma += angleCoef * Math.sin(rp.beta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.R)) rp.alpha += angleCoef;
        if (Gdx.input.isKeyPressed(Input.Keys.F)) rp.alpha -= angleCoef;
        if (Gdx.input.isKeyPressed(Input.Keys.T)) rp.beta += angleCoef;
        if (Gdx.input.isKeyPressed(Input.Keys.G)) rp.beta -= angleCoef;
        if (Gdx.input.isKeyPressed(Input.Keys.Y)) rp.gamma += angleCoef;
        if (Gdx.input.isKeyPressed(Input.Keys.H)) rp.gamma -= angleCoef;

        /*RadDirection rd = world.getMapper(RadDirection.class).get(entityId);

        if (car.control.left) rd.angle -= angleCoef;
        if (car.control.right) rd.angle += angleCoef;
        if (car.control.up) rd.speed += spdCoef;
        if (car.control.down) rd.speed -= spdCoef;*/

        car.control.reset();
    }
}
