package fi.joniaromaa.minecrafthook.fabric1_16.mixins.accessors;

import net.minecraft.network.NetworkState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NetworkState.class)
public interface NetworkStateAccessor
{
    @Mixin(targets = "net/minecraft/network/NetworkState$PacketHandler")
    public interface PacketHandlerAccessor
    {

    }
}
