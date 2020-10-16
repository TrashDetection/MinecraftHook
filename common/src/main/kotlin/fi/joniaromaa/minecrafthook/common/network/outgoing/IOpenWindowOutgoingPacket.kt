package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IOpenWindowOutgoingPacket : IMinecraftOutgoingPacket
{
    val windowId: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IOpenWindowOutgoingPacket::class.java
}