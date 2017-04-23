package by.ld38.game.core.input;

import java.util.HashSet;
import java.util.Set;

public class KeyCodesHolder {
    private static KeyCodesHolder ourInstance = new KeyCodesHolder();

    public static KeyCodesHolder getInstance() {
        return ourInstance;
    }

    private KeyCodesHolder() {
    }

    private Set<KeyCode> codes = new HashSet<>();

    void addCode(KeyCode code) {
        codes.add(code);
    }

    void removeCode(KeyCode code) {
        codes.remove(code);
    }

    public boolean hasCode(KeyCode code) {
        return codes.contains(code);
    }
}
