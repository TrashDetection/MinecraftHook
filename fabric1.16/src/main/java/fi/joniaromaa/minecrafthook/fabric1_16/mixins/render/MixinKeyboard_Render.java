package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Keyboard;

@Mixin(Keyboard.class)
public abstract class MixinKeyboard_Render
{
	@Inject(method = "setup", at = @At("HEAD"), cancellable = true)
	private void onSetup(CallbackInfo ci)
	{
		ci.cancel();
	}
}
