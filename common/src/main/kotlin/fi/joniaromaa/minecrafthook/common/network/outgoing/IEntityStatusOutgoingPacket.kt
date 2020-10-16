package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IEntityStatusOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val status: Byte

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEntityStatusOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Status | Entity Id: $entityId | Status: $status"
    }
}