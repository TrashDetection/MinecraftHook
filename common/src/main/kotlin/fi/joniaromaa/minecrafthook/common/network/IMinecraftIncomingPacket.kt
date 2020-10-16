package fi.joniaromaa.minecrafthook.common.network

interface IMinecraftIncomingPacket : IMinecraftPacket
{
    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
}