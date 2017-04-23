package by.ld38.game.content.screen.process.system.player;

import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.content.screen.process.component.Player;
import by.ld38.game.core.input.KeyCode;
import by.ld38.game.core.input.KeyCodesHolder;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class KeyboardPlayerControlSystem extends IteratingSystem {

    private ComponentMapper<Velocity> vm;

    public KeyboardPlayerControlSystem() {
        super(Aspect.one(Player.class));
    }

    private float delta = .05f;

    @Override
    protected void process(int entityId) {
        try {
            Velocity v = vm.get(entityId);
            v.radVX = 0;
            v.radVY = 0;
            KeyCodesHolder holder = KeyCodesHolder.getInstance();
            if (holder.hasCode(KeyCode.ARROW_UP)) {
                v.radVY = delta;
            }
            if (holder.hasCode(KeyCode.ARROW_DOWN)) {
                v.radVY = -delta;
            }
            if (holder.hasCode(KeyCode.ARROW_LEFT)) {
                v.radVX = -delta;
            }
            if (holder.hasCode(KeyCode.ARROW_RIGHT)) {
                v.radVX = delta;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ERROR. player tagged entity does not have some components");
        }
    }
}
