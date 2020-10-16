package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IDestroyEntitiesOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityIds: Collection<Int>

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IDestroyEntitiesOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Destroy Entities | Entities: $entityIds"
    }
}