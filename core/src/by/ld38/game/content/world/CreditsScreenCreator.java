package by.ld38.game.content.world;

import by.ld38.game.QcqrGame;
import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.system.render.AnimationRenderSystem;
import by.ld38.game.core.system.render.BlankScreenRenderSystem;
import by.ld38.game.util.EntityHelper;
import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class CreditsScreenCreator extends WorldCreator {
    public CreditsScreenCreator() {
        super(
                new BlankScreenRenderSystem(),
                new AnimationRenderSystem()
        );
    }
    @Override
    protected void initialize(World world) {
        int id = EntityHelper.createEntity(world, Animation.class, Position.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.CREDITS_SCREEN.getModel();
        world.getMapper(Position.class).get(id).x = -QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(Position.class).get(id).y = -QcqrConstants.SCREEN_HEIGHT/2;
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (Input.Keys.ESCAPE == keycode) {
                    QcqrGame.getInstance().world = StartScreenCreator.getInstance();
                }
                return super.keyDown(keycode);
            }
        });
    }
}
