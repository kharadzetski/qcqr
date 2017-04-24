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
    CAR_HERO_TURBO (TextureAssets.CAR_HERO_TURBO, 45, 75, 0.3f, 0,1,2,3,4),
    CAR_ENEMY_GREEN(TextureAssets.CAR_ENEMY_GREEN, 45, 59, 0.3f, 0, 1),
    CAR_ENEMY_BLUE(TextureAssets.CAR_ENEMY_BLUE, 45, 59, 0.3f, 0, 1),
    CAR_ENEMY_VIOLET(TextureAssets.CAR_ENEMY_VIOLET, 45, 58, 0.3f, 0, 1),
    MAIN_MENU(TextureAssets.MAIN_MENU, 1280, 720, 0f),
    BACKGROUND_EARTH0(TextureAssets.BACKGROUND_EARTH0, 1080, 1080, 0f, 0),
    BACKGROUND_EARTH1(TextureAssets.BACKGROUND_EARTH1, 1280, 720, 0f, 0),
    BACKGROUND_EARTH2(TextureAssets.BACKGROUND_EARTH2, 1280, 720, 0f, 0),
    BACKGROUND_EARTH3(TextureAssets.BACKGROUND_EARTH3, 1280, 720, 0f, 0),
    BACKGROUND_EARTH4(TextureAssets.BACKGROUND_EARTH4, 1280, 720, 0f, 0),
    BACKGROUND_EARTH5(TextureAssets.BACKGROUND_EARTH5, 1280, 720, 0f, 0),
    BACKGROUND_EARTH6(TextureAssets.BACKGROUND_EARTH6, 1280, 720, 0f, 0),
    BACKGROUND_EARTH7(TextureAssets.BACKGROUND_EARTH7, 1280, 720, 0f, 0),
    BACKGROUND_EARTH8(TextureAssets.BACKGROUND_EARTH8, 1280, 720, 0f, 0),
    BACKGROUND_EARTH9(TextureAssets.BACKGROUND_EARTH9, 1280, 720, 0f, 0),
    PLANET_OFFSET( TextureAssets.PLANET_OFFSET, 1280, 720, 0.3f, 0, 1, 2, 3, 4, 5,6 ,7 ,8),

    QUARKTUS(TextureAssets.QUARKTUS, 70, 70, 0.2f, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
    CREDITS_SCREEN(TextureAssets.CREDITS_SCREEN, 1280, 720, 0f),
    INTRO_TEXT_1(TextureAssets.INTRO_TEXT_1, 1280, 720, 0f),
    INTRO_TEXT_2(TextureAssets.INTRO_TEXT_2, 1280, 720, 0f),
    INTRO_BG(TextureAssets.INTRO_BG, 1280, 720, 0f),
    INTRO_FLAME(TextureAssets.INTRO_FLAME, 1280, 178, .2f, 0,1,2,3,4,5,6,7,8,9,10,11),
    INTRO_ROCKS(TextureAssets.INTRO_ROCKS, 1280, 720, .2f, 0,1,2,3,4,5,6,7,8,9,10,11),
    INTRO_TIRES(TextureAssets.INTRO_TIRES, 83, 317, 0f)
    ;
    private AnimationModel model;

    AnimationAssets(TextureAssets texture, int width, int height, float speed, Integer... frames) {
        this.model = new AnimationModel(texture.getTexture(), width, height, speed, frames);
    }

    public AnimationModel getModel() {
        return model;
    }
}
