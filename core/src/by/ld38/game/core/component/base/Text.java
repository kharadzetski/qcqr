package by.ld38.game.core.component.base;

import by.ld38.game.content.assets.FontAssets;
import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * @author SharK729
 * @since 1.0
 */
public class Text extends Component{
    public String value;
    public BitmapFont font = FontAssets.BASIC.getFont();
}
