package by.ld38.game.utils.help;

import com.artemis.Component;
import com.artemis.World;

import java.util.Arrays;
import java.util.Collection;

/**
 * New entity helper.
 *
 * @author SharK729
 * @since 1.0
 */
public abstract class CreateEntityHelper {
    private Collection<Class<? extends Component>> types;

    public CreateEntityHelper(Class<? extends Component>... types) {
        this.types = Arrays.asList(types);
    }

    public int createEntity(World world) {
        int id = world.create();
        EntityHelper.add(world, id, types);
        initializeEntity(world, id);
        return id;
    }

    protected void initializeEntity(World world, int id) {}
}
