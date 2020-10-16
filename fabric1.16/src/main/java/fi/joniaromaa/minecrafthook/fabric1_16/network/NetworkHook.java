package fi.joniaromaa.minecrafthook.fabric1_16.network;

import fi.joniaromaa.minecrafthook.common.network.*;
import org.jetbrains.annotations.NotNull;

public final class NetworkHook implements INetworkHook
{
    @NotNull
    @Override
    public IPacketBuffer createEmptyBuffer()
    {
        return null;
    }

    @NotNull
    @Override
    public INetworkState getNetworkState(@NotNull NetworkState state)
    {
        switch (state)
        {
            case PLAY:
                return (INetworkState)(Object)net.minecraft.network.NetworkState.PLAY;
            default:
                throw new UnsupportedOperationException("Unsupported state: " + state);
        }
    }
}
