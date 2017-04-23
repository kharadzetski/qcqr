package by.ld38.game.core.system.render;

import by.ld38.game.QcqrGame;
import by.ld38.game.content.model.AnimationModel;
import by.ld38.game.core.component.base.Animation;
import by.ld38.game.core.component.base.Position;
import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SharK729
 * @since 1.0
 */
public class AnimationRenderSystem extends BaseEntitySystem {
    public AnimationRenderSystem() {
        super(Aspect.all(Animation.class, Position.class));
    }

    @Override
    protected void processSystem() {
        List<Integer> list = Arrays.stream(getEntityIds().getData())
                .boxed()
                .distinct()
                .collect(Collectors.toList());
        list.sort(this::compareInt);
        list.forEach( this::process );
    }


    protected void process(int entityId) {
        Animation animation = world.getMapper(Animation.class).get(entityId);
        Position position = world.getMapper(Position.class).get(entityId);

        AnimationModel model = animation.model;
        model.updateRegion(animation.region, (int) animation.current);
        animation.current += model.getSpeed();
        if (animation.current > model.getSize()) animation.current = 0;

        QcqrGame.getInstance().batch.draw(animation.region, position.x, position.y);
    }

    private int compareInt(int a, int b) {
        float aZ = world.getMapper(Position.class).get(a).z;
        float bZ = world.getMapper(Position.class).get(b).z;
        return (int) Math.signum(aZ - bZ);
    }
}
