package by.ld38.game.archetype;

import by.ld38.game.component.base.Position;
import by.ld38.game.component.render.Animation;
import com.artemis.Archetype;
import com.artemis.ArchetypeBuilder;
import com.artemis.World;

/**
 * Tech demo for animation
 *
 * @author SharK729
 * @since 1.0
 */
public class TestAnimationArchetype {
    public static Archetype testAnimation(World world) {
        Archetype archetype = new ArchetypeBuilder()
                .add(Animation.class)
                .add(Position.class)
                .build(world);
        return archetype;
    }
}
