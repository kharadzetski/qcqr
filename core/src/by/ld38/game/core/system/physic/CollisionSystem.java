package by.ld38.game.core.system.physic;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Size;
import by.ld38.game.core.component.physics.Collides;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem extends BaseEntitySystem {
    ComponentMapper<Size> sm;
    ComponentMapper<Position> pm;
    ComponentMapper<Force> fm;
    /**
     * Creates an entity system that uses the specified aspect as a matcher
     * against entities.
     */
    public CollisionSystem() {
        super(Aspect.all(Size.class, WorldPosition.class, Collides.class, Velocity.class));
    }

    @Override
    protected void processSystem() {
        IntBag intBag = getEntityIds();
        List<Integer> checked = new ArrayList<>();
        for (int i = 0; i < intBag.size(); i++) {
            Integer entityId = intBag.get(i);
            Force entityF = fm.get(entityId);
            Position entityP = pm.get(entityId);
            Size entityS = sm.get(entityId);
            if (!checked.contains(entityId)) {
                Integer collidesWithId = checkCollides(entityId, intBag);
                if (collidesWithId != null) {
                    Force collidesWithF = fm.get(collidesWithId);
                    Position collidesWithPosition = pm.get(collidesWithId);
                    collidesWithF.x += entityF.x;
                    collidesWithF.y += entityF.y;
                    collidesWithPosition.x += Math.signum(entityF.x) * entityS.width/2;
                    collidesWithPosition.y += Math.signum(entityF.y) * entityS.height/2;
                }
                checked.add(intBag.get(i));
            }
        }
    }

    private Integer checkCollides(int entityId, IntBag intBag) {
        Rectangle entityRect = getRect(entityId);
        for (int i = 0; i < intBag.size(); i++) {
            int compareToId = intBag.get(i);
            if (compareToId != entityId) {
                Rectangle compareToRect = getRect(compareToId);
                if (Intersector.overlaps(entityRect, compareToRect)) {
                    return compareToId;
                }
            }
        }
        return null;
    }

    private Rectangle getRect(int entityId) {
        Size entitySize = sm.get(entityId);
        Position entityPosition = pm.get(entityId);
        return new Rectangle(entityPosition.x, entityPosition.y, entitySize.width, entitySize.height);
    }
}
