package net.mcreator.moremelius.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.mcreator.moremelius.MoremeliusModElements;
import net.mcreator.moremelius.MoremeliusMod;

import java.util.Map;

@MoremeliusModElements.ModElement.Tag
public class RuinsOnStructureInstanceGeneratedProcedure extends MoremeliusModElements.ModElement {
	public RuinsOnStructureInstanceGeneratedProcedure(MoremeliusModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency x for procedure RuinsOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency y for procedure RuinsOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency z for procedure RuinsOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MoremeliusMod.LOGGER.warn("Failed to load dependency world for procedure RuinsOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double offsetx = 0;
		double offsetz = 0;
		double offsety = 0;
		double randomdir = 0;
		randomdir = (double) Math.round(((Math.random() * 3) + 1));
		System.out.println((randomdir));
		if (((randomdir) == 1)) {
			offsetx = (double) 3;
			offsety = (double) 0;
			offsetz = (double) 0;
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("moremelius", "ruinedblock"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + (offsetx)), (int) (y + (offsety)), (int) (z + (offsetz))),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((randomdir) == 2)) {
			offsetx = (double) 0;
			offsety = (double) 0;
			offsetz = (double) 3;
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("moremelius", "ruinedblock"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + (offsetx)), (int) (y + (offsety)), (int) (z + (offsetz))),
							new PlacementSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((randomdir) == 3)) {
			offsetx = (double) (-3);
			offsety = (double) 0;
			offsetz = (double) 0;
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("moremelius", "ruinedblock"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + (offsetx)), (int) (y + (offsety)), (int) (z + (offsetz))),
							new PlacementSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null)
									.setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((randomdir) == 4)) {
			offsetx = (double) 0;
			offsety = (double) 0;
			offsetz = (double) (-3);
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("moremelius", "ruinedblock"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + (offsetx)), (int) (y + (offsety)), (int) (z + (offsetz))),
							new PlacementSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
									.setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
	}
}
