package by.ld38.game.content.screen.process.item;

import by.ld38.game.content.asset.AnimationContent;
import com.artemis.World;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class CarHeroItem extends PlanetItem {
    @Override
    protected void defaultValues(World world) {
        animation.model = AnimationContent.CAR_HERO.getModel();
    }
}
