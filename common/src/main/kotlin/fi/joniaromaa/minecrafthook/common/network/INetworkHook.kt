package fi.joniaromaa.minecrafthook.common.network

interface INetworkHook
{
    fun createEmptyBuffer(): IPacketBuffer

    fun getNetworkState(state: NetworkState): INetworkState
}