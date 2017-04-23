package by.ld38.game.content.screen.process;

import by.ld38.game.content.asset.AnimationContent;
import by.ld38.game.content.screen.WorldScreen;
import by.ld38.game.content.screen.common.system.RenderTextSystem;
import by.ld38.game.content.screen.process.item.CarHeroItem;
import by.ld38.game.content.screen.process.item.PlanetItem;
import by.ld38.game.content.screen.process.system.rad.Rad2DecPositionSystem;
import by.ld38.game.content.screen.process.system.rad.RadMovementSystem;
import by.ld38.game.content.screen.process.system.rad.RadToScaleSystem;
import by.ld38.game.content.screen.process.system.VelocityDeltaSystem;
import by.ld38.game.content.screen.common.system.render.BlankScreenRenderSystem;
import by.ld38.game.content.screen.common.system.render.RenderAnimationSystem;
import by.ld38.game.content.screen.common.system.render.RenderFpsSystem;
import by.ld38.game.content.screen.process.system.player.KeyboardPlayerControlSystem;
import by.ld38.game.content.screen.test.system.ShowDebugSystem;
import by.ld38.game.core.input.KeyboardInputProcessor;
import by.ld38.game.core.item.ItemHolder;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

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
                        //new TestChangeScreenSystem()
                        new RenderAnimationSystem(),
                        new RenderFpsSystem(),
                        new RadMovementSystem(),
                        new VelocityDeltaSystem(),
                        new Rad2DecPositionSystem(),
                        new KeyboardPlayerControlSystem(),
                        new RadToScaleSystem(),
                        new ShowDebugSystem(),
                        new RenderTextSystem())
                .build();
        World world = new World(config);
        createTestAnimation(world);
        InputProcessor kip = new KeyboardInputProcessor();
        Gdx.input.setInputProcessor(kip);
        return world;
    }

    private void createTestAnimation(World world) {
        PlanetItem item = ItemHolder.create(world, CarHeroItem.class);

        //item.velocity.radVX = .005f;
        //item.velocity.radVY = .01f;
        item.radPosition.radX = 40f;
        item.radPosition.radX = 60f;
    }
}
