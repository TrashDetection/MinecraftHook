package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.util.Window;

@Mixin(Window.class)
public abstract class MixinWindow_Render
{
	@Inject(method = "setIcon", at = @At("HEAD"), cancellable = true)
	private void onSetIcon(CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(method = "setFramerateLimit", at = @At("HEAD"), cancellable = true)
	private void onSetFramerateLimit(CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(method = "getHandle", at = @At("HEAD"), cancellable = true)
	private void onGetHandle(CallbackInfoReturnable<Long> cir)
	{
		cir.setReturnValue(0L);
	}

	@Inject(method = "getFramebufferWidth", at = @At("HEAD"), cancellable = true)
	private void onGetFramebufferWidth(CallbackInfoReturnable<Integer> cir)
	{
		cir.setReturnValue(0);
	}
	
	@Inject(method = "getFramebufferHeight", at = @At("HEAD"), cancellable = true)
	private void onGetFramebufferHeight(CallbackInfoReturnable<Integer> cir)
	{
		cir.setReturnValue(0);
	}
	
	@Inject(method = "setPhase", at = @At("HEAD"), cancellable = true)
	private void onSetPhase(CallbackInfo ci)
	{
		ci.cancel();
	}

	@Inject(method = "isFullscreen", at = @At("HEAD"), cancellable = true)
	private void onIsFullscreen(CallbackInfoReturnable<Boolean> cir)
	{
		//Set that we are in fullscreen mode because it involves less checks
		cir.setReturnValue(true);
	}
	
	@Inject(method = "setVsync", at = @At("HEAD"), cancellable = true)
	private void onSetVsync(CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(method = "setRawMouseMotion", at = @At("HEAD"), cancellable = true)
	private void onSetRawMouseMotion(CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(method = "logOnGlError", at = @At("HEAD"), cancellable = true)
	private void onLogOnGlError(CallbackInfo ci)
	{
		ci.cancel();
	}
}
