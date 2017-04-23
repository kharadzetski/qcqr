package by.ld38.game.core.component.car;

import com.artemis.Component;

/**
 * @author SharK729
 * @since 1.0
 */
public class Car extends Component {
    public float speedForce = 1f;
    public float maxVelocity = 10f;

    public Control control = new Control();
    public State state = State.STAY;

    public class Control {
        public boolean left;
        public boolean up;
        public boolean down;
        public boolean right;

        public void reset() {
            left = false;
            up = false;
            down = false;
            right = false;
        }
    }

    public enum State {
        MOVE, STAY
    }
}

