package by.ld38.game.core.system.energy;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.energy.Energy;
import by.ld38.game.core.component.energy.PlanetEnergy;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.util.EntityHelper;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class VictorySystem extends BaseEntitySystem {
    Energy playerEnergy;
    PlanetEnergy planetEnergy;

    public VictorySystem() {
        super(Aspect.all(Player.class));
    }

    @Override
    protected void processSystem() {
        if (planetEnergy == null) {
            int id = EntityHelper.findEntities(world, PlanetEnergy.class).get(0);
            planetEnergy = world.getMapper(PlanetEnergy.class).get(id);
            id = EntityHelper.findEntities(world, Player.class, Energy.class).get(0);
            playerEnergy = world.getMapper(Energy.class).get(id);
        }

        if (playerEnergy.value > QcqrConstants.MAX_ENERGY) {
            if (playerEnergy.value >= QcqrConstants.MAX_ENERGY * QcqrConstants.VICTORY_CONDITION) {
                // TODO Victory
                System.out.println("VICTORY!!!");
            } else {
                // TODO FAIL
                System.out.println("FAIL!!!");
            }
        }
    }

}
