package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IPlayerPositionAndLookOutgoingPacket : IMinecraftOutgoingPacket
{
    val x: Double
    val y: Double
    val z: Double

    val yaw: Float
    val pitch: Float

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IPlayerPositionAndLookOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Player Teleport | X: $x | Y: $y | Z: $z | Yaw: $yaw | Pitch: $pitch"
    }

    private open class StubPlayerPositionAndLookOutgoingPacket : IPlayerPositionAndLookOutgoingPacket
    {
        override val x: Double
            get() = throw UnsupportedOperationException()
        override val y: Double
            get() = throw UnsupportedOperationException()
        override val z: Double
            get() = throw UnsupportedOperationException()

        override val yaw: Float
            get() = throw UnsupportedOperationException()
        override val pitch: Float
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun newInstance(x: Double, y: Double, z: Double): IMinecraftOutgoingPacket = object : StubPlayerPositionAndLookOutgoingPacket()
        {
            override val x: Double
                get() = x
            override val y: Double
                get() = y
            override val z: Double
                get() = z
        }
    }
}