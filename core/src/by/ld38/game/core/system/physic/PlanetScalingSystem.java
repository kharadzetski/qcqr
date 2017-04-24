package by.ld38.game.core.system.physic;

import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.car.PlanetScale;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by m_katlinski on 24.04.2017.
 */
public class PlanetScalingSystem extends IteratingSystem {

   public PlanetScalingSystem(){ super(Aspect.all(Position.class, PlanetScale.class));}

    @Override
    protected void process(int entityId) {
        PlanetScale ps = world.getMapper(PlanetScale.class).get(entityId);
        Position pos = world.getMapper(Position.class).get(entityId);
        if(!ps.IsPlanetScale)
            return;
        float dist = Vector2.dst(pos.x,pos.y,0,0);
        if(dist > QcqrConstants.PlanetRadius+45)
            pos.scale = 0;
        else if (dist < QcqrConstants.PlanetRadius/4)
            pos.scale = 1;
        else
            pos.scale  = 1 -(((dist -QcqrConstants.PlanetRadius/4 )*(QcqrConstants.MaxScale- QcqrConstants.MinScale)/(QcqrConstants.PlanetRadius - QcqrConstants.PlanetRadius/4)));

    }
}
