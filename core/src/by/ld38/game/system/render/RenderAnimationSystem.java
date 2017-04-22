package by.ld38.game.system.render;

import by.ld38.game.QcqrGame;
import by.ld38.game.component.base.Position;
import by.ld38.game.component.render.Animation;
import by.ld38.game.component.render.RenderOrder;
import by.ld38.game.component.render.Scale;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
        super(Aspect.all(Animation.class, Position.class, RenderOrder.class, Scale.class));
    }

    protected ComponentMapper<Animation> mAnimation;
    protected ComponentMapper<Position> mPosition;
    protected ComponentMapper<RenderOrder> mRenderOrder;
    protected ComponentMapper<Scale> mScale;

    @Override
    protected void processSystem() {
        List<Integer> list = Arrays.stream( getEntityIds().getData() )
                .boxed()
                .distinct()
                .collect(Collectors.toList());
        list.sort( this::compareInt );
        list.forEach( this::process );
    }

    private Scale defaultScale = new Scale();

    protected void process(int entityId) {
        Animation ani = mAnimation.get(entityId);
        Position position = mPosition.get(entityId);
        Scale scale = mScale.getSafe(entityId, defaultScale);

        calc(ani);
        render(ani, position, scale);
    }

    private void calc(Animation animation) {
        animation.currentFrame += animation.model.getSpeed();
        if (animation.currentFrame >= animation.model.getSize()) animation.currentFrame = 0;
        animation.model.updateRegion(animation.region, (int) animation.currentFrame);
    }

    private void render(Animation animation, Position position, Scale scale) {
        TextureRegion region = animation.region;
        QcqrGame.getInstance().batch.draw(
                region,
                position.x,
                position.y,
                region.getRegionWidth() / 2,
                region.getRegionHeight() / 2,
                region.getRegionWidth(),
                region.getRegionHeight(),
                scale.x,
                scale.y,
                0
        );
    }

    private int compareInt(int a, int b) {
        int orderA = mRenderOrder.get(a).value;
        int orderB = mRenderOrder.get(b).value;
        return (int) Math.signum(orderA - orderB);
    }
}
