package by.ld38.game.content.screen.common.component.render;

import by.ld38.game.content.screen.common.model.AnimationModel;
import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Animation holder.
 *
 * @author SharK729
 * @since 1.0
 */
public class Animation extends Component {
    public float currentFrame = 0;
    public TextureRegion region = new TextureRegion();
    public AnimationModel model;
}
