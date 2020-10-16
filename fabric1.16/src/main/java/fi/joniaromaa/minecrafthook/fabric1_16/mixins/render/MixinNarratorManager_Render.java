package fi.joniaromaa.minecrafthook.fabric1_16.mixins.render;

import fi.joniaromaa.minecrafthook.fabric1_16.utils.UnsafeUtils;
import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NarratorManager.class)
public abstract class MixinNarratorManager_Render
{
    @Redirect(method = "<clinit>", at = @At(value = "NEW", args = "class=net/minecraft/client/util/NarratorManager"))
    private static NarratorManager onNewNarratorManager()
    {
        return UnsafeUtils.allocateInstance(NarratorManager.class);
    }
}
