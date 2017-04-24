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
        float deltaY1 = wp.worldY - pl.worldCameraY;
        float deltaX2;
        float deltaY2;
        if(Math.abs(wp.worldX  -  pl.worldCameraX) >= QcqrConstants.WorldMaxX/2)
        {
            if(pl.worldCameraX >= QcqrConstants.WorldMaxX/2 )
                deltaX2  = (wp.worldX+ QcqrConstants.WorldMaxX) - pl.worldCameraX;
            else
                deltaX2  = (wp.worldX - QcqrConstants.WorldMaxX) - pl.worldCameraX;
        }
        else
        {
            deltaX2  =deltaX1 ;
        }

        if( Math.abs(wp.worldY  -  pl.worldCameraY) >= QcqrConstants.WorldMaxY/2 )
        {
            if(pl.worldCameraY >= QcqrConstants.WorldMaxY/2 )
                deltaY2  = (wp.worldY + QcqrConstants.WorldMaxY) - pl.worldCameraY;
            else
                deltaY2  = (wp.worldY - QcqrConstants.WorldMaxY) - pl.worldCameraY;
        }
        else
        {
            deltaY2  =deltaY1;
        }

        float dist1 =  (float)Math.sqrt( (deltaX1*deltaX1) + (deltaY1*deltaY1));
        float dist2 =  (float)Math.sqrt( (deltaX2*deltaX2) + (deltaY2*deltaY2));
        if ( dist1 <= dist2 ) {
            pos.x = deltaX1;
            pos.y = deltaY1;
        }
        else{
            pos.x = deltaX2;
            pos.y = deltaY2;
        }

  //      if ( Math.abs (deltaX1) <= Math.abs (deltaX2) )
  //          pos.x = deltaX1;
   //     else if (Math.abs (deltaX2) < Math.abs (deltaX1))
   //         pos.x = deltaX2;

   //     if ( Math.abs (deltaY1) <= Math.abs (deltaY2) )
    //        pos.y = deltaY1;
    //    else if (Math.abs (deltaY1) < Math.abs (deltaY2))
     //       pos.y = deltaY2;


    }
}
