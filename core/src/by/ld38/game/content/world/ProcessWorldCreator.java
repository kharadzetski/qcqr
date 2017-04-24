package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Size;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.physics.*;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.system.Test.ShowDebugSystem;
import by.ld38.game.core.system.ai.DummyAiSystem;
import by.ld38.game.core.system.car.CarMovement;
import by.ld38.game.core.system.car.CarRotation;
import by.ld38.game.core.system.control.KeyboardCardControlSystem;
import by.ld38.game.core.system.physic.*;
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
                new ApplyMaxVelocitySystem(),
                new CarMovement(),
                new CarRotation(),
                new WorldMovementSystem(),
                new WorldClosedSystem (),
                new VirtualCameraFollow(),
                new VirtualCameraRenderPosition(),
                new ShowDebugSystem(),
                new CollisionSystem(),
                new DummyAiSystem()
        );
    }

    @Override
    protected void initialize(World world) {
        // create player
        int id = EntityHelper.createEntity(
                world, Position.class,WorldPosition.class, Force.class, Velocity.class, Car.class, Player.class,
                Animation.class, MaxVelocity.class, Size.class, Collides.class
        );
        Animation animation = world.getMapper(Animation.class).get(id);
        animation.model = AnimationAssets.CAR_HERO.getModel();
        Size size = world.getMapper(Size.class).get(id);
        size.height = animation.model.getFrameHeight();
        size.width = animation.model.getFrameWidth();

        id = EntityHelper.createEntity(world, Position.class, WorldPosition.class, Force.class, Velocity.class, Car.class,
                Animation.class, MaxVelocity.class, Collides.class, Size.class);
        WorldPosition pos = world.getMapper(WorldPosition.class).get(id);
        pos.worldX = 100;
        pos.worldY = 45;
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CAR_ENEMY_VIOLET.getModel();
        animation = world.getMapper(Animation.class).get(id);
        size = world.getMapper(Size.class).get(id);
        size.height = animation.model.getFrameHeight();
        size.width = animation.model.getFrameWidth();


        // create background
        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2-QcqrConstants.WorldMaxX/2;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 +QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -100;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2-QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 +QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -99;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 +QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 +QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -98;



        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/2;
        world.getMapper (WorldPosition.class).get(id).worldY =QcqrConstants.WorldMaxY/2  -QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -97;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX =QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -96;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX =QcqrConstants.WorldMaxX/2 +QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -95;



        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/2;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/2;
        world.getMapper(Position.class).get(id).z = -94;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/2;
        world.getMapper(Position.class).get(id).z = -93;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH0.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX =QcqrConstants.WorldMaxX/2 +QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY =QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/2;
        world.getMapper(Position.class).get(id).z = -92;

/*        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH1.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2-QcqrConstants.WorldMaxX/2;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 +QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -100;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH2.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2-QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 +QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -99;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH3.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 +QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 +QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -98;



        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH4.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/2;
        world.getMapper (WorldPosition.class).get(id).worldY =QcqrConstants.WorldMaxY/2  -QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -97;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH5.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX =QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -96;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH6.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX =QcqrConstants.WorldMaxX/2 +QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/6;
        world.getMapper(Position.class).get(id).z = -95;



        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH7.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/2;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/2;
        world.getMapper(Position.class).get(id).z = -94;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH8.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = QcqrConstants.WorldMaxX/2 -QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY = QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/2;
        world.getMapper(Position.class).get(id).z = -93;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH9.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX =QcqrConstants.WorldMaxX/2 +QcqrConstants.WorldMaxX/6;
        world.getMapper (WorldPosition.class).get(id).worldY =QcqrConstants.WorldMaxY/2 -QcqrConstants.WorldMaxY/2;
        world.getMapper(Position.class).get(id).z = -92;*/
    }
}
