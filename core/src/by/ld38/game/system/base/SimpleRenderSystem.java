package by.ld38.game.system.base;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.systems.EntityProcessingSystem;

public class SimpleRenderSystem extends EntityProcessingSystem {
    /**
     * Creates an entity system that uses the specified aspect as a matcher
     * against entities.
     *
     * @param aspect to match against entities
     */
    public SimpleRenderSystem(Aspect.Builder aspect) {
        super(aspect);
    }

    @Override
    protected void process(Entity e) {

    }

}
