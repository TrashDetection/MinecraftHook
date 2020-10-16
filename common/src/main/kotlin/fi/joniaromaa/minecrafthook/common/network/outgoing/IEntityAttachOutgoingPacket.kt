package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IEntityAttachOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val vehicleId: Int
    val isLeashed: Boolean

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEntityAttachOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Attach | Entity Id: $entityId | Vehicle Id: $vehicleId | Leashed: $isLeashed";
    }

    companion object
    {
        const val DISMOUNT_VEHICLE_ID = -1
    }
}