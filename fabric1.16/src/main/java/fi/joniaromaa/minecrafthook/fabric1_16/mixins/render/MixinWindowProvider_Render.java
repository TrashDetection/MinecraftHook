package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import fi.joniaromaa.minecrafthook.fabric1_16.utils.UnsafeUtils;
import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.WindowSettings;
import net.minecraft.client.util.MonitorTracker;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.WindowProvider;

@Mixin(WindowProvider.class)
public abstract class MixinWindowProvider_Render
{
	@Redirect(method = "createWindow", at = @At(value = "NEW", args = "class=net/minecraft/client/util/Window"))
	private Window onNewWindow(WindowEventHandler eventHandler, MonitorTracker monitorTracker, WindowSettings settings, @Nullable String videoMode, String title)
	{
		return UnsafeUtils.allocateInstance(Window.class);
	}
}
