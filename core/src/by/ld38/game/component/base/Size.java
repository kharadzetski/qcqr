package by.ld38.game.component.base;

import com.artemis.Component;

public class Size extends Component {
    private float radH;
    private float radW;

    public float getRadH() {
        return radH;
    }

    public Size setRadH(float radH) {
        this.radH = radH;
        return this;
    }

    public float getRadW() {
        return radW;
    }

    public Size setRadW(float radW) {
        this.radW = radW;
        return this;
    }
}
