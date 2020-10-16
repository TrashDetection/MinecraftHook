package fi.joniaromaa.minecrafthook.common.network

interface INetworkState
{
    fun createServerboundPacket(id: Int): IMinecraftIncomingPacket;
    fun createClientboundPacket(id: Int): IMinecraftOutgoingPacket;
}