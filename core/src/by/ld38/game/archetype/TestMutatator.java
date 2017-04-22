package by.ld38.game.archetype;

import by.ld38.game.component.base.Velocity;
import by.ld38.game.utils.TransmutateEntity;
import com.artemis.Component;
import com.artemis.World;

import java.util.Arrays;
import java.util.Collection;

/**
 * Tech demo mutator
 *
 * @author SharK729
 * @since 1.0
 */
public class TestMutatator extends TransmutateEntity {
    @Override
    protected Collection<Class<? extends Component>> getAddTypes() {
        return Arrays.asList(Velocity.class);
    }

    public static void mutate(World world, int id) {
        new TestMutatator().transmutate(world, id);
    }
}
