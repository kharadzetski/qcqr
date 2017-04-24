package by.ld38.game.util;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class DegreeUtil {
    public static float deg2rad(float degree) {
        return (float) (degree * Math.PI / 180);
    }

    public static float rad2dec(float degree) {
        return (float) (degree / Math.PI * 180);
    }

    public static final float round = deg2rad(360);

    public static final boolean checkCoordinate(float a, float b, float range) {
        return ( Math.abs(a - b) <= range || Math.abs(Math.abs( deg2rad(180) - a-b)) <= range || Math.abs(Math.abs(a-b) - deg2rad(180)) <= range);

    }
}
