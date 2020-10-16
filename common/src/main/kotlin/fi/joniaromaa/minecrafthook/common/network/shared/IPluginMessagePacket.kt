package fi.joniaromaa.minecrafthook.common.network.shared

import fi.joniaromaa.minecrafthook.common.network.IPacketBuffer
import fi.joniaromaa.minecrafthook.common.network.shared.IPluginMessagePacket.ForgeCodec.DimensionRegisterMessage
import fi.joniaromaa.minecrafthook.common.network.shared.IPluginMessagePacket.ForgeCodec.FluidIdMapMessage
import fi.joniaromaa.minecrafthook.common.network.shared.IPluginMessagePacket.ForgeHandshake.*
import java.util.*

interface IPluginMessagePacket
{
    class ForgeHandshake
    {
        class ServerHello(data: IPacketBuffer)
        {
            val protocolVersion: Byte = data.readByte()

            val overrideDimension = if (protocolVersion > 1) data.readInt() else 0;

            override fun toString(): String
            {
                return "Forge Server Hello | Protocol Version: $protocolVersion | Override Dimension: $overrideDimension"
            }
        }

        class ClientHello(data: IPacketBuffer)
        {
            val protocolVersion: Byte = data.readByte()

            override fun toString(): String
            {
                return "Forge Client Hello | Protocol Version: $protocolVersion"
            }
        }

        class ModList(data: IPacketBuffer)
        {
            val mods: MutableMap<String, String> = readStringStringMap(data)

            override fun toString(): String
            {
                return "Forge Mod List | Mods: $mods"
            }
        }

        class RegistryData(data: IPacketBuffer)
        {
            val hasMore: Boolean = data.readBoolean()

            val name: String = data.readString()

            val ids: MutableMap<String, Int> = IPluginMessagePacket.readIntStringMap(data)
            val substitutions: MutableSet<String> = IPluginMessagePacket.readStringSet(data)
            var dummied: MutableSet<String> = if (data.buffer.isReadable) IPluginMessagePacket.readStringSet(data) else HashSet()

            override fun toString(): String
            {
                return "Forge Registry Data | Has More: $hasMore | Name: $name | Ids: $ids | Substitutions: $substitutions | Dummied: $dummied"
            }
        }

        class HandshakeAck(data: IPacketBuffer)
        {
            val phase: Byte = data.readByte()

            override fun toString(): String
            {
                return String.format("Forge Handshake Ack | Phase: %d", phase)
            }
        }

        class HandshakeReset(data: IPacketBuffer)
        {
            override fun toString(): String
            {
                return "Forge Handshake Reset"
            }
        }
    }

    class ForgeCodec
    {
        class DimensionRegisterMessage(data: IPacketBuffer)
        class FluidIdMapMessage(data: IPacketBuffer)
    }

    companion object
    {
        @JvmStatic
        fun buildDataObject(channel: String, data: IPacketBuffer): Any?
        {
            when (channel)
            {
                "FML|HS" ->
                {
                    val id: Byte = data.readByte()
                    when (id)
                    {
                        0.toByte() -> return ServerHello(data)
                        1.toByte() -> return ClientHello(data)
                        2.toByte() -> return ModList(data)
                        3.toByte() -> return RegistryData(data)
                        (-1).toByte() -> return HandshakeAck(data)
                        (-2).toByte() -> return HandshakeReset(data)
                    }
                }
                "FORGE" ->
                {
                    val id = data.readByte()
                    when (id)
                    {
                        1.toByte() -> return DimensionRegisterMessage(data)
                        2.toByte() -> return FluidIdMapMessage(data)
                    }
                }
            }

            return null
        }

        private fun readStringStringMap(data: IPacketBuffer): MutableMap<String, String>
        {
            val count: Int = data.readInt()
            val values: MutableMap<String, String> = HashMap(count)
            for (i in 0 until count)
            {
                values[data.readString()] = data.readString()
            }

            return values
        }

        private fun readIntStringMap(data: IPacketBuffer): MutableMap<String, Int>
        {
            val count: Int = data.readInt()
            val values: MutableMap<String, Int> = HashMap(count)
            for (i in 0 until count)
            {
                values[data.readString()] = data.readVarInt()
            }

            return values
        }

        private fun readStringSet(data: IPacketBuffer): MutableSet<String>
        {
            val count: Int = data.readInt()
            val values: MutableSet<String> = HashSet(count)
            for (i in 0 until count)
            {
                values.add(data.readString())
            }

            return values
        }
    }
}