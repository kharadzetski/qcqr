package by.ld38.game.content.screen.common.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;
import java.util.List;

/**
 * Model for keeping animation frames
 *
 * @author SharK729
 * @since 1.0
 */
public class AnimationModel {
    private Texture texture;
    private int frameWidth;
    private int frameHeight;
    private int sizeInLine;
    private float speed = 1f;
    private List<Integer> frameList;

    public AnimationModel(Texture texture, int frameWidth, int frameHeight, float speed, Integer... frames) {
        this(texture, frameWidth, frameHeight, speed, Arrays.asList(frames));
    }

    public AnimationModel(Texture texture, int frameWidth, int frameHeight, Integer... frames) {
        this(texture, frameWidth, frameHeight, 1f, Arrays.asList(frames));
    }

    public AnimationModel(Texture texture, int frameWidth, int frameHeight, float speed, List<Integer> frameList) {
        this.texture = texture;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.frameList = frameList;
        this.speed = speed;
        sizeInLine = texture.getWidth() / frameWidth;
    }

    public void updateRegion(TextureRegion region, int frameId) {
        int line = frameId / sizeInLine;
        int inLine = frameId - ( sizeInLine * line );
        region.setTexture(texture);
        region.setRegion(frameWidth * inLine, frameHeight * line, frameWidth, frameHeight);

    }

    public int getSize() {
        return frameList.size();
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public float getSpeed() {
        return speed;
    }
}
