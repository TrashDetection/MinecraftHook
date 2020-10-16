package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IPlayerAbilitiesIncomingPacket : IMinecraftIncomingPacket
{
    val isFlying: Boolean
    val isFlyingAllowed: Boolean

    val flySpeed: Float
    val walkSpeed: Float

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IPlayerAbilitiesIncomingPacket::class.java
}