package by.ld38.game;

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
