package by.ld38.game.content.screen.process.system.player;

import by.ld38.game.content.screen.common.component.base.Position;
import by.ld38.game.content.screen.process.component.Planet;
import by.ld38.game.core.input.KeyCodesHolder;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class KeyboardPlanetControlSystem extends IteratingSystem {
    public KeyboardPlanetControlSystem() {
        super(Aspect.all(Position.class, Planet.class));
    }

    private ComponentMapper<Planet> pm;

    private float coef = .005f;

    @Override
    protected void process(int entityId) {
        Planet planet = pm.get(entityId);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) planet.beta += coef;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) planet.beta -= coef;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) planet.alpha -= coef;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) planet.alpha += coef;
    }
}
