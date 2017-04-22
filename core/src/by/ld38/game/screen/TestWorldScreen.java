package by.ld38.game.screen;

import by.ld38.game.archetype.TestAnimationArchetype;
import by.ld38.game.component.base.RadPosition;
import by.ld38.game.component.render.Animation;
import by.ld38.game.content.AnimationContent;
import by.ld38.game.input.KeyboardInputProcessor;
import by.ld38.game.system.logic.Rad2DecPositionSystem;
import by.ld38.game.system.logic.RadMovementSystem;
import by.ld38.game.system.logic.VelocityDeltaSystem;
import by.ld38.game.system.player.KeyboardPlayerControlSystem;
import by.ld38.game.system.render.BlankScreenRenderSystem;
import by.ld38.game.system.render.RenderAnimationSystem;
import by.ld38.game.system.render.RenderFpsSystem;
import com.artemis.Archetype;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

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
                        //new TestChangeScreenSystem()
                        new RenderAnimationSystem(),
                        new RenderFpsSystem(),
                        new RadMovementSystem(),
                        new VelocityDeltaSystem(),
                        new Rad2DecPositionSystem(),
                        new KeyboardPlayerControlSystem()
                        ).build();

        //return new World(config);
        World world = new World(config);
        createTestAnimation(world);
        InputProcessor kip = new KeyboardInputProcessor();
        Gdx.input.setInputProcessor(kip);
        return world;
    }

    private void createTestAnimation(World world) {
        Archetype type = TestAnimationArchetype.testAnimation(world);
        int id = world.create(type);
        world.getMapper(Animation.class).get(id).model = AnimationContent.TEST.getModel();
        world.getMapper(RadPosition.class).get(id).radX = 40f;
        world.getMapper(RadPosition.class).get(id).radY = 60f;
    }
}
