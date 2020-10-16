package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IKeepAliveIncomingPacket : IMinecraftIncomingPacket
{
    val id: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IKeepAliveIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Keep Alive | Id: $id"
    }
}