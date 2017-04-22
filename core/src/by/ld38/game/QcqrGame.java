package by.ld38.game;

import by.ld38.game.constant.GameEnv;
import by.ld38.game.screen.WorldScreen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

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

    private Map<String, WorldScreen> screenMap = new HashMap<>();
    private WorldScreen screen;
    public Long tick = 0L;
    public SpriteBatch batch;
    public OrthographicCamera camera;

    public void initialize() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameEnv.SCREEN_WIDTH, GameEnv.SCREEN_HEIGHT);
    }

    public void changeScreen(Class<? extends WorldScreen> clsScreen) {
        screen = screenMap.get(clsScreen.getSimpleName());
    }
    public void registerScreen(WorldScreen screen) {
        screenMap.put(screen.getClass().getSimpleName(), screen);
    }
    public WorldScreen currentScreen() {
        return screen;
    }

}
