package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IBulkChunkOutgoingPacket : IMinecraftOutgoingPacket
{
    val count: Int

    val xPositions: IntArray
    val zPositions: IntArray

    fun getChunkX(i: Int): Int
    fun getChunkZ(i: Int): Int

    fun getChunkPair(i: Int): Long
    {
        return getChunkX(i).toLong() and 4294967295L or (getChunkZ(i).toLong() and 4294967295L) shl 32
    }

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IBulkChunkOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        val sb = StringBuilder()
        for (i in 0 until count)
        {
            if (i > 0) {
                sb.append(", ")
            }
            sb.append('(')
            sb.append(xPositions[i])
            sb.append(", ")
            sb.append(zPositions[i])
            sb.append(')')
        }

        return "Bulk Chunk | Pairs: ${sb.toString()}"
    }
}