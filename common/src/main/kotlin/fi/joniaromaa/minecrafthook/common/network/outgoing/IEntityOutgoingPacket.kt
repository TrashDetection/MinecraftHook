package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IEntityOutgoingPacket : IMinecraftOutgoingPacket
{
    val entityId: Int

    val serverX: Int
    val serverY: Int
    val serverZ: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IEntityOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity | Entity Id: $entityId | X: $serverX | Y: $serverY | Z: $serverZ"
    }

    private open class StubEntityOutgoingPacket : IEntityOutgoingPacket
    {
        override val entityId: Int
            get() = throw UnsupportedOperationException()

        override val serverX: Int
            get() = throw UnsupportedOperationException()
        override val serverY: Int
            get() = throw UnsupportedOperationException()
        override val serverZ: Int
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        fun newInstance(entityId: Int, serverX: Int, serverY: Int, serverZ: Int): IEntityOutgoingPacket = object : StubEntityOutgoingPacket()
        {
            override val entityId: Int
                get() = entityId

            override val serverX: Int
                get() = serverX
            override val serverY: Int
                get() = serverY
            override val serverZ: Int
                get() = serverZ
        }
    }
}