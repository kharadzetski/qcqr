package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.system.car.CarMovement;
import by.ld38.game.core.system.car.RadCarControlSystem;
import by.ld38.game.core.system.control.KeyboardCardControlSystem;
import by.ld38.game.core.system.physic.*;
import by.ld38.game.core.system.rad.MoveRadDirection;
import by.ld38.game.core.system.rad.Rad2PositionSystem;
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
                //new CarMovement(),
                new RadCarControlSystem(),
                new WorldMovementSystem(),
                new Rad2PositionSystem(),
                new MoveRadDirection()//,
                //new WorldClosedSystem (),
                //new VirtualCameraFollow(),
                //new VirtualCameraRenderPosition()
        );
    }

    @Override
    protected void initialize(World world) {
        // create player
        int id = EntityHelper.createEntity(world, Position.class,WorldPosition.class, Force.class, Velocity.class, Car.class, Player.class,
                Animation.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CAR_HERO.getModel();


        // create background
        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH1.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = -QcqrConstants.WorldMaxX/3;
        world.getMapper (WorldPosition.class).get(id).worldY = +QcqrConstants.WorldMaxY/3;
        world.getMapper(Position.class).get(id).z = -100;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH2.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = 0;
        world.getMapper (WorldPosition.class).get(id).worldY = +QcqrConstants.WorldMaxY/3;
        world.getMapper(Position.class).get(id).z = -99;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH3.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = +QcqrConstants.WorldMaxX/3;
        world.getMapper (WorldPosition.class).get(id).worldY = +QcqrConstants.WorldMaxY/3;
        world.getMapper(Position.class).get(id).z = -98;



        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH4.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = -QcqrConstants.WorldMaxX/3;
        world.getMapper (WorldPosition.class).get(id).worldY = 0;
        world.getMapper(Position.class).get(id).z = -100;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH5.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = 0;
        world.getMapper (WorldPosition.class).get(id).worldY = 0;
        world.getMapper(Position.class).get(id).z = -99;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH6.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = +QcqrConstants.WorldMaxX/3;
        world.getMapper (WorldPosition.class).get(id).worldY = 0;
        world.getMapper(Position.class).get(id).z = -99;



        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH7.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = -QcqrConstants.WorldMaxX/3;
        world.getMapper (WorldPosition.class).get(id).worldY = -QcqrConstants.WorldMaxY/3;
        world.getMapper(Position.class).get(id).z = -100;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH8.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = 0;
        world.getMapper (WorldPosition.class).get(id).worldY = -QcqrConstants.WorldMaxY/3;
        world.getMapper(Position.class).get(id).z = -99;

        id = EntityHelper.createEntity(world, Position.class, Animation.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.BACKGROUND_EARTH9.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = +QcqrConstants.WorldMaxX/3;
        world.getMapper (WorldPosition.class).get(id).worldY = -QcqrConstants.WorldMaxY/3;
        world.getMapper(Position.class).get(id).z = -99;
    }
}
