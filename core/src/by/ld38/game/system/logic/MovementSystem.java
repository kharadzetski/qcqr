package by.ld38.game.system.logic;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;

public class MovementSystem extends EntityProcessingSystem {
    /**
     * Creates a new EntityProcessingSystem.
     *
     * @param aspect the aspect to match entities
     */
    public MovementSystem(Aspect.Builder aspect) {
        super(aspect);
    }

    @Override
    protected void process(Entity e) {

    }
}
