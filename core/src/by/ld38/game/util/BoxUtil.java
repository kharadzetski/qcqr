package by.ld38.game.util;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class BoxUtil {
    public static boolean checkCollision(float x1, float y1, float w1, float h1,
                                         float x2, float y2, float w2, float h2) {
        float hw1 = w1/2;
        float hh1 = h1/2;
        float xc1 = x1 + hw1;
        float yc1 = y1 + hh1;

        float hw2 = w2/2;
        float hh2 = h2/2;
        float xc2 = x2 + w2/2;
        float yc2 = y2 + h2/2;

        return Math.abs(xc2 - xc1) > (hw1 + hw2) && Math.abs(yc2 - yc1) > (hh1 + hh2);
    }
}
