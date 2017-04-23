package by.ld38.game.utils.help;

import com.artemis.Component;
import com.artemis.World;

import java.util.Collection;

/**
 * New entity helper.
 *
 * @author SharK729
 * @since 1.0
 */
public abstract class CreateEntityHelper {
    protected abstract Collection<Class<? extends Component>> getTypes();

    public int createEntity(World world) {
        int id = world.create();
        EntityHelper.add(world, id, getTypes());
        return id;
    }

}
