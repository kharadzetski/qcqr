package by.ld38.game.content.asset;

import by.ld38.game.content.screen.common.model.AnimationModel;

/**
 * Content for animations
 *
 * @author SharK729
 * @since 1.0
 */
public enum AnimationContent {
    TEST(TextureContent.TEST, 45, 60, 0.2f, 1, 2, 3),
    CAR_HERO(TextureContent.CAR_HERO, 45, 60, 0.3f, 0, 1),
    CAR_ENEMY_GREEN(TextureContent.CAR_ENEMY_GREEN, 45, 59, 0.3f, 0, 1),
    CAR_ENEMY_BLUE(TextureContent.CAR_ENEMY_BLUE, 45, 59, 0.3f, 0, 1),
    CAR_ENEMY_VIOLET(TextureContent.CAR_ENEMY_VIOLET, 45, 59, 0.3f, 0, 1)

    ;
    private AnimationModel model;

    AnimationContent(TextureContent texture, int width, int height, float speed, Integer... frames) {
        this.model = new AnimationModel(texture.getTexture(), width, height, speed, frames);
    }

    public AnimationModel getModel() {
        return model;
    }
}
