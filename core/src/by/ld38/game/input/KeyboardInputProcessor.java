package by.ld38.game.input;

import com.artemis.World;
import com.badlogic.gdx.InputAdapter;

public class KeyboardInputProcessor extends InputAdapter {
    private World world;
    public KeyboardInputProcessor(World world) {
        this.world = world;
    }

    @Override
    public boolean keyDown(int keycode) {
        KeyCode keyCode = KeyCode.fromCode(keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println(" key down " + KeyCode.fromCode(keycode));
        return super.keyUp(keycode);
    }
}
