package by.ld38.game.content.screen.process.item;

import by.ld38.game.content.asset.AnimationContent;
import by.ld38.game.content.screen.process.component.Player;
import com.artemis.World;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class CarHeroItem extends PlanetItem {

    public Player player;

    @Override
    public void create(World world, int id) {
        super.create(world, id);
        world.getMapper(Player.class).create(id);
    }

    @Override
    public void select(World world, int id) {
        super.select(world, id);
        player = world.getMapper(Player.class).get(id);
    }

    @Override
    protected void defaultValues(World world) {
        animation.model = AnimationContent.CAR_HERO.getModel();
    }
}
