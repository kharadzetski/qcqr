package by.ld38.game.core.input;

import com.badlogic.gdx.InputAdapter;

public class KeyboardInputProcessor extends InputAdapter {

    @Override
    public boolean keyDown(int keycode) {
        KeyCode keyCode = KeyCode.fromCode(keycode);
        if (keyCode != null) {
            KeyCodesHolder.getInstance().addCode(keyCode);
            return true;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        KeyCode keyCode = KeyCode.fromCode(keycode);
        if (keyCode != null) {
            KeyCodesHolder.getInstance().removeCode(keyCode);
            return true;
        }
        return super.keyUp(keycode);
    }
}
