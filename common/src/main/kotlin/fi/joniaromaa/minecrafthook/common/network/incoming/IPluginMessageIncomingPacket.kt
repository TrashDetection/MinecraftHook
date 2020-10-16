package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IPacketBuffer
import fi.joniaromaa.minecrafthook.common.network.shared.IPluginMessagePacket
import io.netty.util.CharsetUtil

interface IPluginMessageIncomingPacket : IMinecraftIncomingPacket
{
    val channel: String
    val data: IPacketBuffer

    val dataObject: Any?

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IPluginMessageIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        if (this.dataObject == null)
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

    class DebugEntityMove(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        val x: Double = data.readDouble()
        val y: Double = data.readDouble()
        val z: Double = data.readDouble()

        val serverX: Double = data.readDouble()
        val serverY: Double = data.readDouble()
        val serverZ: Double = data.readDouble()

        override fun toString(): String
        {
            return "Debug Entity Move | Entity Id: $entityId | X: $x | Y: $y | Z: $z | Server X: $serverX | Server Y: $serverY | Server Z: $serverZ"
        }
    }

    class DebugEntityOops(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        val x: Double = data.readDouble()
        val y: Double = data.readDouble()
        val z: Double = data.readDouble()

        val serverX: Double = data.readDouble()
        val serverY: Double = data.readDouble()
        val serverZ: Double = data.readDouble()

        override fun toString(): String
        {
            return "Debug Entity Oops | Entity Id: $entityId | X: $x | Y: $y | Z: $z | Server X: $serverX | Server Y: $serverY | Server Z: $serverZ"
        }
    }

    class DebugEntityAttack(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        val x: Double = data.readDouble()
        val y: Double = data.readDouble()
        val z: Double = data.readDouble()

        val serverX: Double = data.readDouble()
        val serverY: Double = data.readDouble()
        val serverZ: Double = data.readDouble()

        val playerX: Double = data.readDouble()
        val playerY: Double = data.readDouble()
        val playerZ: Double = data.readDouble()

        val playerPitch: Float = data.readFloat()
        val playerYaw: Float = data.readFloat()

        override fun toString(): String
        {
            return "Debug Entity Attack | Entity Id: $entityId | X: $x | Y: $y | Z: $z | Server X: $serverX | Server Y: $serverY | Server Z: $serverZ | Player X: $playerX | Player Y: $playerY | Player Z: $playerZ | Yaw: $playerYaw | Pitch: $playerPitch"
        }
    }

    class DebugSPPreUpdate(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        override fun toString(): String
        {
            return "SP Pre Update | Entity Id: $entityId"
        }
    }

    class DebugSPUpdate(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        override fun toString(): String
        {
            return "SP Update | Entity Id: $entityId"
        }
    }

    class DebugSPMove(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        val x: Double = data.readDouble()
        val y: Double = data.readDouble()
        val z: Double = data.readDouble()

        override fun toString(): String
        {
            return "SP Move | Entity Id: $entityId | X: $x | Y: $y | Z: $z"
        }
    }

    class DebugSPMoveFlying(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        val strafe: Float = data.readFloat()
        val forward: Float = data.readFloat()
        val friction: Float = data.readFloat()

        val sprinting: Boolean = data.readBoolean()

        override fun toString(): String
        {
            return "SP Move Flying | Entity Id: $entityId | Strafe: $strafe | Forward: $forward | Friction: $friction | Sprinting: $sprinting"
        }
    }

    class DebugSPMoveFlyingAdd(data: IPacketBuffer)
    {
        val entityId: Int = data.readVarInt()

        val x: Double = data.readDouble()
        val z: Double = data.readDouble()

        override fun toString(): String
        {
            return "SP Move Add | Entity Id: $entityId | X: $x | Z: $z"
        }
    }

    companion object
    {
        @JvmStatic
        fun buildDataObject(channel: String, data: IPacketBuffer): Any?
        {
            when (channel)
            {
                "td:debug" ->
                {
                    val id: Int = data.readVarInt()
                    when (id)
                    {
                        0 -> return DebugEntityMove(data)
                        1 -> return DebugEntityOops(data)
                        2 -> return DebugEntityAttack(data)
                        3 -> return DebugSPPreUpdate(data)
                        4 -> return DebugSPUpdate(data)
                        5 -> return DebugSPMove(data)
                        6 -> return DebugSPMoveFlying(data)
                        7 -> return DebugSPMoveFlyingAdd(data)
                    }
                }
            }

            return IPluginMessagePacket.buildDataObject(channel, data)
        }
    }
}