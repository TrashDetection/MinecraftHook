package fi.joniaromaa.minecrafthook.common.network

import java.io.IOException
import kotlin.jvm.Throws

interface IMinecraftPacket
{
    @Throws(IOException::class)
    @JvmDefault
    fun readPacket(buffer: IPacketBuffer)
    {
        throw UnsupportedOperationException(this.javaClass.toString())
    }

    @JvmDefault
    val isAsync: Boolean
        get() = false

    @JvmDefault
    val baseType: Class<out IMinecraftPacket>
        get() = throw UnsupportedOperationException(this.javaClass.toString())

    @JvmDefault
    fun asString(): String = this.javaClass.toString()
}