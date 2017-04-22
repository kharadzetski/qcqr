package by.ld38.game.content;

import by.ld38.game.model.AnimationModel;

/**
 * Content for animations
 *
 * @author SharK729
 * @since 1.0
 */
public enum AnimationContent {
    TEST(TextureContent.TEST, 45, 60, 0.2f, 1, 2, 3)
    ;
    private AnimationModel model;

    AnimationContent(TextureContent texture, int width, int height, float speed, Integer... frames) {
        this.model = new AnimationModel(texture.getTexture(), width, height, speed, frames);
    }

    public AnimationModel getModel() {
        return model;
    }
}
