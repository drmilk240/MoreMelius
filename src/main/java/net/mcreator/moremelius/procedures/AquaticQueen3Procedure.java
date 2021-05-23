package net.mcreator.moremelius.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.moremelius.MoremeliusModElements;
import net.mcreator.moremelius.MoremeliusMod;

import java.util.Map;

@MoremeliusModElements.ModElement.Tag
public class AquaticQueen3Procedure extends MoremeliusModElements.ModElement {
	public AquaticQueen3Procedure(MoremeliusModElements instance) {
		super(instance, 30);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency entity for procedure AquaticQueen3!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean displayvalue = false;
		return (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 5);
	}
}
