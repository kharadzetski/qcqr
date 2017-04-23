package by.ld38.game.utils.help;

import by.ld38.game.content.screen.process.component.Velocity;
import com.artemis.Component;
import com.artemis.World;
import com.badlogic.gdx.utils.Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Transmutate entity helper.
 *
 * @author SharK729
 * @since 1.0
 */
public abstract class TransmutateEntity {
    protected Collection<Class<? extends Component>> addTypes;
    protected Collection<Class<? extends Component>> removeTypes;

    public TransmutateEntity( Collection<Class<? extends Component>> addTypes,
                              Collection<Class<? extends Component>> removeTypes) {
        this.addTypes = addTypes;
        this.removeTypes = removeTypes;
    }

    public void transmutate(World world, int id) {
        EntityHelper.add(world, id, addTypes);
        EntityHelper.remove(world, id, removeTypes);
    }
}
