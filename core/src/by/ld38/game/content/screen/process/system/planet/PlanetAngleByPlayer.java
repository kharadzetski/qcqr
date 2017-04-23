package by.ld38.game.content.screen.process.system.planet;

import by.ld38.game.content.screen.process.component.Planet;
import by.ld38.game.content.screen.process.component.Player;
import by.ld38.game.content.screen.process.component.RadPosition;
import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.EntitySubscription;
import com.artemis.systems.IteratingSystem;
import com.artemis.utils.IntBag;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class PlanetAngleByPlayer extends BaseSystem {
    @Override
    protected void processSystem() {
        Planet planet = getPlanet();
        RadPosition player = getPlayerRadPosition();
        //planet.pos = plaery.pos angle
        planet.alpha = - player.radX;
        planet.beta = (float) (player.radY ) + 1.5f;

    }

    private Planet getPlanet() {
        EntitySubscription subscription = world.getAspectSubscriptionManager().get(Aspect.all(Planet.class));
        IntBag entityIds = subscription.getEntities();
        return world.getMapper(Planet.class).get( entityIds.get(0) );
    }

    private RadPosition getPlayerRadPosition() {
        EntitySubscription subscription = world.getAspectSubscriptionManager().get(Aspect.all(Player.class));
        int id = subscription.getEntities().get(0);
        return world.getMapper(RadPosition.class).get(id);
    }
}
