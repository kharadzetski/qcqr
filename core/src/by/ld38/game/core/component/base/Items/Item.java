package by.ld38.game.core.component.base.Items;

import com.artemis.World;

/**
 * Created by m_katlinski on 24.04.2017.
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