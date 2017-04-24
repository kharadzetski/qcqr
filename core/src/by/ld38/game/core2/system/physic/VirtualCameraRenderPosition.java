package by.ld38.game.core2.system.physic;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core2.component.base.Position;
import by.ld38.game.core2.component.physics.WorldPosition;
import by.ld38.game.core2.component.player.Player;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.EntitySubscription;
import com.artemis.systems.IteratingSystem;
import com.artemis.utils.IntBag;


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
        float deltaY1 = wp.worldY - pl.worldCameraY;
        float deltaY2 = wp.worldY + QcqrConstants.WorldMaxY - pl.worldCameraY;

        if ( Math.abs (deltaX1) <= Math.abs (deltaX2) )
            pos.x = deltaX1;
        else if (Math.abs (deltaX2) < Math.abs (deltaX1))
            pos.x = deltaX2;

        if ( Math.abs (deltaY1) <= Math.abs (deltaY2) )
            pos.y = deltaY1;
        else if (Math.abs (deltaY1) < Math.abs (deltaY2))
            pos.y = deltaY2;


    }
}
