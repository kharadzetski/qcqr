package by.ld38.game.content.assets;

import com.badlogic.gdx.graphics.Texture;

/**
 * Content of textures
 *
 * @author SharK729
 * @since 1.0
 */
public enum TextureAssets {
    TEST("test/test.png"),
    CAR_HERO("test/Car_Hero_90x60.png"),
    CAR_ENEMY_GREEN("sprites/cars/enemy_green_45x59.png"),
    CAR_ENEMY_BLUE("sprites/cars/enemy_blue_45x59.png"),
    CAR_ENEMY_VIOLET("sprites/cars/enemy_violet_45x58.png")

    ;
    private Texture texture;

    TextureAssets(String filePath) {
        this.texture = new Texture(filePath);
    }

    public Texture getTexture() {
        return texture;
    }
}
