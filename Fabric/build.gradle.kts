plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-fabric")
}

dependencies {
    modApi(sharedLibs.fabricapi.fabric)
    modApi(sharedLibs.puzzleslib.fabric)
    modApi(sharedLibs.multiloaderdataextensions.fabric)
    include(sharedLibs.multiloaderdataextensions.fabric)
}
