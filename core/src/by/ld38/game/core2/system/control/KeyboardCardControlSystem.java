package by.ld38.game.core2.system.control;

import by.ld38.game.core2.component.car.Car;
import by.ld38.game.core2.component.player.Player;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * @author SharK729
 * @since 1.0
 */
public class KeyboardCardControlSystem extends IteratingSystem {
    public KeyboardCardControlSystem() {
        super(Aspect.all(Car.class, Player.class));
    }

    @Override
    protected void process(int entityId) {
        Car car = world.getMapper(Car.class).get(entityId);
        car.control.reset();
        car.control.left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        car.control.up = Gdx.input.isKeyPressed(Input.Keys.UP);
        car.control.down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        car.control.right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }
}
