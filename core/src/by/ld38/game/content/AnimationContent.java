package by.ld38.game.content;

import by.ld38.game.model.AnimationModel;

/**
 * Content for animations
 *
 * @author SharK729
 * @since 1.0
 */
public enum AnimationContent {
    TEST(TextureContent.TEST, 45, 60, 1, 2, 3)
    ;
    private AnimationModel model;

    AnimationContent(TextureContent texture, int width, int height, Integer... frames) {
        this.model = new AnimationModel(texture.getTexture(), width, height, frames);
    }

    public AnimationModel getModel() {
        return model;
    }
}
