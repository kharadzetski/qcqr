package by.ld38.game.core.system.item;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.energy.Energy;
import by.ld38.game.core.component.item.Quarktus;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.util.BoxUtil;
import by.ld38.game.util.EntityHelper;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class QurktusCollisionSystem extends IteratingSystem {
    WorldPosition playerPosition;
    Energy energy;

    public QurktusCollisionSystem() {
        super(Aspect.all(Quarktus.class));
    }

    @Override
    protected void process(int entityId) {
        if (playerPosition == null) {
            int id = EntityHelper.findEntities(world, Player.class).get(0);
            playerPosition = world.getMapper(WorldPosition.class).get(id);
            energy = world.getMapper(Energy.class).get(id);
        }

        WorldPosition quark = world.getMapper(WorldPosition.class).get(entityId);
        if (BoxUtil.checkCollision(playerPosition.worldX, playerPosition.worldY, 60,60,
                quark.worldX, quark.worldY, 70, 70)) {
            world.delete(entityId);
            energy.value += 10;
        }
    }
}
