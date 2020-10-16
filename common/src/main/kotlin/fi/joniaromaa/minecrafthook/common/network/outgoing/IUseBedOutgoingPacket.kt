package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IBlockPos

interface IUseBedOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val position: IBlockPos

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IUseBedOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Use Bed | Entity Id: $entityId | Block Pos: $position"
    }
}