package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.network.IPacketBuffer
import fi.joniaromaa.minecrafthook.common.network.shared.IPluginMessagePacket
import io.netty.util.CharsetUtil

interface IPluginMessageOutgoingPacket : IMinecraftOutgoingPacket
{
    val channel: String
    val data: IPacketBuffer
    val dataObject: Any?

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IPluginMessageOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        if (dataObject == null)
        {
            val buffer = ByteArray(data.buffer.writerIndex())

            data.buffer.getBytes(0, buffer)

            return "Plugin Message | Channel: $channel | Raw: ${String(buffer, CharsetUtil.UTF_8)}"
        }
        else
        {
            return "Plugin Message | $dataObject"
        }
    }

    companion object
    {
        @JvmStatic
        fun buildDataObject(channel: String, data: IPacketBuffer): Any?
        {
            return IPluginMessagePacket.Companion.buildDataObject(channel, data)
        }
    }
}