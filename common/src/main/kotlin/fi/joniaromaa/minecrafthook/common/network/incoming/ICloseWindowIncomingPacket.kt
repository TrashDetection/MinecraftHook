package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface ICloseWindowIncomingPacket : IMinecraftIncomingPacket
{
    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = ICloseWindowIncomingPacket::class.java
}