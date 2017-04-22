package by.ld38.game.system.render;

import by.ld38.game.QcqrGame;
import by.ld38.game.component.base.Position;
import by.ld38.game.component.render.Animation;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;

/**
 * TAnima
 *
 * @author SharK729
 * @since 1.0
 */
public class RenderAnimationSystem extends IteratingSystem {
    public RenderAnimationSystem() {
        super(Aspect.all(Animation.class, Position.class));
    }

    protected ComponentMapper<Animation> mAnimation;
    protected ComponentMapper<Position> mPosition;

    @Override
    protected void process(int entityId) {
        Animation ani = mAnimation.get(entityId);
        Position position = mPosition.get(entityId);

        calc(ani);
        render(ani, position);
    }

    private void calc(Animation animation) {
        animation.currentFrame += animation.model.getSpeed();
        if (animation.currentFrame >= animation.model.getSize()) animation.currentFrame = 0;
        animation.model.updateRegion(animation.region, (int) animation.currentFrame);
    }

    private void render(Animation animation, Position position) {
        QcqrGame.getInstance().batch.draw(animation.region, position.getRadX(), position.getRadY());
    }
}
