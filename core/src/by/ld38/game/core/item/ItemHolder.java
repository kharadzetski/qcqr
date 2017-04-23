package by.ld38.game.core.item;

import com.artemis.World;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SharK729
 * @since 1.0
 */
public class ItemHolder {
    private Map<Class, Object> map = new HashMap<>();

    public static ItemHolder instance = new ItemHolder();
    public static ItemHolder getInstance() { return instance; }

    public static <T extends Item> T get(World world, Class<T> clz) {
        T item = (T) instance.map.get(clz);
        if (item == null) {
            try {
                item = clz.newInstance();
                instance.map.put(clz, item);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return item;
    }

    public static <T extends Item> T get(World world, int id, Class<T> clz) {
        T item = get(world, clz);
        item.select(world, id);
        return item;
    }

    public static <T extends Item> T create(World world, Class<T> clz) {
        T item = get(world, clz);
        item.create(world);
        return item;
    }
}
