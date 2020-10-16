package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gl.Framebuffer;

@Mixin(Framebuffer.class)
public abstract class MixinFramebuffer_Render
{
	@Inject(method = "setClearColor", at = @At("HEAD"), cancellable = true)
	private void onSetClearColor(CallbackInfo ci)
	{
		ci.cancel();
	}
}
