package by.ld38.game.core.system.hud;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.energy.Energy;
import by.ld38.game.core.component.hud.HudSpeedArrow;
import by.ld38.game.core.component.hud.HudSpeedMeter;
import by.ld38.game.core.component.physics.MaxVelocity;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.util.EntityHelper;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import javafx.geometry.Pos;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class EnergyHudSystem extends BaseEntitySystem {
    private Integer meter = null;
    private Integer arrowId = null;
    private Energy energy;
    private MaxVelocity maxVelocity;

    public EnergyHudSystem() {
        super(Aspect.all(Energy.class));
    }

    @Override
    protected void processSystem() {


        if (meter == null) {
            meter = EntityHelper.findEntities(world, HudSpeedMeter.class).get(0);
            arrowId = EntityHelper.findEntities(world, HudSpeedArrow.class).get(0);
            int playerId = EntityHelper.findEntities(world, Player.class, Energy.class).get(0);
            energy = world.getMapper(Energy.class).get(playerId);
            maxVelocity = world.getMapper(MaxVelocity.class).get(playerId);
        }

        //setRandomValue();
        Position arrow = world.getMapper(Position.class).get(arrowId);
        float length = 20;
        arrow.angle = -energy.value;
        maxVelocity.max = 2+ energy.value/5;
        //rrow.x = -450 + (float) (Math.sin( (energy.value -180) * Math.PI / 180) * length);
        //arrow.y = 200 + (float) (Math.cos( (energy.value -180) * Math.PI / 180) * length);
    }

    private void setRandomValue() {
        if (Math.random() > 0.3f) return;
        energy.value = (int) (Math.random()* Energy.MAX_VALUE);
    }
}
