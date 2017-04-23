package by.ld38.game.content.screen.common;

import by.ld38.game.content.screen.common.component.base.Position;
import by.ld38.game.content.screen.common.component.Text;
import by.ld38.game.core.item.Item;
import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public class TextItem extends Item {
    public Text text;
    public Position position;

    @Override
    public void create(World world, int id) {
        world.getMapper(Text.class).create(id);
        world.getMapper(Position.class).create(id);
    }

    @Override
    public void select(World world, int id) {
        text = world.getMapper(Text.class).get(id);
        position = world.getMapper(Position.class).get(id);
    }
}
