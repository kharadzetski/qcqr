package by.ld38.game.core2.system.render.src.by.ld38.game.core.system.physic;

import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.player.Player;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

/**
 * Created by m_katlinski on 23.04.2017.
 */
public class VirtualCameraFollow extends IteratingSystem {
    public VirtualCameraFollow() {
        super(Aspect.all(Player.class, WorldPosition.class));
    }
    private ComponentMapper<Player> pm;
    private ComponentMapper<WorldPosition> wpm;
    @Override
    protected void process(int entityId) {
        Player p = pm.get(entityId);
        WorldPosition wp = wpm.get(entityId);
        p.worldCameraX = wp.worldX;
        p.worldCameraY = wp.worldY;
        
    }
}
