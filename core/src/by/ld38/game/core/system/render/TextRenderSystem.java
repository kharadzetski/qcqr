package by.ld38.game.core.system.render;

import by.ld38.game.QcqrGame;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Text;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * @author SharK729
 * @since 1.0
 */
public class TextRenderSystem extends IteratingSystem {
    public TextRenderSystem() {
        super(Aspect.all(Text.class, Position.class));
    }

    @Override
    protected void process(int entityId) {
        Text text = world.getMapper(Text.class).get(entityId);
        Position position = world.getMapper(Position.class).get(entityId);

        text.font.draw(QcqrGame.getInstance().batch, text.value, position.x, position.y);
    }
}
