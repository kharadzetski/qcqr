package by.ld38.game.screen;

import by.ld38.game.system.logic.Rad2DecPositionSystem;
import by.ld38.game.system.logic.RadMovementSystem;
import by.ld38.game.system.logic.VelocityDeltaSystem;
import by.ld38.game.system.render.BlankScreenRenderSystem;
import by.ld38.game.system.render.RenderAnimationSystem;
import by.ld38.game.system.render.RenderFpsSystem;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class GameProcessWorldScreen extends WorldScreen {
    @Override
    public World generateWorld() {
        WorldConfiguration config = new WorldConfigurationBuilder()
                .with(new BlankScreenRenderSystem(),
                        new RenderAnimationSystem(),
                        new RenderFpsSystem(),
                        new RadMovementSystem(),
                        new VelocityDeltaSystem(),
                        new Rad2DecPositionSystem())
                .build();
        return new World(config);
    }
}
