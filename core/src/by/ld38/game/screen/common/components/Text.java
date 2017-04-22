package by.ld38.game.screen.common.components;

import by.ld38.game.content.FontContent;
import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * @author SharK729
 * @since 1.0
 */
public class Text extends Component {
    public BitmapFont font = FontContent.BASIC.getFont();
    public String value = "";
}
