package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.intro.IntroText;
import by.ld38.game.core.system.intro.InputIntroSystem;
import by.ld38.game.core.system.render.AnimationRenderSystem;
import by.ld38.game.core.system.render.BlankScreenRenderSystem;
import by.ld38.game.util.EntityHelper;
import com.artemis.World;

public class IntroScreenCreator extends WorldCreator {
    public IntroScreenCreator() {
        super(
                new BlankScreenRenderSystem(),
                new AnimationRenderSystem(),
                new InputIntroSystem()
        );
    }

    @Override
    protected void initialize(World world) {
        int id = EntityHelper.createEntity(
                world,
                Animation.class,
                Position.class,
                IntroText.class
                );
        Position pos = world.getMapper(Position.class).get(id);
        pos.x = -QcqrConstants.SCREEN_WIDTH/2;
        pos.y = -QcqrConstants.SCREEN_HEIGHT/2;
        Animation a = world.getMapper(Animation.class).get(id);
        a.model = AnimationAssets.INTRO_TEXT_1.getModel();
    }
}
