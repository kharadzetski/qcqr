package by.ld38.game.core.item;

import com.artemis.World;

/**
 * @author SharK729
 * @since 1.0
 */
public abstract class Item {
    public int create(World world) {
        int id = world.create();
        create(world, id);
        select(world, id);
        defaultValues(world);
        return id;
    }
    public abstract void create(World world, int id);
    public abstract void select(World world, int id);
    protected void defaultValues(World world) {}
}
