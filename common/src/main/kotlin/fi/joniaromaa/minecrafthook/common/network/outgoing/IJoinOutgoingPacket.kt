package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IGamemode

interface IJoinOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int
    val gamemode: IGamemode

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IJoinOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Join | Entity Id: $entityId | Gamemode: $gamemode"
    }

    private open class StubJoinOutgoingPacket : IJoinOutgoingPacket
    {
        override val entityId: Int
            get() = throw UnsupportedOperationException()
        override val gamemode: IGamemode
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun newInstance(type: IGamemode.Type): IJoinOutgoingPacket = object : StubJoinOutgoingPacket()
        {
            override val entityId: Int
                get() = 0
            override val gamemode: IGamemode
                get() = type.stubGamemode
        }
    }
}