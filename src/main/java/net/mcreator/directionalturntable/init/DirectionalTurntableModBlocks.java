
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.directionalturntable.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.directionalturntable.block.DirectionalTurntableBlock;
import net.mcreator.directionalturntable.DirectionalTurntableMod;

public class DirectionalTurntableModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DirectionalTurntableMod.MODID);
	public static final RegistryObject<Block> DIRECTIONAL_TURNTABLE = REGISTRY.register("directional_turntable", () -> new DirectionalTurntableBlock());
}
