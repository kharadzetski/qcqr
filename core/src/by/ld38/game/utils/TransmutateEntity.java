package by.ld38.game.utils;

import com.artemis.Component;
import com.artemis.World;

import java.util.Arrays;
import java.util.Collection;

/**
 * Transmutate entity helper.
 *
 * @author SharK729
 * @since 1.0
 */
public abstract class TransmutateEntity {
    protected Collection<Class<? extends Component>> getAddTypes() {
        return Arrays.asList();
    }

    protected Collection<Class<? extends Component>> getRemoveTypes() {
        return Arrays.asList();
    }

    public void transmutate(World world, int id) {
        EntityHelper.add(world, id, getAddTypes());
        EntityHelper.remove(world, id, getRemoveTypes());
    }
}
