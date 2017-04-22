package by.ld38.game.archetype;

import by.ld38.game.component.base.Position;
import by.ld38.game.component.base.RadPosition;
import by.ld38.game.component.base.Velocity;
import by.ld38.game.component.player.Player;
import by.ld38.game.component.render.Animation;
import by.ld38.game.component.render.RenderOrder;
import by.ld38.game.component.render.Scale;
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
                .add(RenderOrder.class)
                .add(Velocity.class)
                .add(RadPosition.class)
                .add(Player.class)
                .add(Scale.class)
                .build(world);
        return archetype;
    }
}
