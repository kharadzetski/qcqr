package by.ld38.game.content.assets;

import by.ld38.game.content.model.AnimationModel;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public enum SpeedHudAssets {
    SPEED_METER(TextureAssets.ENERGY_METER, 208, 153, 0f, 0),
    SPEED_ARROW(TextureAssets.ENERGY_ARROW, 148, 148, 0f, 0 )
    ;
    private AnimationModel model;

    SpeedHudAssets(TextureAssets texture, int width, int height, float speed, Integer... frames) {
        this.model = new AnimationModel(texture.getTexture(), width, height, speed, frames);
    }

    public AnimationModel getModel() {
        return model;
    }
}
