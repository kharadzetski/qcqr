package by.ld38.game.core2.system.physic;


import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core2.component.physics.WorldPosition;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class WorldClosedSystem extends IteratingSystem {

    private ComponentMapper<WorldPosition> wpm;
    public   WorldClosedSystem() { super(Aspect.all(WorldPosition.class));}
    @Override
    protected void process(int entityId) {
        WorldPosition wp = wpm.get(entityId);
        if (wp.worldX > QcqrConstants.WorldMaxX) {
            wp.worldX -= QcqrConstants.WorldMinX;
        }
        if (wp.worldX < QcqrConstants.WorldMinX) {
            wp.worldX  = QcqrConstants.WorldMaxX - Math.abs(wp.worldX);
        }
        if (wp.worldY > QcqrConstants.WorldMaxY) {
            wp.worldY -= QcqrConstants.WorldMaxY;
        }
        if (wp.worldY <QcqrConstants.WorldMinY) {
            wp.worldY = QcqrConstants.WorldMaxY - Math.abs(wp.worldY);
        }
    }
}
