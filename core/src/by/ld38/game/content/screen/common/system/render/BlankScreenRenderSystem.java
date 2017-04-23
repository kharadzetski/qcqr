package by.ld38.game.content.screen.common.system.render;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Blanks screen renderer
 *
 * @author SharK729
 * @since 1.0
 */
public class BlankScreenRenderSystem extends BaseEntitySystem {
    public BlankScreenRenderSystem() {
        super(Aspect.all());
    }

    @Override
    protected void processSystem() {
        Gdx.gl.glClearColor(.1f, .1f, .1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
