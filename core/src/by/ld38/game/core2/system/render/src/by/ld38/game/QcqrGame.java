package by.ld38.game.core2.system.render.src.by.ld38.game;

import by.ld38.game.core2.system.render.src.by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core2.system.render.src.by.ld38.game.content.world.ProcessWorldCreator;
import com.artemis.World;
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
    public World world;

    public void initialize() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, QcqrConstants.SCREEN_WIDTH, QcqrConstants.SCREEN_HEIGHT);
        camera.position.set(0, 0, 0);// set to zero
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        world = new ProcessWorldCreator().create();
    }
}
