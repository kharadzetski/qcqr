package by.ld38.game.content.screen.process.system.rad;

import by.ld38.game.content.screen.common.component.render.RenderOrder;
import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.content.screen.common.component.render.Scale;
import by.ld38.game.utils.Rad2DecUtil;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector3;

public class RadToScaleSystem extends IteratingSystem {

    private ComponentMapper<Scale> sm;
    private ComponentMapper<RadPosition> rpm;
    private ComponentMapper<RenderOrder> rom;

    /**
     * Creates a new EntityProcessingSystem.
     */
    public RadToScaleSystem() {
        super(Aspect.all(Scale.class, RadPosition.class));
    }

    @Override
    protected void process(int entityId) {
        RadPosition rp = rpm.get(entityId);
        RenderOrder ro = rom.get(entityId);

        Vector3 dec = Rad2DecUtil.rad2Dec(rpm.get(entityId).asVector3());
        Scale scale = sm.get(entityId);
        ro.value = (int) dec.z;
        float coef = (dec.z + rp.radZ + 60) / (2*rp.radZ);

        scale.x = coef;
        scale.y = coef;
    }
}
