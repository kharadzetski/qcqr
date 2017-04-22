package by.ld38.game.screen.test.system;

import by.ld38.game.component.base.RadPosition;
import by.ld38.game.component.base.Velocity;
import by.ld38.game.screen.common.TextItem;
import by.ld38.game.screen.common.components.Text;
import by.ld38.game.utils.ItemHolder;
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
        super(Aspect.all(RadPosition.class, Velocity.class));


    }

    @Override
    protected void begin() {
        if (debugText == null) debugText = ItemHolder.create(world, TextItem.class).text;
    }

    @Override
    protected void process(int entityId) {
        Velocity velocity = world.getMapper(Velocity.class).get(entityId);
        RadPosition radPosition = world.getMapper(RadPosition.class).get(entityId);
        debugText.value = "Rad.x = " + radPosition.radX + "\n" +
                "Rad.y = " + radPosition.radY + "\n" +
                "Rad.z = " + radPosition.radZ + "\n" +
                "Velocity.vx = " + velocity.radVX + "\n" +
                "Velocity.vy = " + velocity.radVY + "\n";
    }
}
