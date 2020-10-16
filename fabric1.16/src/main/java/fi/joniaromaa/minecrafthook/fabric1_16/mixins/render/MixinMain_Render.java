package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.main.Main;

@Mixin(Main.class)
public abstract class MixinMain_Render
{
	@Redirect(method = "main", at = @At(value = "INVOKE", target = "Ljava/lang/Thread;setName(Ljava/lang/String;)V"))
	private static void onSetName(Thread thread, String name)
	{
	}
	
	//TODO: Keep?
	//@Redirect(method = "main", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initRenderThread()V"))
	//private static void onInitRenderThread()
	//{
	//}
	
	@Redirect(method = "main", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;beginInitialization()V"))
	private static void onBeginInitialization()
	{
	}
	
	@Redirect(method = "main", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;finishInitialization()V"))
	private static void onFinishInitialization()
	{
	}
	
	@Redirect(method = "main", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initGameThread(Z)V"))
	private static void onInitGameThread(boolean value)
	{
	}
	
	@Redirect(method = "main", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;scheduleStop()V"))
	private static void onScheduleStop(MinecraftClient client)
	{
	}
	
	@Redirect(method = "main", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;stop()V"))
	private static void onStop(MinecraftClient client)
	{
	}
}
