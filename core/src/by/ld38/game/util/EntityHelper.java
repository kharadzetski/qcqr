package by.ld38.game.util;

import com.artemis.Component;
import com.artemis.World;

import java.util.Arrays;

/**
 * @author SharK729
 * @since 1.0
 */
public class EntityHelper {
    public static int createEntity(World world, Class<? extends Component>... types) {
        int id = world.create();
        Arrays.stream(types)
                .forEach(type -> world.getMapper(type).create(id));
        return id;
    }
}