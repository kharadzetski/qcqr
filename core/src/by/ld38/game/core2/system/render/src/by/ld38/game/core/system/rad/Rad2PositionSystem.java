package by.ld38.game.core2.system.render.src.by.ld38.game.core.system.rad;

import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.base.Position;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.player.Player;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.rad.RadDirection;
import by.ld38.game.core2.system.render.src.by.ld38.game.core.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.EntitySubscription;
import com.artemis.systems.IteratingSystem;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

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
        //cameraControl();
        userCamera();

        Position p = world.getMapper(Position.class).get(entityId);
        RadPosition rp = world.getMapper(RadPosition.class).get(entityId);

        float alpha = rp.alpha; // + camera.alpha;
        float beta = rp.beta;
        float gamma = rp.gamma;
        float radius = rp.radius;


        p.x = (float) (sin(alpha)*cos(beta)*cos(gamma) + sin(beta)*sin(gamma))*radius;
        p.y = (float) (sin(beta)*cos(gamma) + sin(alpha)*cos(beta)*sin(gamma))*radius;
        p.z = (float) (cos(alpha)*cos(beta))*radius;

        float tmpX = p.x;
        p.x = (float) (p.x*cos(camera.alpha) - p.z*sin(camera.alpha));
        //p.y = (p.y)
        p.z = (float) (p.z*cos(camera.alpha) + tmpX*sin(camera.alpha));

        float tmpY = p.y;
        // p.x = p.x
        p.y = (float) ( p.y * cos(camera.beta) + p.z * sin(camera.beta) );
        p.z = (float) ( tmpY * sin(camera.beta) - p.z * cos(camera.beta) );

        float tmpx = p.x;
        p.x = (float) ( p.x * cos(camera.gamma) - p.y * sin(camera.gamma) );
        p.y = (float) ( p.y * cos(camera.gamma) + tmpx * sin(camera.gamma) );
        //p.z = p.z

        p.scale =(p.z + rp.radius) / (2*rp.radius) + 0.2f;

        ComponentMapper<RadDirection> rdm = world.getMapper(RadDirection.class);
        if (rdm.has(entityId)) {
            p.angle = (float) (360 *180/Math.PI ) - rdm.get(entityId).angle;
        }
    }

    private void cameraControl() {
        float coef = .0005f;
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) camera.alpha += coef;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.alpha -= coef;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.beta += coef;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.beta -= coef;
        if (Gdx.input.isKeyPressed(Input.Keys.E)) camera.gamma += coef;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.gamma -= coef;
    }

    private void userCamera() {
        EntitySubscription subscription = world.getAspectSubscriptionManager().get(Aspect.all(Player.class));
        IntBag PlayerEntityId = subscription.getEntities();
        RadPosition pl =  world.getMapper(RadPosition.class).get(PlayerEntityId.get(0));

        camera.alpha =  pl.alpha;
        camera.beta = (float) (180 * Math.PI / 180) - pl.beta ;//- 0.5f;
        camera.gamma = pl.gamma;
    }

}
