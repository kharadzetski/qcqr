package by.ld38.game.content.screen.process.item;

import by.ld38.game.content.screen.common.component.base.Position;
import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.content.screen.process.component.Player;
import by.ld38.game.content.screen.common.component.render.Animation;
import by.ld38.game.content.screen.common.component.render.Scale;
import by.ld38.game.core.item.Item;
import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public class PlanetItem extends Item {
    public Velocity velocity;
    public RadPosition radPosition;
    public Animation animation;
    public Position position;
    public Scale scale;
    public Player player;

    @Override
    public void create(World world, int id) {
        world.getMapper(Velocity.class).create(id);
        world.getMapper(RadPosition.class).create(id);
        world.getMapper(Animation.class).create(id);
        world.getMapper(Position.class).create(id);
        world.getMapper(Scale.class).create(id);
        world.getMapper(Player.class).create(id);
    }

    @Override
    public void select(World world, int id) {
        velocity = world.getMapper(Velocity.class).get(id);
        radPosition = world.getMapper(RadPosition.class).get(id);
        animation = world.getMapper(Animation.class).get(id);
        position = world.getMapper(Position.class).get(id);
        scale = world.getMapper(Scale.class).get(id);
        player = world.getMapper(Player.class).get(id);
    }

}
