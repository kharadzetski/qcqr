package by.ld38.game.content.screen.test.system;

import by.ld38.game.QcqrGame;
import by.ld38.game.content.screen.menu.MenuWorldScreen;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;

/**
 * Tech demo for changing current screen
 *
 * @author SharK729
 * @since 1.0
 */
public class TestChangeScreenSystem extends BaseEntitySystem {
    public TestChangeScreenSystem() {
        super(Aspect.all());
    }

    @Override
    protected void processSystem() {
        QcqrGame.getInstance().changeScreen(MenuWorldScreen.class);
    }
}
