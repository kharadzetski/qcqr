package by.ld38.game.core.system.intro;

import by.ld38.game.QcqrGame;
import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.world.ProcessWorldCreator;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.intro.IntroText;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputIntroSystem extends IteratingSystem {
    ComponentMapper<Animation> am;
    /**
     * Creates an entity system that uses the specified aspect as a matcher
     * against entities.
     */
    public InputIntroSystem() {
        super(Aspect.all(Animation.class, IntroText.class));
    }
    private int keyPressedCounter = 0;

    @Override
    protected void process(int entityId) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (keyPressedCounter == 0) {
                Animation animation = am.get(entityId);
                animation.model = AnimationAssets.INTRO_TEXT_2.getModel();
            }
            if (keyPressedCounter == 1) {
                QcqrGame.getInstance().world = new ProcessWorldCreator().create();
            }
            keyPressedCounter++;
        }
    }

}
