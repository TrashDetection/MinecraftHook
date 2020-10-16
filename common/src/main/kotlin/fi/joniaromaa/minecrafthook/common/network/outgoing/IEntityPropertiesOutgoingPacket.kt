package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IEntityPropertySnapshot

interface IEntityPropertiesOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val properties: Collection<IEntityPropertySnapshot>

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEntityPropertiesOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Properties | Entity Id: $entityId"
    }
}