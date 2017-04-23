package by.ld38.game.content.screen.process.system.player;

import by.ld38.game.content.screen.process.component.CarControl;
import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.content.screen.process.component.Player;
import by.ld38.game.core.input.KeyCode;
import by.ld38.game.core.input.KeyCodesHolder;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

public class KeyboardPlayerControlSystem extends IteratingSystem {

    private ComponentMapper<CarControl> ccm;

    public KeyboardPlayerControlSystem() {
        super(Aspect.one(Player.class));
    }

    @Override
    protected void process(int entityId) {
        CarControl cc = ccm.get(entityId);
        cc.reset();
        KeyCodesHolder holder = KeyCodesHolder.getInstance();
        if (holder.hasCode(KeyCode.ARROW_UP)) cc.up = true;
        if (holder.hasCode(KeyCode.ARROW_DOWN)) cc.down = true;
        if (holder.hasCode(KeyCode.ARROW_LEFT)) cc.left = true;
        if (holder.hasCode(KeyCode.ARROW_RIGHT)) cc.right = true;
    }
}
