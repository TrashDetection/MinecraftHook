package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface ICloseWindowOutgoingPacket : IMinecraftOutgoingPacket
{
    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = ICloseWindowOutgoingPacket::class.java
}