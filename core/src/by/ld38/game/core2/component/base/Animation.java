package by.ld38.game.core2.component.base;

import by.ld38.game.content.model.AnimationModel;
import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author SharK729
 * @since 1.0
 */
public class Animation extends Component {
    public float current = 0;
    public AnimationModel model;
    public TextureRegion region = new TextureRegion();
}
