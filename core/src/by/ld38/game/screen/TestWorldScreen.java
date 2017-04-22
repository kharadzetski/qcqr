package by.ld38.game.screen;

import by.ld38.game.system.base.BlankScreenRenderSystem;
import by.ld38.game.system.test.TestChangeScreenSystem;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;

/**
 * Quick tech demo
 *
 * @author SharK729
 * @since 1.0
 */
public class TestWorldScreen extends WorldScreen {

    @Override
    public World generateWorld() {
        WorldConfiguration config = new WorldConfigurationBuilder()
                //.dependsOn(MyPlugin.class)
                .with(
                        new BlankScreenRenderSystem(),
                        new TestChangeScreenSystem()
                        ).build();

        return new World(config);
    }
}
