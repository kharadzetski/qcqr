package by.ld38.game.core.component.physics;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Tag for collision system
 */
public class Collides extends Component {
   public int framesColliding = 0;
   public Vector2 CameraOffsset = new Vector2(0,0);
   public Vector2 InitialOffset = new Vector2(0,0);
}
