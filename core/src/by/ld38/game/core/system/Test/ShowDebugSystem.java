package by.ld38.game.core.system.Test;


import by.ld38.game.core.component.base.Items.ItemHolder;
import by.ld38.game.core.component.base.Items.TextItem;
import by.ld38.game.core.component.base.Text;
import by.ld38.game.core.component.physics.Velocity;
import by.ld38.game.core.component.physics.WorldPosition;
import by.ld38.game.core.component.player.Player;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

    /**
     * TODO  plz, describe me
     *
     * @author SharK729
     * @since 1.0
     */
    public class ShowDebugSystem extends IteratingSystem {
        private Text debugText;

        public ShowDebugSystem() {
            super(Aspect.all(WorldPosition.class, Velocity.class, Player.class));


        }

        @Override
        protected void begin() {
            if (debugText == null) debugText = ItemHolder.create(world, TextItem.class).text;
        }

        @Override
        protected void process(int entityId) {
            Velocity velocity = world.getMapper(Velocity.class).get(entityId);
            WorldPosition worldPos = world.getMapper(WorldPosition.class).get(entityId);
            debugText.value = "World.x = " + worldPos.worldX + "\n" +
                    "World.y = " + worldPos.worldY + "\n" +
                    "World.z = " + worldPos.worldZ + "\n" +
                    "Velocity.vx = " + velocity.x + "\n" +
                    "Velocity.vy = " + velocity.y + "\n";
        }
    }
