package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IHeldItemChangeOutgoingPacket : IMinecraftOutgoingPacket
{
    val slot: Byte

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IHeldItemChangeOutgoingPacket::class.java
}