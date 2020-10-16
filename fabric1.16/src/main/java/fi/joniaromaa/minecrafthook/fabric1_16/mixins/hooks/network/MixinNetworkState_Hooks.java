package fi.joniaromaa.minecrafthook.fabric1_16.mixins.hooks.network;

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket;
import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket;
import fi.joniaromaa.minecrafthook.common.network.INetworkState;
import fi.joniaromaa.minecrafthook.fabric1_16.mixins.accessors.NetworkStateAccessor;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.NetworkState;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Mixin(NetworkState.class)
public abstract class MixinNetworkState_Hooks implements INetworkState
{
    @Shadow @Final private Map<NetworkSide, NetworkStateAccessor.PacketHandlerAccessor> packetHandlers;

    private Map<Integer, Supplier<? extends IMinecraftIncomingPacket>> serverboundPackets;
    private Map<Integer, Supplier<? extends IMinecraftOutgoingPacket>> clientboundPackets;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstructor(CallbackInfo ci)
    {
        this.serverboundPackets = new HashMap<>();
        this.clientboundPackets = new HashMap<>();
    }

    @NotNull
    @Override
    public IMinecraftIncomingPacket createServerboundPacket(int id)
    {
        return this.serverboundPackets.get(id).get();
    }

    @NotNull
    @Override
    public IMinecraftOutgoingPacket createClientboundPacket(int id)
    {
        return this.clientboundPackets.get(id).get();
    }
}
