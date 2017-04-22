package by.ld38.game.component.base;

import com.artemis.Component;

public class Velocity extends Component {
    private float radVX;
    private float radVY;

    public float getRadVX() {
        return radVX;
    }

    public Velocity setRadVX(float radVX) {
        this.radVX = radVX;
        return this;
    }

    public float getRadVY() {
        return radVY;
    }

    public Velocity setRadVY(float radVY) {
        this.radVY = radVY;
        return this;
    }
}
