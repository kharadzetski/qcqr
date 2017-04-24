package by.ld38.game.content.world;

import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Debug;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.base.Text;
import by.ld38.game.core.component.car.Car;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.component.rad.RadForce;
import by.ld38.game.core.component.rad.RadPosition;
import by.ld38.game.core.component.rad.RadVelocity;
import by.ld38.game.core.system.car.RadCarControlSystem;
import by.ld38.game.core.system.control.KeyboardCardControlSystem;
import by.ld38.game.core.system.debug.ShowDebugInfo;
import by.ld38.game.core.system.physic.*;
import by.ld38.game.core.system.rad.MoveRadDirection;
import by.ld38.game.core.system.rad.Rad2PositionSystem;
import by.ld38.game.core.system.rad.RadForceSystem;
import by.ld38.game.core.system.render.AnimationRenderSystem;
import by.ld38.game.core.system.render.BlankScreenRenderSystem;
import by.ld38.game.core.system.render.TextRenderSystem;
import by.ld38.game.util.DegreeUtil;
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
                new ShowDebugInfo(),
                new RadForceSystem()
        );
    }

    @Override
    protected void initialize(World world) {
        // create player
        int id = EntityHelper.createEntity(world, Position.class, RadVelocity.class, RadForce.class, RadPosition.class, Car.class, Player.class,
                Animation.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CAR_HERO.getModel();


        // create debug text
        id = EntityHelper.createEntity(world, Text.class, Debug.class, Position.class);
        world.getMapper(Position.class).get(id).x = - QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(Position.class).get(id).y = - QcqrConstants.SCREEN_HEIGHT/2 + 200;
        world.getMapper(Position.class).get(id).z = 1000f;

        id = EntityHelper.createEntity(world, Position.class, Animation.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CORE.getModel();
        world.getMapper(Position.class).get(id).x = -100;//QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(Position.class).get(id).y = -100;//QcqrConstants.SCREEN_HEIGHT/2;
        world.getMapper(Position.class).get(id).z = 0f;

        for (int i=0; i < 40; i++) generateRandomDot(world);
    }

    private void generateRandomDot(World world) {
        int id = EntityHelper.createEntity(world, Position.class, Animation.class, RadPosition.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.SMALL_ROUND.getModel();
        world.getMapper(RadPosition.class).get(id).alpha = DegreeUtil.deg2rad((float) Math.random()*360);//QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(RadPosition.class).get(id).beta = DegreeUtil.deg2rad((float) Math.random()*360);//QcqrConstants.SCREEN_HEIGHT/2;
    }
}
