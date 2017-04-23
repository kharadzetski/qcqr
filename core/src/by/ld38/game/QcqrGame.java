package by.ld38.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Main global game instance:
 *
 * Contains batch for rendering
 *
 * @author SharK729
 * @since 1.0
 */
public class QcqrGame {
    private static QcqrGame instance = new QcqrGame();
    public static QcqrGame getInstance() {
        return instance;
    }

    public Long tick = 0L;
    public SpriteBatch batch;
    public OrthographicCamera camera;

    public void initialize() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
    }
}
