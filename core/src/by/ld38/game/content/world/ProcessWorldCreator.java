package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.assets.SpeedHudAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Size;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.car.PlanetScale;
import by.ld38.game.core.component.energy.Energy;
import by.ld38.game.core.component.hud.HudSpeedArrow;
import by.ld38.game.core.component.hud.HudSpeedMeter;
import by.ld38.game.core.component.item.Quarktus;
import by.ld38.game.core.component.physics.*;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.system.Test.ShowDebugSystem;
import by.ld38.game.core.system.ai.DummyAiSystem;
import by.ld38.game.core.system.car.CarMovement;
import by.ld38.game.core.system.car.CarRotation;
import by.ld38.game.core.system.control.KeyboardCardControlSystem;
import by.ld38.game.core.system.hud.EnergyHudSystem;
import by.ld38.game.core.system.item.QurktusCollisionSystem;
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
                new DummyAiSystem(),
                new EnergyHudSystem(),
                new QurktusCollisionSystem()
        );
    }

    @Override
    protected void initialize(World world) {
        createHud(world);
        for (int i=0; i< 30; i++) generateRandomQuarktus(world);

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

        id = EntityHelper.createEntity(world, Position.class, WorldPosition.class, Force.class, Velocity.class, Car.class, PlanetScale.class,
                Animation.class, MaxVelocity.class, Collides.class, Size.class);
        WorldPosition pos = world.getMapper(WorldPosition.class).get(id);
        pos.worldX = 100;
        pos.worldY = 45;
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CAR_ENEMY_VIOLET.getModel();
        animation = world.getMapper(Animation.class).get(id);
        size = world.getMapper(Size.class).get(id);
        size.height = animation.model.getFrameHeight();
        size.width = animation.model.getFrameWidth();
        for (int i = 1; i < 100; i ++) {
            id = EntityHelper.createEntity(world, Position.class, WorldPosition.class, Force.class, Velocity.class, Car.class,
                    Animation.class, MaxVelocity.class, Collides.class, Size.class);
            pos = world.getMapper(WorldPosition.class).get(id);
            pos.worldX = i * 100;
            pos.worldY = i * 45;
            world.getMapper(Animation.class).get(id).model = AnimationAssets.CAR_ENEMY_VIOLET.getModel();
            animation = world.getMapper(Animation.class).get(id);
            size = world.getMapper(Size.class).get(id);
            size.height = animation.model.getFrameHeight();
            size.width = animation.model.getFrameWidth();
        }


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

        id = EntityHelper.createEntity(world, Position.class, Animation.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.PlanetOffset.getModel();
        world.getMapper(Position.class).get(id).x = -QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(Position.class).get(id).y = -QcqrConstants.SCREEN_HEIGHT/2;
        world.getMapper(Position.class).get(id).z = 1000;
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

    private void createHud(World world) {
        // meter
        float hudX = -600;
        float hudY = 200;
        float arrowX = hudX + 28;
        float arrowY = hudY - 27;


        int id = EntityHelper.createEntity(world, Animation.class, Position.class, HudSpeedMeter.class);
        world.getMapper(Animation.class).get(id).model = SpeedHudAssets.SPEED_METER.getModel();
        world.getMapper(Position.class).get(id).x = hudX;
        world.getMapper(Position.class).get(id).y = hudY;

        // arrow
        id = EntityHelper.createEntity(world, Animation.class, Position.class, HudSpeedArrow.class);
        world.getMapper(Animation.class).get(id).model = SpeedHudAssets.SPEED_ARROW.getModel();
        world.getMapper(Position.class).get(id).x = arrowX;
        world.getMapper(Position.class).get(id).y = arrowY;
    }


    private void generateRandomQuarktus(World world) {
        int id = EntityHelper.createEntity(world, Animation.class, Position.class, Quarktus.class, WorldPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.QUARKTUS.getModel();
        world.getMapper(WorldPosition.class).get(id).worldX = (float) (Math.random()* QcqrConstants.WorldMaxX);
        world.getMapper(WorldPosition.class).get(id).worldY = (float) (Math.random()* QcqrConstants.WorldMaxY);

    }
}
