package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IEntityEffectOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int

    val effectId: Byte
    val amplifier: Byte
    val duration: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEntityEffectOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Effect | Entity Id: $entityId | Effect Id: $effectId | Amplifier: $amplifier | Duration: $duration"
    }
}