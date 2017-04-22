package by.ld38.game.utils;

import com.artemis.Component;
import com.artemis.World;

import java.util.Arrays;
import java.util.Collection;

/**
 * Help static functions.
 *
 * @author SharK729
 * @since 1.0
 */
public abstract class EntityHelper {
    public static void add(World world, int id, Class<? extends Component>... types) {
        add(world, id, Arrays.asList(types));
    }

    public static void add(World world, int id, Collection<Class<? extends Component>> types) {
        types.forEach( type -> world.getMapper(type).create(id) );
    }

    public static void remove(World world, int id, Class<? extends Component>... types) {
        remove(world, id, Arrays.asList(types));
    }

    public static void remove(World world, int id, Collection<Class<? extends Component>> types) {
        types.forEach( type -> world.getMapper(type).remove(id) );
    }
}
