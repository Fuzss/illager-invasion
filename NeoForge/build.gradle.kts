plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modApi(sharedLibs.puzzleslib.neoforge)
    modApi(sharedLibs.multiloaderdataextensions.neoforge)
    include(sharedLibs.multiloaderdataextensions.neoforge)
}

multiloader {
    modFile {
        enumExtensions.set("META-INF/enumextensions.json")
    }
}
