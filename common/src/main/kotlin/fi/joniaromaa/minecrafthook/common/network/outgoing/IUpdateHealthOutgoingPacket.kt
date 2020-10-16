package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IUpdateHealthOutgoingPacket : IMinecraftOutgoingPacket
{
    val food: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IUpdateHealthOutgoingPacket::class.java
}