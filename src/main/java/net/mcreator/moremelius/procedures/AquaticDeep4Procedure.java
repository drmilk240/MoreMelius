package net.mcreator.moremelius.procedures;

@MoremeliusModElements.ModElement.Tag
public class AquaticDeep4Procedure extends MoremeliusModElements.ModElement {

	public AquaticDeep4Procedure(MoremeliusModElements instance) {
		super(instance, 31);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency entity for procedure AquaticDeep4!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		boolean displayvalue = false;
		return (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 5);

	}

}
