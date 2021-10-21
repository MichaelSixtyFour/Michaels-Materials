package io.github.michaelsixtyfour.materials;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class OreGenerator {

    public static ConfiguredFeature<?, ?> ORE_TIN_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Materials.TIN_ORE.getDefaultState(),
                    16)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(72)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(16); // Number of veins per chunk

    public static ConfiguredFeature<?, ?> ORE_LEAD_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Materials.LEAD_ORE.getDefaultState(),
                    12)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(16); // Number of veins per chunk


    public static ConfiguredFeature<?, ?> ORE_SILVER_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Materials.SILVER_ORE.getDefaultState(),
                    8)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(48)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(12); // Number of veins per chunk

    public static ConfiguredFeature<?, ?> ORE_PLATINUM_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Materials.PLATINUM_ORE.getDefaultState(),
                    8)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(32)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(8); // Number of veins per chunk

    public static ConfiguredFeature<?, ?> ORE_TITANIUM_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Materials.TITANIUM_ORE.getDefaultState(),
                    8)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(32)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(8); // Number of veins per chunk

    public static void oreInit() {
        RegistryKey<ConfiguredFeature<?, ?>> oreTinOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("materials", "ore_tin_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreTinOverworld.getValue(), ORE_TIN_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreTinOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> oreLeadOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("materials", "ore_lead_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreLeadOverworld.getValue(), ORE_LEAD_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreLeadOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> oreSilverOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("materials", "ore_silver_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSilverOverworld.getValue(), ORE_SILVER_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreSilverOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> orePlatinumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("materials", "ore_platinum_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, orePlatinumOverworld.getValue(), ORE_PLATINUM_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, orePlatinumOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> oreTitaniumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("materials", "ore_titanium_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreTitaniumOverworld.getValue(), ORE_TITANIUM_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreTitaniumOverworld);
    }
}
