plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-common")
}

dependencies {
    modCompileOnlyApi(sharedLibs.puzzleslib.common)
    modCompileOnlyApi(sharedLibs.multiloaderdataextensions.common)
}

multiloader {
    mixins {
        mixin(
            "CarvedPumpkinBlockMixin",
            "IllusionerMixin",
            "PatrolSpawnerMixin",
            "TemplateStructurePieceMixin",
            "WoodlandMansionPieceMixin"
        )
    }
}
