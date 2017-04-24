package by.ld38.game.core2.system.render.src.by.ld38.game.core.system.physic;


import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.base.Position;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.physics.WorldPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

public class WorldMovementSystem extends IteratingSystem {

    /**
     * Creates a new EntityProcessingSystem.
     */
    public WorldMovementSystem() { super(Aspect.all(WorldPosition.class, Velocity.class, Position.class));}

    @Override
    protected void process(int entityId) {
        Velocity v = world.getMapper(Velocity.class).get(entityId);
        WorldPosition wp = world.getMapper(WorldPosition.class).get(entityId);
        Position pos = world.getMapper(Position.class).get(entityId);

        wp.worldX += v.x;
        wp.worldY += v.y;
   //     if (checkCollision()) {
        pos.x += v.x;
        pos.y += v.y;
        }
}