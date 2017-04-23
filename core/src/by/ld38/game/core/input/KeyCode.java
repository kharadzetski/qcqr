package by.ld38.game.core.input;

import java.util.HashMap;
import java.util.Map;

public enum KeyCode {

    // movement
    ARROW_UP(19),
    ARROW_DOWN(20),
    ARROW_LEFT(21),
    ARROW_RIGHT(22),
    // actions
    KEY_Z(54),
    KEY_X(52),
    KEY_C(31),
    KEY_SPACE(62);

    private Integer code;

    KeyCode(Integer code) {
        this.code = code;
    }

    private static final Map<Integer, KeyCode> CODES = new HashMap<>();

    static {
        for (KeyCode keyCode : values()) {
            CODES.put(keyCode.code, keyCode);
        }
    }

    public static KeyCode fromCode(int code) {
        return CODES.get(code);
    }

}
