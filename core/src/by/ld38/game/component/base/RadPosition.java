package by.ld38.game.component.base;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector3;

public class RadPosition extends Component {
    public float radX;
    public float radY;
    public float radZ = 425f;
    private Vector3 vector = new Vector3();

    public Vector3 asVector3() {
        vector.set(radX, radY, radZ);
        return vector;
    }
}
