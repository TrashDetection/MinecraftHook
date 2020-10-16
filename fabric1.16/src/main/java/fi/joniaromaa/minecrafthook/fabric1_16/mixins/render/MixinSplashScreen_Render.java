package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import net.minecraft.client.gui.screen.SplashScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashScreen.class)
public abstract class MixinSplashScreen_Render
{
    @Inject(method = "*", at = @At("HEAD"), cancellable = true)
    private static void onAnyVoid(CallbackInfo ci)
    {
        ci.cancel();
    }
}
