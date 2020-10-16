package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourceReloadMonitor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ReloadableResourceManagerImpl.class)
public abstract class MixinReloadableResourceManagerImpl_Render
{
    @Inject(method = "beginMonitoredReload", at = @At("HEAD"), cancellable = true)
    private void onBeginMonitoredReload(CallbackInfoReturnable<ResourceReloadMonitor> cir)
    {
        cir.setReturnValue(null);
    }
}
