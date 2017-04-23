package by.ld38.game.content.screen.process.component;
import com.artemis.Component;
import com.badlogic.gdx.math.Vector3;
/**
 * Created by m_katlinski on 23.04.2017.
 */
public class WorldPosition extends Component {
        public float worldX;
        public float worldY;
        public float worldZ;

        private Vector3 vector = new Vector3();

        public Vector3 asVector3() {
            vector.set(worldX, worldY, worldZ);
            return vector;
        }
    }
}
