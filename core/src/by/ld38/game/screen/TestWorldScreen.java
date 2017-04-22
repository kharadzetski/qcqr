package by.ld38.game.screen;

import by.ld38.game.archetype.TestAnimationArchetype;
import by.ld38.game.component.render.Animation;
import by.ld38.game.content.AnimationContent;
import by.ld38.game.system.render.BlankScreenRenderSystem;
import by.ld38.game.system.render.RenderAnimationSystem;
import by.ld38.game.system.render.RenderFpsSystem;
import by.ld38.game.system.test.TestChangeScreenSystem;
import com.artemis.Archetype;
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
                        //new TestChangeScreenSystem()
                        new RenderAnimationSystem(),
                        new RenderFpsSystem()
                        ).build();

        //return new World(config);
        World world = new World(config);
        createTestAnimation(world);
        return world;
    }

    private void createTestAnimation(World world) {
        Archetype type = TestAnimationArchetype.testAnimation(world);
        int id = world.create(type);
        world.getMapper(Animation.class).get(id).model = AnimationContent.TEST.getModel();
    }
}
