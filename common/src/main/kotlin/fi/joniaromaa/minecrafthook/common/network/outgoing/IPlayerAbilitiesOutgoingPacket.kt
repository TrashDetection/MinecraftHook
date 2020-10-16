package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IPlayerAbilitiesOutgoingPacket : IMinecraftOutgoingPacket
{
    val isInvulnerable: Boolean
    val isFlying: Boolean
    val isFlyingAllowed: Boolean
    val isCreativeMode: Boolean

    val flySpeed: Float
    val walkSpeed: Float

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IPlayerAbilitiesOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Player Abilities | Invulnerable: $isInvulnerable | Flying: $isFlying | Allow Flying: $isFlyingAllowed | Creative Mode: $isCreativeMode | Fly Speed: $flySpeed | Walk Speed: $walkSpeed"
    }
}