package net.mcreator.moremelius.procedures;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;

import net.mcreator.moremelius.MoremeliusModElements;
import net.mcreator.moremelius.MoremeliusMod;

import java.util.Map;

@MoremeliusModElements.ModElement.Tag
public class AquaticDarkDisplayOverlayIngameProcedure extends MoremeliusModElements.ModElement {
	public AquaticDarkDisplayOverlayIngameProcedure(MoremeliusModElements instance) {
		super(instance, 26);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency entity for procedure AquaticDarkDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean displayvalue = false;
		return ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("moremelius:the_deep"))));
	}
}
