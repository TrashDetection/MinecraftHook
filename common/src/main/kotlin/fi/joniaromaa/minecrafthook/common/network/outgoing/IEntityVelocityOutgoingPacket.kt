package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IEntityVelocityOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int

    val velocityX: Short
    val velocityY: Short
    val velocityZ: Short

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEntityVelocityOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Velocity | Entity Id: $entityId | Velocty X: $velocityX | Velocty Y: $velocityY | Velocty Z: $velocityZ"
    }
}