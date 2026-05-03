package fuzs.illagerinvasion.fabric.client;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.client.IllagerInvasionClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class IllagerInvasionFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(IllagerInvasion.MOD_ID, IllagerInvasionClient::new);
    }
}
