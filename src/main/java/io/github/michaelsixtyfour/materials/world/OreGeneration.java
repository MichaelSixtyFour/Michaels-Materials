package io.github.michaelsixtyfour.materials.world;

import com.google.gson.JsonElement;
import io.github.michaelsixtyfour.materials.Materials;
import io.github.michaelsixtyfour.materials.init.Creator;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.util.TriConsumer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static io.github.michaelsixtyfour.materials.Materials.MOD_ID;

public class OreGeneration {

    public static void oreGenInit() {
        // Ore Generation
        List<DataDrivenFeature> features = OreGeneration.getDefaultFeatures();

        for (DataDrivenFeature feature : features) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryKey().getValue(), feature.getConfiguredFeature());
        }

        BiomeModifications.create(new Identifier(MOD_ID, "features")).add(ModificationPhase.ADDITIONS, BiomeSelectors.all(),
                (biomeSelectionContext, biomeModificationContext) -> {
                    for (DataDrivenFeature feature : features) {
                        if (feature.getBiomeSelector().test(biomeSelectionContext)) {
                            biomeModificationContext.getGenerationSettings().addFeature(feature.getGenerationStep(), feature.getRegistryKey());
                        }
                    }
                });
    }

    public static List<DataDrivenFeature> getDefaultFeatures() {
        List<DataDrivenFeature> features = new ArrayList<>();
        TriConsumer<Predicate<BiomeSelectionContext>, RuleTest, Creator.Ores> addOre = (worldTargetType, ruleTest, ore) ->
                features.add(ore.asNewOres(new Identifier(MOD_ID, Registry.BLOCK.getId(ore.block).getPath()), worldTargetType, ruleTest));

        addOre.accept(BiomeSelectors.foundInOverworld(), OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Creator.Ores.TIN);
        addOre.accept(BiomeSelectors.foundInOverworld(), OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Creator.Ores.LEAD);
        addOre.accept(BiomeSelectors.foundInOverworld(), OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Creator.Ores.SILVER);
        addOre.accept(BiomeSelectors.foundInOverworld(), OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Creator.Ores.PLATINUM);
        addOre.accept(BiomeSelectors.foundInOverworld(), OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Creator.Ores.TITANIUM);

        return features;
    }

    // Used to export the oregen jsons
    public static void export() {
        for (DataDrivenFeature defaultFeature : getDefaultFeatures()) {
            JsonElement jsonElement = defaultFeature.serialise();
            String json = jsonElement.toString();

            Path dir = Paths.get("..\\src\\main\\resources\\data\\materials\\materials\\features");
            try {
                Files.writeString(dir.resolve(defaultFeature.getIdentifier().getPath() + ".json"), json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
