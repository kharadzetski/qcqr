package by.ld38.game.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public final class Rad2DecUtil {
    public static Vector3 Rad2Dec (Vector2 radPos , Float radius  )
    {
        if (radius == null)
            radius = 1f;

        Vector3 decPos = new Vector3();
        decPos.z = (float) (radius * ((float) Math.sin(radPos.y)) * Math.cos(radPos.x));
        decPos.x  = (float) (radius * ((float) Math.sin(radPos.y)) * Math.sin(radPos.x));
        decPos.y = (float) (radius* Math.cos(radPos.y));
        return decPos;
    }

}
