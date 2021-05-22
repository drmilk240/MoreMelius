package net.mcreator.moremelius.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import net.mcreator.moremelius.MoremeliusModElements;
import net.mcreator.moremelius.MoremeliusMod;

import java.util.Map;

@MoremeliusModElements.ModElement.Tag
public class LowerCavesPlayerEntersDimensionProcedure extends MoremeliusModElements.ModElement {
	public LowerCavesPlayerEntersDimensionProcedure(MoremeliusModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency world for procedure LowerCavesPlayerEntersDimension!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("A Player has entered the Lower Caves..."), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
	}
}
