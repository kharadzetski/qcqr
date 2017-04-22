package by.ld38.game.screen.test.item;

import by.ld38.game.component.base.RadPosition;
import by.ld38.game.component.base.Velocity;
import by.ld38.game.component.render.Animation;
import by.ld38.game.utils.Item;
import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public class PlanetItem extends Item {
    public Velocity velocity;
    public RadPosition radPosition;
    public Animation animation;

    @Override
    public void create(World world, int id) {
        world.getMapper(Velocity.class).create(id);
        world.getMapper(RadPosition.class).create(id);
        world.getMapper(Animation.class).create(id);
    }

    @Override
    public void select(World world, int id) {
        velocity = world.getMapper(Velocity.class).get(id);
        radPosition = world.getMapper(RadPosition.class).get(id);
        animation = world.getMapper(Animation.class).get(id);
    }

}
