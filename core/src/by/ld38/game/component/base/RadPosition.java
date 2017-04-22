package by.ld38.game.component.base;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class RadPosition extends Component {
    public float radX;
    public float radY;
    private Vector2 vector = new Vector2();

    public Vector2 asVector2() {
        vector.set(radX, radY);
        return vector;
    }
}
