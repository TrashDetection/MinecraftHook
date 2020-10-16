package fi.joniaromaa.minecrafthook.common.network

interface IMinecraftOutgoingPacket : IMinecraftPacket
{
    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
}