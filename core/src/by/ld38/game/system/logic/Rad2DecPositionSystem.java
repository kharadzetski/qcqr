package by.ld38.game.system.logic;

import by.ld38.game.component.base.Position;
import by.ld38.game.component.base.RadPosition;
import by.ld38.game.utils.Rad2DecUtil;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector3;

@Wire
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
        RadPosition radPosition = rpm.get(entityId);
        Position position = pm.get(entityId);
        Vector3 decV3 = Rad2DecUtil.rad2Dec(radPosition.asVector2(), null);
        position.x = decV3.x;
        position.y = decV3.y;
    }
}
