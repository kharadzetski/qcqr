package by.ld38.game.screen;

import com.artemis.World;

/**
 * Base interface for screens
 *
 * @author SharK729
 * @since 1.0
 */
public abstract class WorldScreen {
    protected World world;

    public WorldScreen() {
        this.world = generateWorld();
    }

    public abstract World generateWorld();

    public void render(float delta) {
        //world.setDelta(MathUtils.clamp(delta, 0, 1 / 15f));
        world.process();
    }
}
