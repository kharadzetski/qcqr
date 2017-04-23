package by.ld38.game.content.screen.process.component;

import com.artemis.Component;

/**
 * @author SharK729
 * @since 1.0
 */
public class CarControl extends Component {
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;

    public void reset() {
        left = false;
        right = false;
        up = false;
        down = false;
    }
    public boolean isAny()
    {
        return left||right||up||down;
    }
    public boolean isAnyX()
    {
        return left||right;
    }
    public boolean isAnyY()
    {
        return up||down;
    }
}
