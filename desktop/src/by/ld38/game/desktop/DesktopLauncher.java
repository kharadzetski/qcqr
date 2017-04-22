package by.ld38.game.desktop;

import by.ld38.game.QcqrGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * @author SharK729
 * @since 1.0
 */
public class DesktopLauncher {
    public static void main(String... arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new QcqrGame(), config);
    }
}
