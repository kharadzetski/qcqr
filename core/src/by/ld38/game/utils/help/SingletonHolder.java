package by.ld38.game.utils.help;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SharK729
 * @since 1.0
 */
public class SingletonHolder {
    private Map<Class, Object> map = new HashMap<>();


    public static SingletonHolder instance = new SingletonHolder();
    public static SingletonHolder getInstance() { return instance; }

    public static <T>  T get(Class<T> clz) {
        return (T) instance.map.get(clz);
    }
    public static void register(Object item) {
        instance.map.put(item.getClass(), item);
    }
}
