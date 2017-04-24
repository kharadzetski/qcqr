package by.ld38.game.core2.system.render.src.by.ld38.game.core.system.render;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class BlankScreenRenderSystem extends BaseSystem {
    @Override
    protected void processSystem() {
        Gdx.gl.glClearColor(.1f, .1f, .1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
