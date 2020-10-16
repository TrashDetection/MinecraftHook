package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IWatchableObject
import java.util.stream.Collectors

interface IEnittyMetadataOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val watchedObjects: Collection<IWatchableObject>

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEnittyMetadataOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Metadata | Entity Id: $entityId | Objects: ${watchedObjects.stream().map { w: IWatchableObject -> w.asString() }.collect(Collectors.joining(", "))}"
    }
}