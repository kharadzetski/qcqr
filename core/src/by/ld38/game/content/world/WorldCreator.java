package by.ld38.game.content.world;

import com.artemis.BaseSystem;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;

/**
 * @author SharK729
 * @since 1.0
 */
public abstract class WorldCreator {
    private BaseSystem[] systems;

    public WorldCreator(BaseSystem... systems) {
        this.systems = systems;
    }

    public World create() {
        WorldConfiguration configuration = new WorldConfigurationBuilder()
                .with(systems)
                .build();
        World world =  new World(configuration);
        initialize(world);
        return world;
    }

    protected abstract void initialize(World world);
}