package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IKeepAliveOutgoingPacket : IMinecraftOutgoingPacket
{
    val id: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IKeepAliveOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String {
        return "Keep Alive | Id: $id"
    }
}