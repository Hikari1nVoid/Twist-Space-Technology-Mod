package com.Nxer.TwistSpaceTechnology.recipe.specialRecipe;

import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.EncapsulatedMicroSpaceTimeUnit;
import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.EnergyFluctuationSelfHarmonizer;
import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.InformationHorizonInterventionShell;
import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.PacketInformationTranslationArray;
import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.ParticleTrapTimeSpaceShield;
import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.SeedsSpaceTime;
import static com.Nxer.TwistSpaceTechnology.common.GTCMItemList.SpaceTimeSuperconductingInlaidMotherboard;
import static com.Nxer.TwistSpaceTechnology.util.Utils.setStackSize;
import static com.Nxer.TwistSpaceTechnology.util.enums.TierEU.RECIPE_UEV;
import static com.Nxer.TwistSpaceTechnology.util.enums.TierEU.RECIPE_UIV;
import static com.Nxer.TwistSpaceTechnology.util.enums.TierEU.RECIPE_UMV;
import static com.dreammaster.gthandler.GT_CoreModSupport.RadoxPolymer;
import static gregtech.api.enums.ItemList.Circuit_CosmicAssembly;
import static gregtech.api.enums.ItemList.Circuit_CosmicComputer;
import static gregtech.api.enums.ItemList.Circuit_CosmicProcessor;
import static gregtech.api.util.GT_RecipeBuilder.HOURS;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_TIME;
import static gtPlusPlus.core.material.ELEMENT.STANDALONE.CELESTIAL_TUNGSTEN;
import static gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList.Laser_Lens_Special;

import net.minecraft.item.ItemStack;

import com.Nxer.TwistSpaceTechnology.common.GTCMItemList;
import com.Nxer.TwistSpaceTechnology.common.recipeMap.GTCMRecipe;
import com.Nxer.TwistSpaceTechnology.recipe.IRecipePool;
import com.Nxer.TwistSpaceTechnology.util.recipes.TST_RecipeBuilder;
import com.dreammaster.gthandler.CustomItemList;
import com.github.bartimaeusnek.bartworks.API.recipe.BartWorksRecipeMaps;

import appeng.items.materials.MaterialType;
import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import goodgenerator.items.MyMaterial;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeConstants;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.core.material.ELEMENT;
import gtPlusPlus.core.material.MISC_MATERIALS;
import gtPlusPlus.core.util.minecraft.ItemUtils;

public class CosmicProcessorCircuitRecipePool implements IRecipePool {

    @Override
    public void loadRecipes() {

        final ItemStack eternal_singularity = GT_ModHandler.getModItem("eternalsingularity", "eternal_singularity", 1);

        // Silicon Neutron to UHV circuits
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Board_Wetware_Extreme.get(1),
                GTCMItemList.SiliconBasedNeuron.get(1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUEVBase, 2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 1))
            .noOptimize()
            .eut(RECIPE_UMV)
            .duration(20 * 5)
            .addTo(RecipeMaps.formingPressRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Board_Wetware_Extreme.get(1),
                GTCMItemList.SiliconBasedNeuron.get(1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUIVBase, 1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 2))
            .noOptimize()
            .eut(RECIPE_UMV)
            .duration(20 * 5)
            .addTo(RecipeMaps.formingPressRecipes);

