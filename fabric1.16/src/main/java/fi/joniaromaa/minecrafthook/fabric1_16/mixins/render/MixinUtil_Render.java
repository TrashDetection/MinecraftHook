package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Util.class)
public class MixinUtil_Render
{
    @Inject(method = "startTimerHack", at = @At("HEAD"), cancellable = true)
    private static void onStartTimerHack(CallbackInfo ci)
    {
        ci.cancel();
    }
}
