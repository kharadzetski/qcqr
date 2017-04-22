package by.ld38.game.component.logic;

import com.badlogic.gdx.math.Vector2;

public class Speed {
    private Vector2 value = new Vector2();

    public Vector2 getValue() {
        return value;
    }

    public Speed setValue(Vector2 value) {
        this.value = value;
        return this;
    }
}
