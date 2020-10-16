package fi.joniaromaa.minecrafthook.fabric1_16.mixins.hooks;

import fi.joniaromaa.minecrafthook.common.MinecraftHooks;
import fi.joniaromaa.minecrafthook.fabric1_16.MinecraftHook;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.NetworkState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraft_Hooks
{
    @Inject(method = "run", at = @At("HEAD"), cancellable = true)
    private void onRun(CallbackInfo ci)
    {
        ci.cancel();

        MinecraftHooks.register(MinecraftHook.build());

        System.out.println("Stopped running the client!");

        //AccessorNetworkState accessor = (AccessorNetworkState)(Object)NetworkState.PLAY;

        //System.out.println(accessor);
        //System.out.println(accessor.getPacketHandler(NetworkSide.SERVERBOUND, 0));
    }
}
