package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IHeldItemChangeIncomingPacket : IMinecraftIncomingPacket
{
    val slot: Short

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IHeldItemChangeIncomingPacket::class.java
}