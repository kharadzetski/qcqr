package by.ld38.game.system.player;

import by.ld38.game.component.base.Velocity;
import by.ld38.game.component.player.Player;
import by.ld38.game.input.KeyCode;
import by.ld38.game.input.KeyCodesHolder;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class KeyboardPlayerControlSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;

    public KeyboardPlayerControlSystem() {
        super(Aspect.one(Player.class));
    }

    @Override
    protected void process(int entityId) {
        try {
            Velocity v = vm.get(entityId);
            v.radVX = 0;
            v.radVY = 0;
            KeyCodesHolder holder = KeyCodesHolder.getInstance();
            if (holder.hasCode(KeyCode.ARROW_UP)) {
                v.radVY = .05f;
            }
            if (holder.hasCode(KeyCode.ARROW_DOWN)) {
                v.radVY = -.05f;
            }
            if (holder.hasCode(KeyCode.ARROW_LEFT)) {
                v.radVX = -.05f;
            }
            if (holder.hasCode(KeyCode.ARROW_RIGHT)) {
                v.radVX = .05f;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ERROR. player tagged entity does not have some components");
        }
    }
}
