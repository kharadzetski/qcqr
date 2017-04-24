package by.ld38.game.core.system.physic;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.physics.Collides;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

/**
 * Created by m_katlinski on 23.04.2017.
 */
public class VirtualCameraFollow extends IteratingSystem {
    public VirtualCameraFollow() {
        super(Aspect.all(Player.class, WorldPosition.class,Collides.class));
    }
    private ComponentMapper<Player> pm;
    private ComponentMapper<WorldPosition> wpm;
    private ComponentMapper<Collides> ColM;
    @Override
    protected void process(int entityId) {
        Player p = pm.get(entityId);
        WorldPosition wp = wpm.get(entityId);
        Collides col = ColM.get(entityId);
        ;


        p.worldCameraX = wp.worldX;
        p.worldCameraY = wp.worldY;
        if(col.CameraOffsset.y<=0 || col.CameraOffsset.x<=0)
            return;
        if(col.CameraOffsset.y>0)
            col.CameraOffsset.y = col.InitialOffset.y*col.framesColliding/QcqrConstants.CollideIdleFrames;
        if(col.CameraOffsset.x>0)
            col.CameraOffsset.x = col.InitialOffset.x*col.framesColliding/QcqrConstants.CollideIdleFrames;
        p.worldCameraX += col.CameraOffsset.x;
        p.worldCameraY += col.CameraOffsset.y;

        
    }
}
