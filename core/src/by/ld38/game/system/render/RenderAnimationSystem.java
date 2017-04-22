package by.ld38.game.system.render;

import by.ld38.game.QcqrGame;
import by.ld38.game.component.base.Position;
import by.ld38.game.component.render.Animation;
import by.ld38.game.component.render.RenderOrder;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TAnima
 *
 * @author SharK729
 * @since 1.0
 */
public class RenderAnimationSystem extends BaseEntitySystem {
    public RenderAnimationSystem() {
        super(Aspect.all(Animation.class, Position.class, RenderOrder.class));
    }

    protected ComponentMapper<Animation> mAnimation;
    protected ComponentMapper<Position> mPosition;
    protected ComponentMapper<RenderOrder> mRenderOrder;

    @Override
    protected void processSystem() {
        List<Integer> list = Arrays.stream( getEntityIds().getData() )
                .boxed()
                .distinct()
                .collect(Collectors.toList());
        list.sort( this::compareInt );
        list.forEach( this::process );
    }

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
        QcqrGame.getInstance().batch.draw(animation.region, position.x, position.y);
    }

    private int compareInt(int a, int b) {
        int orderA = mRenderOrder.get(a).value;
        int orderB = mRenderOrder.get(b).value;
        return (int) Math.signum(orderA - orderB);
    }
}
