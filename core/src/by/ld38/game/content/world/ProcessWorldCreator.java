package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Size;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.system.car.CarMovement;
import by.ld38.game.core.system.control.KeyboardCardControlSystem;
import by.ld38.game.core.system.physic.MoveObjectSystem;
import by.ld38.game.core.system.render.AnimationRenderSystem;
import by.ld38.game.core.system.render.BlankScreenRenderSystem;
import by.ld38.game.core.system.render.TextRenderSystem;
import by.ld38.game.util.EntityHelper;
import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public class ProcessWorldCreator extends WorldCreator {
    public ProcessWorldCreator() {
        super(new BlankScreenRenderSystem(),
                new AnimationRenderSystem(),
                new TextRenderSystem(),
                new KeyboardCardControlSystem(),
                new MoveObjectSystem(),
                new CarMovement());
    }

    @Override
    protected void initialize(World world) {
        // create player
        int id = EntityHelper.createEntity(world, Position.class, Force.class, Velocity.class, Car.class, Player.class,
                Animation.class, Size.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CAR_HERO.getModel();
        world.getMapper(Size.class).get(id).width = AnimationAssets.CAR_HERO.getModel().getFrameWidth();
        world.getMapper(Size.class).get(id).height = AnimationAssets.CAR_HERO.getModel().getFrameHeight();

                // create background
        id = EntityHelper.createEntity(world, Position.class, Animation.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH.getModel();
        world.getMapper(Position.class).get(id).x = -QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(Position.class).get(id).y = -QcqrConstants.SCREEN_HEIGHT/2;
        world.getMapper(Position.class).get(id).z = -100;


    }
}
