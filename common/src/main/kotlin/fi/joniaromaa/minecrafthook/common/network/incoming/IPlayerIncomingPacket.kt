package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IPlayerIncomingPacket : IMinecraftIncomingPacket
{
    val x: Double
    val y: Double
    val z: Double

    val yaw: Float
    val pitch: Float

    val isOnGround: Boolean
    val isMoving: Boolean
    val isRotating: Boolean

    @JvmDefault
    val chunkX: Int
        get() = x.toInt() shr 4

    @JvmDefault
    val chunkZ: Int
        get() = z.toInt() shr 4

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IPlayerIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        if (isMoving && isRotating)
        {
            return "Player | On Ground: $isOnGround | X: $x | Y: $y | Z: $z | Yaw: $yaw | Pitch: $pitch"
        }
        else if (isMoving)
        {
            return "Player | On Ground: $isOnGround | X: $x | Y: $y | Z: $z"
        }
        else if (isRotating)
        {
            return "Player | On Ground: $isOnGround | Yaw: $yaw | Pitch: $pitch"
        }
        else
        {
            return "Player | On Ground: $isOnGround";
        }
    }

    private open class StubPlayerIncomingPacket : IPlayerIncomingPacket
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

        override val isOnGround: Boolean
            get() = throw UnsupportedOperationException()
        override val isMoving: Boolean
            get() = throw UnsupportedOperationException()
        override val isRotating: Boolean
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun ground(): IPlayerIncomingPacket = object : StubPlayerIncomingPacket()
        {
            override val isOnGround: Boolean
                get() = true
            override val isMoving: Boolean
                get() = false
            override val isRotating: Boolean
                get() = false
        }

        @JvmStatic
        fun ground(x: Double, y: Double, z: Double): IPlayerIncomingPacket = object : StubPlayerIncomingPacket()
        {
            override val x: Double
                get() = x
            override val y: Double
                get() = y
            override val z: Double
                get() = z

            override val isOnGround: Boolean
                get() = true
            override val isMoving: Boolean
                get() = true
            override val isRotating: Boolean
                get() = false
        }

        @JvmStatic
        fun fly(x: Double, y: Double, z: Double): IPlayerIncomingPacket = object : StubPlayerIncomingPacket()
        {
            override val x: Double
                get() = x
            override val y: Double
                get() = y
            override val z: Double
                get() = z

            override val isOnGround: Boolean
                get() = false
            override val isMoving: Boolean
                get() = true
            override val isRotating: Boolean
                get() = false
        }
    }
}