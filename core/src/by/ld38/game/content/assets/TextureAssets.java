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
    CAR_ENEMY_VIOLET("sprites/cars/enemy_violet_45x58.png"),
    BACKGROUND_EARTH0 ("sprites/world/earth_1280x720.png"),
    BACKGROUND_EARTH1("sprites/world/Earth_texture1.png"),
    BACKGROUND_EARTH2("sprites/world/Earth_texture2.png"),
    BACKGROUND_EARTH3("sprites/world/Earth_texture3.png"),
    BACKGROUND_EARTH4("sprites/world/Earth_texture4.png"),
    BACKGROUND_EARTH5("sprites/world/Earth_texture5.png"),
    BACKGROUND_EARTH6("sprites/world/Earth_texture6.png"),
    BACKGROUND_EARTH7("sprites/world/Earth_texture7.png"),
    BACKGROUND_EARTH8("sprites/world/Earth_texture8.png"),
    BACKGROUND_EARTH9("sprites/world/Earth_texture9.png"),

    ENERGY_METER("sprites/hud/energy-meter.png"),
    ENERGY_ARROW("sprites/hud/arrow.png"),

    QUARKTUS("sprites/world/quarktus_sheet_70x70.png")
    ENERGY_ARROW("sprites/hud/arrow.png"),
    PlanetOffset ("sprites/world/space_texture.png")
    ;
    private Texture texture;

    TextureAssets(String filePath) {
        this.texture = new Texture(filePath);
    }

    public Texture getTexture() {
        return texture;
    }
}
