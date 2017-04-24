package by.ld38.game.content.world;

import by.ld38.game.QcqrGame;
import by.ld38.game.content.assets.AnimationAssets;
import by.ld38.game.content.constant.QcqrConstants;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import by.ld38.game.core.system.render.AnimationRenderSystem;
import by.ld38.game.core.system.render.BlankScreenRenderSystem;
import by.ld38.game.sound.MusicFiles;
import by.ld38.game.sound.MusicPlayer;
import by.ld38.game.util.EntityHelper;
import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;

public class StartScreenCreator extends WorldCreator {
    public StartScreenCreator() {
        super(
                new BlankScreenRenderSystem(),
                new AnimationRenderSystem()
        );
    }

    public static World instance;

    public static World getInstance() {
        initInput();
        return instance;
    }

    private static void initInput() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            private Rectangle start = new Rectangle(580, 419, 706, 70);
            private Rectangle cred = new Rectangle(920, 515, 361, 70);
            private Rectangle exit = new Rectangle(1005, 611, 706, 70);
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (start.contains(screenX, screenY)) {
                    MusicPlayer.getInstance().startPlay(MusicFiles.DIGITAL_MK2, true);
                    QcqrGame.getInstance().world = new IntroScreenCreator().create();
                }
                if (cred.contains(screenX, screenY)) {
                    QcqrGame.getInstance().world = new CreditsScreenCreator().create();
                }
                if (exit.contains(screenX, screenY)) {
                    MusicPlayer.getInstance().stopPlayAndDispose();
                    System.exit(0);
                }
                return super.touchDown(screenX, screenY, pointer, button);
            }
        });
    }

    @Override
    protected void initialize(World world) {
        instance = world;
        int id = EntityHelper.createEntity(world, Animation.class, Position.class);
        world.getMapper(Animation.class).get(id).model = AnimationAssets.MAIN_MENU.getModel();
        world.getMapper(Position.class).get(id).x = -QcqrConstants.SCREEN_WIDTH/2;
        world.getMapper(Position.class).get(id).y = -QcqrConstants.SCREEN_HEIGHT/2;
        MusicPlayer.getInstance().startPlay(MusicFiles.SPELLBRAKER, true);
        // let 555 400 1261 485
        // cred 900 500 1261 568
        // exi 1000 580 1262 630
        initInput();
    }
}
