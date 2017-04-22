package by.ld38.game.utils;

import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public abstract class Item {
    public int create(World world) {
        int id = world.create();
        select(world, id);
        return id;
    }

    public abstract void create(World world, int id);
    public abstract void select(World world, int id);
}
