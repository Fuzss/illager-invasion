plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-neoforge")
}

dependencies {
    modCompileOnly(sharedLibs.puzzleslib.common)
    modApi(sharedLibs.puzzleslib.neoforge)
    modCompileOnly(sharedLibs.neoforgedatapackextensions.common)
    modApi(sharedLibs.neoforgedatapackextensions.neoforge)
    include(sharedLibs.neoforgedatapackextensions.neoforge)
}

multiloader {
    modFile {
        enumExtensions.set("META-INF/enumextensions.json")
    }
}
