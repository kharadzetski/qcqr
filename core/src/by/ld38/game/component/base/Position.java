package by.ld38.game.component.base;

import com.artemis.Component;

public class Position extends Component {
    private float x;
    private float y;

    public Position setX(float x) {
        this.x = x;
        return this;
    }

    public Position setY(float y) {
        this.y = y;
        return this;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
