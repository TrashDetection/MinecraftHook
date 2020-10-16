package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IChangeGameStateOutgoingPacket : IMinecraftOutgoingPacket
{
    val state: State
    val value: Float

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IChangeGameStateOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Change Game State | State: $state | Value: $value"
    }

    enum class State
    {
        CANT_SLEEP,
        START_RAINING,
        STOP_RAINING,
        SET_GAMEMODE,
        END_CREDITS,
        DEMO,
        ARROW_HIT,
        RAIN_STRENGTH,
        THUNDER_STRENGTH,
        GUARDIAN_CURSE
    }
}