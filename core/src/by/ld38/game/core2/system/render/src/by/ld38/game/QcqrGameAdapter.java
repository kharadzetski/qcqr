package by.ld38.game.core2.system.render.src.by.ld38.game;

import com.badlogic.gdx.ApplicationAdapter;

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
        //game.batch.setProjectionMatrix(game.camera.projection); // устанавливаем камеру в позицию по центру
        super.create();
    }

    @Override
    public void render() {
        game.tick++;
        game.batch.begin();
        game.world.process();
        game.batch.end();
    }
}
