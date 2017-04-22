package by.ld38.game.screen.common.system;

import by.ld38.game.QcqrGame;
import by.ld38.game.component.base.Position;
import by.ld38.game.screen.common.components.Text;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class RenderTextSystem extends IteratingSystem {
    public RenderTextSystem() {
        super(Aspect.all(Text.class, Position.class));
    }


    @Override
    protected void process(int entityId) {
        Position position = world.getMapper(Position.class).get(entityId);
        Text text = world.getMapper(Text.class).get(entityId);
        text.font.draw(QcqrGame.getInstance().batch, text.value, position.x, position.y);

    }
}
