package by.ld38.game.core.system.physic;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Size;
import by.ld38.game.core.component.physics.Collides;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem extends BaseEntitySystem {
    ComponentMapper<Size> sm;
    ComponentMapper<WorldPosition> wpm;
    ComponentMapper<Velocity> vm;
    ComponentMapper <Collides> cm;
    ComponentMapper<Player> plm;
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
            Velocity entityF = vm.get(entityId);
            if (!checked.contains(entityId)) {
                Integer collidesWithId = checkCollides(entityId, intBag);
                if (collidesWithId != null) {
                    Velocity collidesWithF = vm.get(collidesWithId);
                    Collides coll = cm.get(collidesWithId);
                    WorldPosition wp = wpm.get(collidesWithId);
                    Velocity oldCollidesWithF = collidesWithF;
                    coll.framesColliding = QcqrConstants.CollideIdleFrames;
                   // collidesWithF.x -= (collidesWithF.x - entityF.x)*QcqrConstants.collideHack;
                   // collidesWithF.y -= (collidesWithF.y - entityF.y)*QcqrConstants.collideHack;
                    collidesWithF.x = -collidesWithF.x;
                    collidesWithF.y = -collidesWithF.y;
                    if (collidesWithF.x>0) {
                       // wp.worldX += 20;
                        collidesWithF.x += QcqrConstants.collideHack;
                    }
                    else {
                        //wp.worldX -= 20;
                        collidesWithF.x -= QcqrConstants.collideHack;
                    }
                    if (collidesWithF.y>0) {
                       // wp.worldX += 20;
                        collidesWithF.y += QcqrConstants.collideHack;
                    }
                    else{
                      //  wp.worldX -= 20;
                        collidesWithF.y -= QcqrConstants.collideHack;
                    }
                    if (plm.has(entityId))
                    {
                        Player pl = plm.get(entityId);
                        coll.CameraOffsset = new Vector2(collidesWithF.x - oldCollidesWithF.x,collidesWithF.y - oldCollidesWithF.y);
                        coll.InitialOffset = new Vector2(collidesWithF.x - oldCollidesWithF.x,collidesWithF.y - oldCollidesWithF.y);
                    }
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
        WorldPosition entityPosition = wpm.get(entityId);
        return new Rectangle(entityPosition.worldX, entityPosition.worldY, entitySize.width, entitySize.height);
    }
}
