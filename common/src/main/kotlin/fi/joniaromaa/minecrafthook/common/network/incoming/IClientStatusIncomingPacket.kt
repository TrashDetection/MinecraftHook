package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IClientStatusIncomingPacket : IMinecraftIncomingPacket
{
    val status: Status

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IClientStatusIncomingPacket::class.java

    enum class Status
    {
        PERFORM_RESPAWN,
        REQUEST_STATS,
        OPEN_INVENTORY_ACHIEVEMENT
    }
}