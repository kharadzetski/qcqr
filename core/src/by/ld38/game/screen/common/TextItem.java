package by.ld38.game.screen.common;

import by.ld38.game.screen.common.components.Text;
import by.ld38.game.utils.Item;
import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public class TextItem extends Item {
    public Text text;

    @Override
    public void create(World world, int id) {
        world.getMapper(Text.class).create(id);
    }

    @Override
    public void select(World world, int id) {
        text = world.getMapper(Text.class).get(id);
    }
}
