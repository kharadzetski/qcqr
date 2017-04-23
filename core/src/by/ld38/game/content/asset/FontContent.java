package by.ld38.game.content.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author SharK729
 * @since 1.0
 */
public enum FontContent {
    BASIC("fonts/normal.fnt", "fonts/normal_0.png");

    private BitmapFont font;

    FontContent(String fontPath, String imagePath) {
        Texture fontTexture = new Texture(Gdx.files.internal(imagePath));
        TextureRegion fontRegion = new TextureRegion(fontTexture);
        font = new BitmapFont(Gdx.files.internal(fontPath), Gdx.files.internal(imagePath), false);
        font.setUseIntegerPositions(false);
    }

    public BitmapFont getFont() {
        return font;
    }

}
