package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IChunkOutgoingPacket : IMinecraftOutgoingPacket
{
    val chunkX: Int
    val chunkZ: Int

    val isFullChunk: Boolean
    val extractedDataLength: Int

    val chunkPair: Long
        get() = chunkX.toLong() and 4294967295L or (chunkZ.toLong() and 4294967295L) shl 32

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IChunkOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Chunk | X: $chunkX | Z: $chunkZ | Full: $isFullChunk | Data Length: $extractedDataLength"
    }

    private open class StubChunkOutgoingPacket : IChunkOutgoingPacket
    {
        override val chunkX: Int
            get() = throw UnsupportedOperationException()
        override val chunkZ: Int
            get() = throw UnsupportedOperationException()

        override val isFullChunk: Boolean
            get() = throw UnsupportedOperationException()
        override val extractedDataLength: Int
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun chunkUnload(x: Int, z: Int): IChunkOutgoingPacket = object : StubChunkOutgoingPacket()
        {
            override val chunkX: Int
                get() = x
            override val chunkZ: Int
                get() = z

            override val isFullChunk: Boolean
                get() = true
            override val extractedDataLength: Int
                get() = 0
        }
    }
}