
package net.mcreator.moremelius.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.moremelius.procedures.AquaticQueen3Procedure;
import net.mcreator.moremelius.procedures.AquaticDeep4Procedure;
import net.mcreator.moremelius.procedures.AquaticDarkDisplayOverlayIngameProcedure;
import net.mcreator.moremelius.procedures.AquaticDark2Procedure;
import net.mcreator.moremelius.MoremeliusModElements;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@MoremeliusModElements.ModElement.Tag
public class AquaticDarkOverlay extends MoremeliusModElements.ModElement {
	public AquaticDarkOverlay(MoremeliusModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (AquaticDarkDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("moremelius:textures/overlay.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -253, posY + -141, 0, 0, 500, 275, 500, 275);
				if (AquaticDark2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("moremelius:textures/overlay.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -255, posY + -139, 0, 0, 500, 275, 500, 275);
				}
				if (AquaticQueen3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("moremelius:textures/overlay.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -256, posY + -139, 0, 0, 500, 275, 500, 275);
				}
				if (AquaticDeep4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("moremelius:textures/overlay.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -256, posY + -141, 0, 0, 500, 275, 500, 275);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
