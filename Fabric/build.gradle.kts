plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
    modApi(sharedLibs.neoforgedatapackextensions.fabric)
    include(sharedLibs.neoforgedatapackextensions.fabric)
    modImplementation(sharedLibs.fabricasm.fabric)
    include(sharedLibs.fabricasm.fabric)
}

multiloader {
    modFile {
        json {
            entrypoint(
                "mm:early_risers",
                "${project.group}.${project.name.lowercase()}.asm.IllagerInvasionFabricCore"
            )
        }
    }
}
