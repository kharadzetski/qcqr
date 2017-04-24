package by.ld38.game.core2.system.render.src.by.ld38.game.core.component.base;

import com.artemis.Component;

/**
 * @author SharK729
 * @since 1.0
 */
public class Position extends Component {
    public float x;
    public float y;
    public float z = 100f; // Rendering order
    public float angle;
    public float scale = 1f;
}
