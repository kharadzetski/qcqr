package by.ld38.game.archetype;

import by.ld38.game.component.base.Position;
import by.ld38.game.component.render.Animation;
import by.ld38.game.component.render.RenderOrder;
import by.ld38.game.utils.NewEntity;
import com.artemis.Component;
import com.artemis.World;

import java.util.Arrays;
import java.util.Collection;

/**
 * TechDemo
 *
 * @author SharK729
 * @since 1.0
 */
public class TestEntityCreator extends NewEntity {
    @Override
    protected Collection<Class<? extends Component>> getTypes() {
        return Arrays.asList(Animation.class, Position.class, RenderOrder.class);
    }

    public static int create(World world) {
        return new TestEntityCreator().create(world);
    }
}
