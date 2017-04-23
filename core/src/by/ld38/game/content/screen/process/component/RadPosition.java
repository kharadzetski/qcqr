package by.ld38.game.content.screen.process.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector3;

public class RadPosition extends Component {
    public float radX;
    public float radY;
    public float radZ = 425f;
    public float oldRadX;
    public float oldRadY;
    public boolean throughPole;

    private Vector3 vector = new Vector3();

    public Vector3 asVector3() {
        vector.set(radX, radY, radZ);
        return vector;
    }
}
