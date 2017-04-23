package by.ld38.game.core.system.physic;


import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class WorldMovementSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;
    private ComponentMapper<WorldPosition> wpm;

    /**
     * Creates a new EntityProcessingSystem.
     */
    public WorldMovementSystem() { super(Aspect.all(WorldPosition.class, Velocity.class));}

    @Override
    protected void process(int entityId) {
        Velocity v = vm.get(entityId);
        WorldPosition wp = wpm.get(entityId);
        wp.worldX += v.x;
        wp.worldY += v.y;
   //     if (checkCollision()) {
     //       position.x += velocity.x;
     //       position.y += velocity.y;
        }
}