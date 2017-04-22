package by.ld38.game.component.base;

import com.artemis.Component;

public class Acceleration extends Component {
    private float deltaRadX;
    private float deltaRadY;

    public float getDeltaRadX() {
        return deltaRadX;
    }

    public Acceleration setDeltaRadX(float deltaRadX) {
        this.deltaRadX = deltaRadX;
        return this;
    }

    public float getDeltaRadY() {
        return deltaRadY;
    }

    public Acceleration setDeltaRadY(float deltaRadY) {
        this.deltaRadY = deltaRadY;
        return this;
    }
}
