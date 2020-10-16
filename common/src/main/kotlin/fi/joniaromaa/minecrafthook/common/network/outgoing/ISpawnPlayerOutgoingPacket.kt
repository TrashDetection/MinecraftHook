package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface ISpawnPlayerOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int

    val serverX: Int
    val serverY: Int
    val serverZ: Int

    val x: Double
    val y: Double
    val z: Double

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = ISpawnPlayerOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Spawn Player | Entity Id: $entityId | X: $x | Y: $y | Z: $z"
    }
}