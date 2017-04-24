package by.ld38.game.core.component.base.Items;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Text;
import com.artemis.World;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by m_katlinski on 24.04.2017.
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
