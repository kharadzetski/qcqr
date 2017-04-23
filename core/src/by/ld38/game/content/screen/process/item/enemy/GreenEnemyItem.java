package by.ld38.game.content.screen.process.item.enemy;

import by.ld38.game.content.asset.AnimationContent;
import com.artemis.World;

public class GreenEnemyItem extends CarEnemyItem {
    @Override
    protected void defaultValues(World world) {
        animation.model = AnimationContent.CAR_ENEMY_GREEN.getModel();
    }
}
