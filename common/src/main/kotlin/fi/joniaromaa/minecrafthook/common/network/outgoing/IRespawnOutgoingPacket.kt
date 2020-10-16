package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IGamemode

interface IRespawnOutgoingPacket : IMinecraftOutgoingPacket
{
    val gamemode: IGamemode

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IRespawnOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Respawn | Gamemode: $gamemode"
    }

    private open class StubRespawnOutgoingPacket : IRespawnOutgoingPacket
    {
        override val gamemode: IGamemode
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun newInstance(type: IGamemode.Type): IRespawnOutgoingPacket = object : StubRespawnOutgoingPacket()
        {
            override val gamemode: IGamemode
                get() = type.stubGamemode
        }
    }
}