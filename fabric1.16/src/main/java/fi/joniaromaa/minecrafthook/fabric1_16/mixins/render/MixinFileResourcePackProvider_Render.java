package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import net.minecraft.resource.FileResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FileResourcePackProvider.class)
public abstract class MixinFileResourcePackProvider_Render
{
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private void onRegister(CallbackInfo ci)
    {
        ci.cancel();
    }
}
