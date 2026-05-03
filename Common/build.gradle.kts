plugins {
    id("fuzs.multiloader.multiloader-convention-plugins-common")
}

dependencies {
    modCompileOnlyApi(sharedLibs.puzzleslib.common)
    modCompileOnlyApi(sharedLibs.neoforgedatapackextensions.common)
}

multiloader {
    mixins {
        mixin("IllusionerMixin", "PatrolSpawnerMixin", "TemplateStructurePieceMixin", "WoodlandMansionPieceMixin")
    }
}
