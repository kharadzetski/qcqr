package by.ld38.game.component.base;

import com.artemis.Component;

public class Position extends Component {
    private float radX;
    private float radY;
    int x;

    public float getRadX() {
        x = (int) radX;
        return radX;
    }

    public Position setRadX(float radX) {
        this.radX = radX;
        return this;
    }

    public float getRadY() {
        return radY;
    }

    public Position setRadY(float radY) {
        this.radY = radY;
        return this;
    }
}
