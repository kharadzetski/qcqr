package by.ld38.game.core.system.ai;

import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.player.Player;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class DummyAiSystem extends IteratingSystem {
    private ComponentMapper<Car> cm;

    public DummyAiSystem() {
        super(Aspect.all(Car.class).exclude(Player.class));
    }

    float changeControlCoef = 0.02f;

    @Override
    protected void process(int entityId) {
        float rollDice = (float) Math.random();
        //if (rollDice <= changeControlCoef) changeControl(entityId);
    }

    private void changeControl(int entityId) {
        Car car = cm.get(entityId);
        car.control.reset();
        int movement = (int) (Math.random() * 9);
        switch (movement) {
            case 1: car.control.left = true; break;
            case 2: car.control.right = true; break;
            case 3: car.control.up = true; break;
            case 4: car.control.down = true; break;
            case 5: car.control.right = true; car.control.up = true; break;
            case 6: car.control.left = true; car.control.up = true; break;
            case 7: car.control.right = true; car.control.down = true; break;
            case 8: car.control.left = true; car.control.down = true; break;
            default:
        }
    }
}
