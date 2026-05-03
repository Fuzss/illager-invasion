package fuzs.illagerinvasion.fabric;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.handler.VillagerGoalHandler;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class IllagerInvasionFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(IllagerInvasion.MOD_ID, IllagerInvasion::new);
        VillagerGoalHandler.registerAcceptableDistanceFromHostiles();
    }
}
