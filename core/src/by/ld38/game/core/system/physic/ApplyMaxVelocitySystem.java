package by.ld38.game.core.system.physic;

import by.ld38.game.core.component.physics.MaxVelocity;
import by.ld38.game.core.component.physics.Velocity;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;

public class ApplyMaxVelocitySystem extends IteratingSystem {

    ComponentMapper<Velocity> vm;
    ComponentMapper<MaxVelocity> mvm;

    /**
     * Creates a new EntityProcessingSystem.
     */
    public ApplyMaxVelocitySystem() {
        super(Aspect.all(Velocity.class, MaxVelocity.class));
    }

    @Override
    protected void process(int entityId) {
        Velocity v = vm.get(entityId);
        MaxVelocity mv = mvm.get(entityId);
        Vector2 clampedV = new Vector2(v.x, v.y).clamp(0, mv.max);
        if (Math.abs(clampedV.x) < .001f) {
            clampedV.x = 0;
        }
        if (Math.abs(clampedV.y) < .001f) {
            clampedV.y = 0;
        }
        v.x = clampedV.x;
        v.y = clampedV.y;
    }
}
