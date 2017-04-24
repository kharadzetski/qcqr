package by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics;

import com.artemis.Component;

/**
 * @author SharK729
 * @since 1.0
 */
public class Force extends Component {
    public float x;
    public float y;

    public void reset() {
        x = 0;
        y = 0;
    }
}
