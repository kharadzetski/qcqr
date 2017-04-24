package by.ld38.game.core2.system.energy;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core2.component.energy.PlanetEnergy;
import by.ld38.game.core2.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;
import com.artemis.utils.IntBag;

/**
 * @author SharK729
 * @since 1.0
 */
public class RadiusFromEnergySystem extends BaseEntitySystem {
    private ComponentMapper<RadPosition> rpm;
    private PlanetEnergy planetEnergy;

    public RadiusFromEnergySystem() {
        super(Aspect.all(RadPosition.class));
    }

    @Override
    protected void processSystem() {
        if (planetEnergy == null) {
            subscription = world.getAspectSubscriptionManager()
                    .get(Aspect.all(PlanetEnergy.class));
            int id = subscription.getEntities().get(0);
            planetEnergy = world.getMapper(PlanetEnergy.class).get(id);
        }
        float percent = planetEnergy.value / (QcqrConstants.MAX_ENERGY / 100) / 100;
        float currentRadius = Math.max(QcqrConstants.MAX_RADIUS * percent, QcqrConstants.MIN_RADIUS);

         subscription = world.getAspectSubscriptionManager()
                .get(Aspect.all(RadPosition.class));
         IntBag entities = subscription.getEntities();


        for (int i=0; i<entities.size(); i++) process(entities.get(i), currentRadius);
    }

    protected void process(int entityId, float currentRadius) {
        world.getMapper(RadPosition.class).get(entityId).radius = currentRadius;
        if (!rpm.has(entityId)) return;
        rpm.get(entityId).radius = currentRadius;
    }
}
