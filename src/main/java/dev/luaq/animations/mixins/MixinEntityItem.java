package dev.luaq.animations.mixins;

import dev.luaq.animations.LuaqAnimations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RenderEntityItem.class)
public class MixinEntityItem {
    @Redirect(method = "func_177077_a", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;rotate(FFFF)V"))
    public void onRotate(float angle, float x, float y, float z) {
        if (!LuaqAnimations.instance.isEnabled()) {
            GlStateManager.rotate(angle, x, y, z);
            return;
        }

        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();

        int playerViewX = (int) (entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch));
        int playerViewY = (int) (entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw));

        GlStateManager.rotate(-playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(playerViewX, 1.0F, 0.0F, 0.0F);
    }
}
