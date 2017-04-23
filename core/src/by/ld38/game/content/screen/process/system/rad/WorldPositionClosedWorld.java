package by.ld38.game.content.screen.process.system.rad;

import by.ld38.game.content.constant.GameEnv;
import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.content.screen.process.component.WorldPosition;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class WorldPositionClosedWorld extends IteratingSystem {

    private ComponentMapper<Velocity> vm;
    private ComponentMapper<WorldPosition> wpm;
    public   WorldPositionClosedWorld() { super(Aspect.all(WorldPosition.class, Velocity.class));}
    @Override
    protected void process(int entityId) {
        Velocity v = vm.get(entityId);
        WorldPosition wp = wpm.get(entityId);
        if (wp.worldX > GameEnv.WorldMaxX) {
            wp.worldX -= GameEnv.WorldMinX;
        }
        if (wp.worldX < GameEnv.WorldMinX) {
            wp.worldX  = GameEnv.WorldMaxX - Math.abs(wp.worldX);
        }
        if (wp.worldY > GameEnv.WorldMaxY) {
            wp.worldY -= GameEnv.WorldMaxY;
        }
        if (wp.worldY <GameEnv.WorldMinX) {
            wp.worldY = GameEnv.WorldMaxY - Math.abs(wp.worldY);;
        }
    }
}
