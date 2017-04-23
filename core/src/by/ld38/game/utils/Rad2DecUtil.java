package by.ld38.game.utils;

import com.badlogic.gdx.math.Vector3;

public final class Rad2DecUtil {
    public static Vector3 rad2Dec(Vector3 radPos) {
        Vector3 decPos = new Vector3();
        decPos.z = (float) (radPos.z * ((float) Math.sin(radPos.y)) * Math.cos(radPos.x));
        decPos.x  = (float) (radPos.z * ((float) Math.sin(radPos.y)) * Math.sin(radPos.x));
        decPos.y = (float) (radPos.z * Math.cos(radPos.y));
        return decPos;
    }


}
