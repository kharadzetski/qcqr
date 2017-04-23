package by.ld38.game.content.screen.process.system.car;

import by.ld38.game.content.screen.process.component.*;
import com.artemis.Aspect;
import com.artemis.systems.IteratingSystem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class CarCollisionSystem extends IteratingSystem {
    private Map<Integer, Collection<Integer>> mapBucket = new HashMap<>();

    public CarCollisionSystem() {
        super(Aspect.all(Car.class, Force.class, RadPosition.class, Collidable.class));
    }

    private float size = .1f;
    private float colCoef = .05f;

    @Override
    protected void process(int entityId) {
        //clearBuckets();
        //fillCollisionBucket(entityId);
        //mapBucket.values().forEach(this::collideBucket);
        Collection<Integer> ids = Arrays.stream(getEntityIds().getData())
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        isCollided(entityId, ids);
    }

    private void clearBuckets() {
        mapBucket.values().forEach(Collection::clear);
    }

    private void fillCollisionBucket(int entityId) {
        /*int hash = getHash(entityId);
        Collection<Integer> bucket = mapBucket.get(hash);
        if (bucket == null) {
            bucket = new HashSet<>();
            mapBucket.put(hash, bucket);
        }
        bucket.add(entityId);*/
    }

    private int getHash(int entityId) {
        RadPosition pos = world.getMapper(RadPosition.class).get(entityId);
        return ((int) (pos.radY * 1000)) * 1000 + ( (int) (pos.radX*1000) );
    }

    private void collideBucket(Collection<Integer> bucket) {
        bucket.forEach(id -> isCollided(id, bucket));
    }

    private void isCollided(Integer id, Collection<Integer> bucket) {

        RadPosition pos = world.getMapper(RadPosition.class).get(id);
        for (Integer otherId : bucket) {
            if (id.equals(otherId)) continue;
            RadPosition otherPos = world.getMapper(RadPosition.class).get(otherId);
            if ( Math.abs(pos.radX - otherPos.radX) +
                    Math.abs(pos.radY - otherPos.radY) < size) {
                collisionLogic(id, otherId);
            }
        }
    }

    private void collisionLogic(Integer aId, Integer bId) {
        if (world.getMapper(Player.class).has(aId)) {
            System.out.println("COLLISION");}
        RadPosition a = world.getMapper(RadPosition.class).get(aId);
        RadPosition b = world.getMapper(RadPosition.class).get(bId);
        Force af = world.getMapper(Force.class).get(aId);
        af.a += (a.radX - b.radX) * colCoef;
        af.b += (a.radY - b.radY) * colCoef;
    }
}
