package net.amy.amythest.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        MobEntitiesSpawns.addSpawns();

    }
}
