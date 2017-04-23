package by.ld38.game.core.system.physic;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.EntitySubscription;
import com.artemis.World;
import com.artemis.systems.IteratingSystem;
import com.artemis.utils.IntBag;

/**
 * Created by m_katlinski on 23.04.2017.
 */
public class VirtualCameraRenderPosition  extends IteratingSystem {
    public VirtualCameraRenderPosition() { super(Aspect.all(WorldPosition.class, Position.class));}
    private ComponentMapper<WorldPosition> wpm;
    private ComponentMapper<Position> pm;
    @Override
    protected void process(int entityId) {
        EntitySubscription subscription = world.getAspectSubscriptionManager().get(Aspect.all(Player.class));
        IntBag PlayerEntityId = subscription.getEntities();
        Player pl =  world.getMapper(Player.class).get(PlayerEntityId.get(0));
        Position pos = pm.get(entityId);
        WorldPosition wp = wpm.get(entityId);
        float deltaX1 = wp.worldX - pl.worldCameraX;
        float deltaX2 = wp.worldX + QcqrConstants.WorldMaxX - pl.worldCameraX;
        float deltaY1 = wp.worldY - pl.worldCameraX;
        float deltaY2 = wp.worldY + QcqrConstants.WorldMaxY - pl.worldCameraY;
        if ( Math.abs (deltaX1) < QcqrConstants.SCREEN_WIDTH)
            pos.x = deltaX1;
        else if (Math.abs (deltaX2) < QcqrConstants.SCREEN_WIDTH)
            pos.x = deltaX2;
        else
            pos.x = -2000000;

        if ( Math.abs (deltaY1) < QcqrConstants.SCREEN_HEIGHT)
            pos.y = deltaX1;
        else if (Math.abs (deltaY2) < QcqrConstants.SCREEN_HEIGHT)
            pos.y = deltaX2;
        else
            pos.y = -2000000;


    }
}
