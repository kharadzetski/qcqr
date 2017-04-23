package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Debug;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Text;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.physics.Force;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.system.car.CarMovement;
import by.ld38.game.core.system.car.RadCarControlSystem;
import by.ld38.game.core.system.control.KeyboardCardControlSystem;
import by.ld38.game.core.system.debug.ShowDebugInfo;
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
                new MoveRadDirection(),
                new ShowDebugInfo()//,
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


        // create debug text
        id = EntityHelper.createEntity(world, Text.class, Debug.class, Position.class);
        world.getMapper(Position.class).get(id).x = 15f;
        world.getMapper(Position.class).get(id).y = 15f;
        world.getMapper(Position.class).get(id).z = 1000f;

    }
}
