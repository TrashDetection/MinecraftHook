package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface ICameraOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = ICameraOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Camera | Entity Id: $entityId"
    }
}