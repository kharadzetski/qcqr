package by.ld38.game.content.assets;


import by.ld38.game.content.model.AnimationModel;

/**
 * Content for animations
 *
 * @author SharK729
 * @since 1.0
 */
public enum AnimationAssets {
    TEST(TextureAssets.TEST, 45, 60, 0.2f, 1, 2, 3),
    CAR_HERO(TextureAssets.CAR_HERO, 45, 60, 0.3f, 0, 1),
    CAR_ENEMY_GREEN(TextureAssets.CAR_ENEMY_GREEN, 45, 59, 0.3f, 0, 1),
    CAR_ENEMY_BLUE(TextureAssets.CAR_ENEMY_BLUE, 45, 59, 0.3f, 0, 1),
    CAR_ENEMY_VIOLET(TextureAssets.CAR_ENEMY_VIOLET, 45, 59, 0.3f, 0, 1)

    ;
    private AnimationModel model;

    AnimationAssets(TextureAssets texture, int width, int height, float speed, Integer... frames) {
        this.model = new AnimationModel(texture.getTexture(), width, height, speed, frames);
    }

    public AnimationModel getModel() {
        return model;
    }
}
