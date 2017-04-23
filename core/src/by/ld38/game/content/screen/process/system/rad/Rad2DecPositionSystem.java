package by.ld38.game.content.screen.process.system.rad;

import by.ld38.game.content.screen.common.component.base.Position;
import by.ld38.game.content.screen.process.component.Planet;
import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.utils.Rad2DecUtil;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.EntitySubscription;
import com.artemis.systems.IteratingSystem;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.math.Vector3;

public class Rad2DecPositionSystem extends IteratingSystem {

    private ComponentMapper<RadPosition> rpm;
    private ComponentMapper<Position> pm;


    /**
     * Creates a new EntityProcessingSystem.
     *
     */
    public Rad2DecPositionSystem() {
        super(Aspect.all(RadPosition.class, Position.class));
    }

    @Override
    protected void process(int entityId) {
        Planet planet = getPlanet();

        RadPosition radPosition = rpm.get(entityId);
        Position position = pm.get(entityId);



        Vector3 decV3 = Rad2DecUtil.rad2Dec( radPosition.asVector3().add(planet.alpha, planet.beta, 0f) );
        position.x = decV3.x;
        position.y = decV3.y;
    }

    private Planet getPlanet() {
        EntitySubscription subscription = world.getAspectSubscriptionManager().get(Aspect.all(Planet.class));
        IntBag entityIds = subscription.getEntities();
        return world.getMapper(Planet.class).get( entityIds.get(0) );
    }
}