        // SpaceTimeSuperconductingInlaidMotherboard
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_Utility.getNaniteAsCatalyst(Materials.Gold),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.InfinityCatalyst, 22),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUIVBase, 22))
            .fluidInputs(MaterialsUEVplus.SpaceTime.getMolten(334))
            .itemOutputs(SpaceTimeSuperconductingInlaidMotherboard.get(16))
            .noOptimize()
            .eut(RECIPE_UEV)
            .duration(20 * 22)
            .addTo(RecipeMaps.pcbFactoryRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_Utility.getNaniteAsCatalyst(Materials.Gold),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 1),
                MyMaterial.shirabon.get(OrePrefixes.foil, 22),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUMVBase, 22))
            .fluidInputs(MaterialsUEVplus.SpaceTime.getMolten(667))
            .itemOutputs(SpaceTimeSuperconductingInlaidMotherboard.get(64))
            .noOptimize()
            .eut(RECIPE_UEV)
            .duration(20 * 22)
            .addTo(RecipeMaps.pcbFactoryRecipes);

        // Silicon-based Neuron
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                setStackSize(ItemList.Field_Generator_UIV.get(1), 0),
                Materials.Infinity.getDust(1),
                ItemList.Circuit_Chip_Optical.get(1))
            .fluidInputs(
                Materials.SiliconSG.getMolten(144 * 256),
                Materials.UUMatter.getFluid(1000 * 8),
                MaterialsUEVplus.Space.getMolten(100))
            .itemOutputs(
                GTCMItemList.SiliconBasedNeuron.get(4),
                GTCMItemList.SiliconBasedNeuron.get(4),
                GTCMItemList.SiliconBasedNeuron.get(4))
            .outputChances(10000, 8000, 2000)
            .specialValue(2)
            .eut(RECIPE_UMV)
            .duration(20 * 30)
            .addTo(GTCMRecipe.CrystallineInfinitierRecipes);

        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                setStackSize(ItemList.Field_Generator_UIV.get(1), 0),
                MaterialsUEVplus.Eternity.getDust(1),
                ItemList.Circuit_Chip_Optical.get(1))
            .fluidInputs(
                Materials.SiliconSG.getMolten(144 * 256),
                Materials.UUMatter.getFluid(1000 * 8),
                MaterialsUEVplus.Space.getMolten(16000))
            .itemOutputs(
                GTCMItemList.SiliconBasedNeuron.get(64),
                GTCMItemList.SiliconBasedNeuron.get(64),
                GTCMItemList.SiliconBasedNeuron.get(64))
            .outputChances(10000, 8000, 2000)
            .specialValue(11)
            .eut(RECIPE_UMV)
            .duration(20 * 30)
            .addTo(GTCMRecipe.CrystallineInfinitierRecipes);

        // PacketInformationTranslationArray
        GT_Values.RA.stdBuilder()
            .itemInputs(
                SpaceTimeSuperconductingInlaidMotherboard.get(1),
                GTCMItemList.SiliconBasedNeuron.get(1),
                MyMaterial.enrichedNaquadahAlloy.get(OrePrefixes.plate, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUEVBase, 16))
            .fluidInputs(Materials.UUMatter.getFluid(250), MaterialsUEVplus.TranscendentMetal.getMolten(72))
            .itemOutputs(GTCMItemList.PacketInformationTranslationArray.get(2))
            .specialValue(3)
            .eut(RECIPE_UIV)
            .duration(20 * 5)
            .addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                SpaceTimeSuperconductingInlaidMotherboard.get(1),
                GTCMItemList.SiliconBasedNeuron.get(2),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.SpaceTime, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUIVBase, 16))
            .fluidInputs(Materials.UUMatter.getFluid(500), MaterialsUEVplus.TranscendentMetal.getMolten(144))
            .itemOutputs(GTCMItemList.PacketInformationTranslationArray.get(8))
            .specialValue(3)
            .eut(RECIPE_UIV)
            .duration(20 * 5)
            .addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                SpaceTimeSuperconductingInlaidMotherboard.get(1),
                GTCMItemList.SiliconBasedNeuron.get(4),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.Eternity, 16),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SuperconductorUMVBase, 16))
            .fluidInputs(Materials.UUMatter.getFluid(1000), MaterialsUEVplus.TranscendentMetal.getMolten(288))
            .itemOutputs(GTCMItemList.PacketInformationTranslationArray.get(64))
            .specialValue(3)
            .eut(RECIPE_UIV)
            .duration(20 * 5)
            .addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);

        // InformationHorizonInterventionShell
        GT_Values.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.TranscendentMetal, 1))
            .metadata(RESEARCH_TIME, 24 * HOURS)
            .itemInputs(
                MaterialsUEVplus.TranscendentMetal.getNanite(1),
                GTCMItemList.ParticleTrapTimeSpaceShield.get(32),
                ItemList.EnergisedTesseract.get(2),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 16))
            .fluidInputs(MaterialsUEVplus.Time.getMolten(36), CELESTIAL_TUNGSTEN.getFluidStack(36))
            .itemOutputs(GTCMItemList.InformationHorizonInterventionShell.get(16))
            .eut(RECIPE_UMV)
            .duration(20 * 30)
            .addTo(GT_RecipeConstants.AssemblyLine);

        TST_RecipeBuilder.builder()
            .itemInputs(
                GTCMItemList.MatterRecombinator.get(0),
                ItemUtils.simpleMetaStack(ModItems.itemStandarParticleBase, 17, 1),
                Laser_Lens_Special.get(1),
                GTCMItemList.ParticleTrapTimeSpaceShield.get(64),
                ItemList.EnergisedTesseract.get(4),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 32))
            .fluidInputs(MaterialsUEVplus.Time.getMolten(144))
            .itemOutputs(GTCMItemList.InformationHorizonInterventionShell.get(32))
            .eut(RECIPE_UMV)
            .duration(20 * 240)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        // EnergyFluctuationSelfHarmonizer
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(24),
                Laser_Lens_Special.get(1),
                GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.TranscendentMetal, 2),
                MyMaterial.metastableOganesson.get(OrePrefixes.foil, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 2))
            .fluidInputs(
                MaterialsUEVplus.Time.getMolten(72),
                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(100))
            .itemOutputs(GTCMItemList.EnergyFluctuationSelfHarmonizer.get(1))
            .outputChances(9000)
            .eut(RECIPE_UMV)
            .duration(20 * 120)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        TST_RecipeBuilder.builder()
            .itemInputs(
                GTCMItemList.MatterRecombinator.get(0),
                GTCMItemList.Antimatter.get(1),
                GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.TranscendentMetal, 2),
                MyMaterial.metastableOganesson.get(OrePrefixes.foil, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 2))
            .fluidInputs(
                MaterialsUEVplus.Time.getMolten(36),
                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(50))
            .itemOutputs(GTCMItemList.EnergyFluctuationSelfHarmonizer.get(1))
            .eut(RECIPE_UMV)
            .duration(20 * 120)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        TST_RecipeBuilder.builder()
            .itemInputs(
                GTCMItemList.CoreElement.get(0),
                GTCMItemList.Antimatter.get(1),
                GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.TranscendentMetal, 2),
                MyMaterial.metastableOganesson.get(OrePrefixes.foil, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 2))
            .fluidInputs(
                MaterialsUEVplus.Time.getMolten(36),
                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(50))
            .itemOutputs(
                GTCMItemList.EnergyFluctuationSelfHarmonizer.get(2),
                GTCMItemList.EnergyFluctuationSelfHarmonizer.get(1))
            .outputChances(10000, 2000)
            .eut(RECIPE_UMV)
            .duration(20 * 120)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        // Cosmic processor UEV
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                EncapsulatedMicroSpaceTimeUnit.get(1),
                InformationHorizonInterventionShell.get(1),
                PacketInformationTranslationArray.get(1),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 2),
                GT_OreDictUnificator.get(OrePrefixes.screw, MaterialsUEVplus.TranscendentMetal, 2),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Infinity, 4))
            .fluidInputs(
                // TODO spacetime glue
                Materials.Hydrogen.getPlasma(100),
                Materials.Lead.getPlasma(72),
                Materials.Plutonium241.getPlasma(72),
                RadoxPolymer.getMolten(288))
            .itemOutputs(
                Circuit_CosmicProcessor.get(1),
                GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsUEVplus.SpaceTime, 3))
            .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(333))
            .eut(RECIPE_UEV)
            .duration(20 * 50)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        // Cosmic processor assembly UIV
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                SpaceTimeSuperconductingInlaidMotherboard.get(1),
                Circuit_CosmicProcessor.get(1),
                InformationHorizonInterventionShell.get(1),
                PacketInformationTranslationArray.get(2),
                ParticleTrapTimeSpaceShield.get(1),
                GT_OreDictUnificator.get(OrePrefixes.foil, RadoxPolymer, 4))
            .fluidInputs(
                // TODO spacetime glue
                Materials.Hydrogen.getPlasma(200),
                ELEMENT.STANDALONE.HYPOGEN.getFluidStack(72),
                MyMaterial.metastableOganesson.getMolten(144),
                RadoxPolymer.getMolten(288))
            .itemOutputs(
                ItemList.Circuit_CosmicAssembly.get(1),
                GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsUEVplus.SpaceTime, 3))
            .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(333))
            .eut(RECIPE_UIV)
            .duration(20 * 100)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        // Cosmic processor super computer UMV
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                SpaceTimeSuperconductingInlaidMotherboard.get(2),
                Circuit_CosmicAssembly.get(2),
                EnergyFluctuationSelfHarmonizer.get(1),
                InformationHorizonInterventionShell.get(2),
                PacketInformationTranslationArray.get(4),
                CustomItemList.PicoWafer.get(4),
                ItemList.Tesseract.get(1),
                ItemList.EnergisedTesseract.get(1))
            .fluidInputs(
                // TODO spacetime glue
                Materials.Hydrogen.getPlasma(500),
                Materials.UUMatter.getFluid(8000),
                MaterialsUEVplus.SpaceTime.getMolten(288),
                Materials.Thorium.getPlasma(288))
            .itemOutputs(
                ItemList.Circuit_CosmicComputer.get(1),
                GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsUEVplus.SpaceTime, 3))
            .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(333))
            .eut(RECIPE_UIV)
            .duration(20 * 1000)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        // Cosmic processor mainframe UXV
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                SeedsSpaceTime.get(2),
                Circuit_CosmicComputer.get(2),
                EnergyFluctuationSelfHarmonizer.get(1),
                InformationHorizonInterventionShell.get(2),
                PacketInformationTranslationArray.get(8),
                SpaceTimeSuperconductingInlaidMotherboard.get(2),
                CELESTIAL_TUNGSTEN.getPlate(8))
            .fluidInputs(
                // TODO spacetime glue
                Materials.Hydrogen.getPlasma(1000),
                MyMaterial.shirabon.getMolten(1152),
                MaterialsUEVplus.Space.getMolten(1152),
                MaterialsUEVplus.Time.getMolten(1152))
            .itemOutputs(ItemList.Circuit_CosmicMainframe.get(1), ItemList.Tesseract.get(2))
            .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(666))
            .eut(RECIPE_UMV)
            .duration(20 * 1500)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                SeedsSpaceTime.get(3),
                Circuit_CosmicComputer.get(2),
                EnergyFluctuationSelfHarmonizer.get(1),
                InformationHorizonInterventionShell.get(3),
                PacketInformationTranslationArray.get(9),
                SpaceTimeSuperconductingInlaidMotherboard.get(3),
                CELESTIAL_TUNGSTEN.getPlate(9))
            .fluidInputs(
                // TODO spacetime glue
                Materials.Hydrogen.getPlasma(1000),
                MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(72),
                MaterialsUEVplus.Space.getMolten(1152),
                MaterialsUEVplus.Time.getMolten(1152))
            .itemOutputs(ItemList.Circuit_CosmicMainframe.get(3), ItemList.Tesseract.get(6))
            .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(666))
            .eut(RECIPE_UMV)
            .duration(20 * 2400)
            .addTo(GTCMRecipe.MiracleTopRecipes);

        // Seed of Space and Time
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(24),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.SpaceTime, 1),
                Laser_Lens_Special.get(1),
                eternal_singularity.copy(),
                MaterialType.Singularity.stack(1),
                MyMaterial.shirabon.get(OrePrefixes.stick, 2))
            .fluidInputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(500))
            .itemOutputs(SeedsSpaceTime.get(1))
            .eut(RECIPE_UMV)
            .duration(20 * 60)
            .addTo(GTCMRecipe.MicroSpaceTimeFabricatorioRecipes);

        // Encapsulated Micro SpaceTime Unit
        TST_RecipeBuilder.builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                SpaceTimeSuperconductingInlaidMotherboard.get(1),
                InformationHorizonInterventionShell.get(1),
                EnergyFluctuationSelfHarmonizer.get(1),
                eternal_singularity.copy(),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 3))
            .fluidInputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(200))
            .itemOutputs(EncapsulatedMicroSpaceTimeUnit.get(1))
            .eut(RECIPE_UMV)
            .duration(20 * 30)
            .addTo(GTCMRecipe.MicroSpaceTimeFabricatorioRecipes);

        // MicroSpaceTimeFabricatorio
        GT_Values.RA.stdBuilder()
            .metadata(
                RESEARCH_ITEM,
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 1))
            .metadata(RESEARCH_TIME, 24 * HOURS)
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.TranscendentMetal, 16),
                GTCMItemList.SpaceWarper.get(16),
                GTCMItemList.GravitationalLens.get(16),
                // TODO piko
                CustomItemList.PikoCircuit.get(16),

                EnergyFluctuationSelfHarmonizer.get(16),
                PacketInformationTranslationArray.get(16),
                setStackSize(eternal_singularity.copy(), 16),
                ItemList.EnergisedTesseract.get(16),

                ItemList.Field_Generator_UIV.get(16),
                ItemList.Emitter_UIV.get(16),
                ItemList.Sensor_UIV.get(16),
                CustomItemList.HighEnergyFlowCircuit.get(16),

                GT_OreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 64),
                GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUIV, 48))
            .fluidInputs(
                MISC_MATERIALS.MUTATED_LIVING_SOLDER.getFluidStack(144 * 128),
                Materials.Hydrogen.getPlasma(1000 * 64),
                Materials.UUMatter.getFluid(1000 * 64),
                Materials.Quantium.getMolten(144 * 128))
            .itemOutputs(GTCMItemList.MicroSpaceTimeFabricatorio.get(1))
            .eut(RECIPE_UMV)
            .duration(20 * 900)
            .addTo(GT_RecipeConstants.AssemblyLine);

        // AE Singularity
        GT_Values.RA.stdBuilder()
            .itemInputs(Laser_Lens_Special.get(1), eternal_singularity.copy())
            .itemOutputs(MaterialType.Singularity.stack(16), MaterialType.Singularity.stack(16))
            .outputChances(5000, 5000)
            .eut(RECIPE_UMV)
            .duration(20 * 100)
            .addTo(BartWorksRecipeMaps.electricImplosionCompressorRecipes);

    }
}
