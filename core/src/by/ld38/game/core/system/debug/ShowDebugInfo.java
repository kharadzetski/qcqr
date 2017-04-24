package by.ld38.game.core.system.debug;

import by.ld38.game.core.component.base.Debug;
import by.ld38.game.core.component.base.Text;
import by.ld38.game.core.component.energy.Energy;
import by.ld38.game.core.component.energy.PlanetEnergy;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.component.rad.RadPosition;
import by.ld38.game.core.component.rad.RadVelocity;
import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.EntitySubscription;
import static by.ld38.game.util.DegreeUtil.*;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class ShowDebugInfo extends BaseSystem {
    Integer userId;
    Text text;
    PlanetEnergy planetEnergy;


    @Override
    protected void processSystem() {
        if (userId == null) collectIds();
        Energy rd = world.getMapper(Energy.class).get(userId);
        RadPosition rp = world.getMapper(RadPosition.class).get(userId);

        text.value = "Debug: \n" +
            "Rad.alpha: " + rad2dec( rp.alpha ) + "\n" +
            "Rad.beta: " + rad2dec( rp.beta ) + "\n" +
            "Rad.gamma: " + rad2dec( rp.gamma ) + "\n" +
            "Energy: " + rd.value + "\n" +
            "PLANET ENERGY: " + planetEnergy.value;
    }

    private void collectIds() {
        EntitySubscription subscription = world.getAspectSubscriptionManager()
                .get(Aspect.all(RadVelocity.class, Player.class, RadPosition.class));
        userId = subscription.getEntities().get(0);

        subscription = world.getAspectSubscriptionManager()
                .get(Aspect.all(Text.class, Debug.class));
        int textId = subscription.getEntities().get(0);
        text = world.getMapper(Text.class).get(textId);

        subscription = world.getAspectSubscriptionManager()
                .get(Aspect.all(PlanetEnergy.class));
        int id = subscription.getEntities().get(0);
        planetEnergy = world.getMapper(PlanetEnergy.class).get(id);
    }
}
