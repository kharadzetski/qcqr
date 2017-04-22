package by.ld38.game.desktop;

import by.ld38.game.QcqrGameAdapter;
import by.ld38.game.constant.GameEnv;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * @author SharK729
 * @since 1.0
 */
public class DesktopLauncher {
    public static void main(String... arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = (int) GameEnv.SCREEN_WIDTH;
        config.height = (int) GameEnv.SCREEN_HEIGHT;
        config.title = GameEnv.GAME_TITLE;
        new LwjglApplication(new QcqrGameAdapter(), config);
    }
}
