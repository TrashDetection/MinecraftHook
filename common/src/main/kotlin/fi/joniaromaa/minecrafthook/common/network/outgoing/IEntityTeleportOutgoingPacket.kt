package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IEntityTeleportOutgoingPacket : IMinecraftOutgoingPacket
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
        get() = IEntityTeleportOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Teleport | Entity Id: $entityId | X: $x | Y: $y | Z: $z"
    }

    private open class StubEntityTeleportOutgoingPacket : IEntityTeleportOutgoingPacket
    {
        override val entityId: Int
            get() = throw UnsupportedOperationException()

        override val serverX: Int
            get() = throw UnsupportedOperationException()
        override val serverY: Int
            get() = throw UnsupportedOperationException()
        override val serverZ: Int
            get() = throw UnsupportedOperationException()

        override val x: Double
            get() = throw UnsupportedOperationException()
        override val y: Double
            get() = throw UnsupportedOperationException()
        override val z: Double
            get() = throw UnsupportedOperationException()

    }

    companion object
    {
        fun newInstance(entityId: Int, serverX: Int, serverY: Int, serverZ: Int): IEntityTeleportOutgoingPacket = object : StubEntityTeleportOutgoingPacket()
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