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
        int bgId = EntityHelper.createEntity(
                world,
                Animation.class,
                Position.class
        );
        Position bgPos = world.getMapper(Position.class).get(bgId);
        bgPos.x = -QcqrConstants.SCREEN_WIDTH/2;
        bgPos.y = -QcqrConstants.SCREEN_HEIGHT/2;
        Animation bgA = world.getMapper(Animation.class).get(bgId);
        bgA.model = AnimationAssets.INTRO_BG.getModel();

        int tiresId = EntityHelper.createEntity(
                world,
                Animation.class,
                Position.class
        );
        Position tiresPos = world.getMapper(Position.class).get(tiresId);
        tiresPos.x = 320;
        tiresPos.y = -260;
        Animation tiresA = world.getMapper(Animation.class).get(tiresId);
        tiresA.model = AnimationAssets.INTRO_TIRES.getModel();

        int rocksId = EntityHelper.createEntity(
                world,
                Animation.class,
                Position.class
        );
        Position rocksPos = world.getMapper(Position.class).get(rocksId);
        rocksPos.x = -QcqrConstants.SCREEN_WIDTH/2;
        rocksPos.y = -QcqrConstants.SCREEN_HEIGHT/2;
        Animation rocksA = world.getMapper(Animation.class).get(rocksId);
        rocksA.model = AnimationAssets.INTRO_ROCKS.getModel();

        int flameID = EntityHelper.createEntity(
                world,
                Animation.class,
                Position.class
        );
        Position flamePos = world.getMapper(Position.class).get(flameID);
        flamePos.x = -QcqrConstants.SCREEN_WIDTH/2;
        flamePos.y = -QcqrConstants.SCREEN_HEIGHT/2;
        Animation flameA = world.getMapper(Animation.class).get(flameID);
        flameA.model = AnimationAssets.INTRO_FLAME.getModel();

        int carId = EntityHelper.createEntity(
                world,
                Animation.class,
                Position.class
        );
        Position carPos = world.getMapper(Position.class).get(carId);
        carPos.x = 339;
        carPos.y = 0;
        carPos.scale = 2;
        Animation carA = world.getMapper(Animation.class).get(carId);
        carA.model = AnimationAssets.CAR_HERO_TURBO.getModel();

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
