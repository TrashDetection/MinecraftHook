package fi.joniaromaa.minecrafthook.forge1_8.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import fi.joniaromaa.minecrafthook.common.MinecraftHooks;
import fi.joniaromaa.minecrafthook.forge1_8.MinecraftHook;
import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
	@Inject(method = "run", at = @At("HEAD"), cancellable = true)
	private void onRun(CallbackInfo ci)
	{
		ci.cancel();

		MinecraftHooks.register(MinecraftHook.build());
		
		System.out.println("Stopped running the client");
	}
	
	@Inject(method = "getSystemTime", at = @At("HEAD"), cancellable = true)
    private static void getSystemTime(CallbackInfoReturnable<Long> cir)
    {
		//TODO: CHECK
		cir.setReturnValue(0L);
    }
}
