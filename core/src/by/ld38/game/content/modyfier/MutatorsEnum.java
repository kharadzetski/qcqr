package by.ld38.game.content.modyfier;

import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.utils.help.TransmutateEntity;
import com.artemis.World;

import java.util.Arrays;
import java.util.Collections;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public enum MutatorsEnum {
    CAR( new CarMutator() )
    ;
    private TransmutateEntity mutator;

    MutatorsEnum(TransmutateEntity mutator) {
        this.mutator = mutator;
    }
    public void mutate(World world, int id) {
        mutator.transmutate(world, id);
    }
}

class CarMutator extends TransmutateEntity {
    public CarMutator() {
        super( Arrays.asList(Velocity.class), Collections.emptyList());
    }
}

