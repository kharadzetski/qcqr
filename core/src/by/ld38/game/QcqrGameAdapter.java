package by.ld38.game;

import by.ld38.game.screen.test.TestWorldScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Main basic class;
 *
 * @author SharK729
 * @since 1.0
 */
public class QcqrGameAdapter extends ApplicationAdapter {
    private QcqrGame game = QcqrGame.getInstance();

    @Override
    public void create() {
        game.initialize();
        game.registerScreen(new TestWorldScreen());
        game.changeScreen(TestWorldScreen.class);
        game.batch.setProjectionMatrix(game.camera.projection); // устанавливаем камеру в позицию по центру
        super.create();
    }

    @Override
    public void render() {
        game.tick++;
        game.batch.begin();
        game.currentScreen().render(Gdx.graphics.getDeltaTime());
        game.batch.end();
    }
}
