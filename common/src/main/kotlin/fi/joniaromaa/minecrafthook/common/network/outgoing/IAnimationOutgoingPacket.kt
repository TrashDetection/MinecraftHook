package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IAnimationOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val animation: Animation

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IAnimationOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Animation | Entity Id: $entityId | Animation: $animation"
    }

    enum class Animation
    {
        SWING,
        HURT,
        WAKE_UP,
        CONSUME,
        CRITICAL,
        MAGIC_CRITICAL
    }
}