package fi.joniaromaa.minecrafthook.common.network

import io.netty.buffer.ByteBuf

interface IPacketBuffer
{
    var buffer: ByteBuf

    fun readByte(): Byte
    fun readBoolean(): Boolean

    fun readVarInt(): Int

    fun readInt(): Int
    fun readFloat(): Float

    fun readDouble(): Double

    fun readString(maxLength: Int): String
    fun readString(): String
    {
        val max = Int.MAX_VALUE / 4

        return this.readString(max)
    }
}