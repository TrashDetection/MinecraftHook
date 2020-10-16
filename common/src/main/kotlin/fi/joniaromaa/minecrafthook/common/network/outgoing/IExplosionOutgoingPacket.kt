package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IExplosionOutgoingPacket : IMinecraftOutgoingPacket
{
    val velocityX: Float
    val velocityY: Float
    val velocityZ: Float

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IExplosionOutgoingPacket::class.java
}