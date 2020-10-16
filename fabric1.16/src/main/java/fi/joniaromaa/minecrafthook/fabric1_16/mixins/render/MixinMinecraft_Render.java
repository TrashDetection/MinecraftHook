package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.LongSupplier;

import com.mojang.datafixers.DataFixer;
import net.minecraft.client.font.FontManager;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.texture.PaintingManager;
import net.minecraft.client.texture.StatusEffectSpriteManager;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReloadMonitor;
import net.minecraft.util.snooper.Snooper;
import net.minecraft.util.snooper.SnooperListener;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import fi.joniaromaa.minecrafthook.fabric1_16.utils.UnsafeUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.WindowProvider;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraft_Render
{
	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/util/snooper/Snooper"))
	private Snooper onNewSnooper(String urlPath, SnooperListener listener, long startTime)
	{
		return UnsafeUtils.allocateInstance(Snooper.class);
	}

	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initBackendSystem()Ljava/util/function/LongSupplier;"))
	private LongSupplier onInitRenderer()
	{
		return System::nanoTime; //TODO: CHECK
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/util/WindowProvider"))
	private WindowProvider onNewWindowProvider(MinecraftClient client)
	{
		return UnsafeUtils.allocateInstance(WindowProvider.class);
	}
	
	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initRenderer(IZ)V"))
	private void onInitRenderer(int p_initRenderer_0_, boolean p_initRenderer_1_)
	{
	}
	
	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/gl/Framebuffer"))
	private Framebuffer onNewFramebuffer(int x, int z, boolean unknown, boolean mac)
	{
		return UnsafeUtils.allocateInstance(Framebuffer.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/world/level/storage/LevelStorage"))
	private LevelStorage onNewSoundManager(Path savesDirectory, Path backupsDirectory, DataFixer dataFixer)
	{
		return UnsafeUtils.allocateInstance(LevelStorage.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/sound/SoundManager"))
	private SoundManager onNewSoundManager(ResourceManager resourceManager, GameOptions gameOptions)
	{
		return UnsafeUtils.allocateInstance(SoundManager.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/font/FontManager"))
	private FontManager onNewFontManager(TextureManager manager)
	{
		return UnsafeUtils.allocateInstance(FontManager.class);
	}

	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setupDefaultState(IIII)V"))
	private void onSetupDefaultState(int x, int y, int width, int height)
	{
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/render/GameRenderer"))
	private GameRenderer onNewGameRenderer(MinecraftClient client, ResourceManager resourceManager, BufferBuilderStorage bufferBuilderStorage)
	{
		return UnsafeUtils.allocateInstance(GameRenderer.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/render/WorldRenderer"))
	private WorldRenderer onNewWorldRenderer(MinecraftClient client, BufferBuilderStorage bufferBuilders)
	{
		return UnsafeUtils.allocateInstance(WorldRenderer.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/particle/ParticleManager"))
	private ParticleManager onNewParticleManager(ClientWorld world, TextureManager textureManager)
	{
		return UnsafeUtils.allocateInstance(ParticleManager.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/texture/PaintingManager"))
	private PaintingManager onNewParticleManager(TextureManager manager)
	{
		return UnsafeUtils.allocateInstance(PaintingManager.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/texture/StatusEffectSpriteManager"))
	private StatusEffectSpriteManager onNewStatusEffectSpriteManager(TextureManager textureManager)
	{
		return UnsafeUtils.allocateInstance(StatusEffectSpriteManager.class);
	}

	@Redirect(method = "<init>", at = @At(value = "NEW", args = "class=net/minecraft/client/gui/screen/SplashScreen"))
	private SplashScreen onNewSplashScreen(MinecraftClient client, ResourceReloadMonitor monitor, Consumer<Optional<Throwable>> exceptionHandler, boolean reloading)
	{
		return UnsafeUtils.allocateInstance(SplashScreen.class);
	}

	@Inject(method = "onResolutionChanged", at = @At("HEAD"), cancellable = true)
	private void onOnResolutionChanged(CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(method = "openScreen", at = @At("HEAD"), cancellable = true)
	private void onOpenScreen(Screen screen, CallbackInfo ci)
	{
		ci.cancel();
	}
}
