package by.ld38.game.core.system.rad;

import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import static java.lang.Math.*;

/**
 * @author SharK729
 * @since 1.0
 */
public class Rad2PositionSystem extends IteratingSystem {
    public Rad2PositionSystem() {
        super(Aspect.all(Position.class, RadPosition.class));
    }

    private RadPosition camera = new RadPosition(); // TODO implement with correct cam

    @Override
    protected void process(int entityId) {
        cameraControl();
        Position p = world.getMapper(Position.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        float alpha = rp.alpha + camera.alpha;
        float beta = rp.beta;//(float) ( rp.beta * cos(camera.beta) + rp.alpha * sin(camera.beta) );
        float radius = rp.radius;

        p.x = (float) ( sin(alpha) * cos(beta) ) * radius;
        p.y = (float) ( sin(beta) ) * radius;
        p.z = (float) ( cos(alpha) * cos(beta) ) * radius;

        float tmpY = p.y;
        p.y = (float) ( p.y * cos(camera.beta) + p.z * sin(camera.beta) );
        p.z = (float) ( tmpY * sin(camera.beta) - p.z * cos(camera.beta) );

        /*
        decV3.x,
            (float) ( decV3.y * Math.cos(planet.beta) + decV3.z * Math.sin(planet.beta) ),
            (float) ( decV3.y * Math.sin(planet.beta) - decV3.z * Math.cos(planet.beta) ));*/
    }

    private void cameraControl() {
        float coef = .0005f;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.beta += coef;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.beta -= coef;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.alpha -= coef;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.alpha += coef;
    }

}
