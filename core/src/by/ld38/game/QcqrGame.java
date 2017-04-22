package by.ld38.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Main basic class;
 *
 * @author SharK729
 * @since 1.0
 */
public class QcqrGame extends ApplicationAdapter {
    @Override
    public void create() {
        super.create();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
