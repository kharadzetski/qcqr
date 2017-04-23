package by.ld38.game.content.screen.process.system.rad;

import by.ld38.game.content.constant.GameEnv;
import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.content.screen.process.component.WorldPosition;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class WorldMovementSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;
    private ComponentMapper<WorldPosition> wpm;

    /**
     * Creates a new EntityProcessingSystem.
     */
    public WorldMovementSystem() {
        super(Aspect.all(WorldPosition.class, Velocity.class));
    }
    @Override
    protected void process(int entityId) {
        Velocity v = vm.get(entityId);
        WorldPosition wp = wpm.get(entityId);
        wp.worldX = v.worldVX;
        wp.worldY = v.worldVY;

    }
}
