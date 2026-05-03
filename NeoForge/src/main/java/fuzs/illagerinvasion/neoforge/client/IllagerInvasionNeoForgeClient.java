package fuzs.illagerinvasion.neoforge.client;

import fuzs.illagerinvasion.common.IllagerInvasion;
import fuzs.illagerinvasion.common.client.IllagerInvasionClient;
import fuzs.illagerinvasion.common.data.client.ModAtlasProvider;
import fuzs.illagerinvasion.common.data.client.ModLanguageProvider;
import fuzs.illagerinvasion.common.data.client.ModModelProvider;
import fuzs.illagerinvasion.common.data.client.ModParticleProvider;
import fuzs.illagerinvasion.neoforge.data.client.ModSoundProvider;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = IllagerInvasion.MOD_ID, dist = Dist.CLIENT)
public class IllagerInvasionNeoForgeClient {

    public IllagerInvasionNeoForgeClient() {
        ClientModConstructor.construct(IllagerInvasion.MOD_ID, IllagerInvasionClient::new);
        DataProviderHelper.registerDataProviders(IllagerInvasion.MOD_ID,
                ModLanguageProvider::new,
                ModModelProvider::new,
                ModParticleProvider::new,
                ModSoundProvider::new,
                ModAtlasProvider::new);
    }
}
