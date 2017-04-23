package by.ld38.game.content.world;

import by.ld38.game.core.system.render.AnimationRenderSystem;
import by.ld38.game.core.system.render.TextRenderSystem;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;

/**
 * @author SharK729
 * @since 1.0
 */
public class WorldCreator {
    public static World createProcessWorld() {
        WorldConfiguration configuration = new WorldConfigurationBuilder()
                .with(new AnimationRenderSystem())
                .with(new TextRenderSystem())
                .build();
        return new World(configuration);
    }
}
