package fi.joniaromaa.minecrafthook.common.network.outgoing

import fi.joniaromaa.minecrafthook.common.network.IMinecraftOutgoingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.network.incoming.IClickWindowIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.incoming.IConfirmTransactionIncomingPacket

interface IConfirmTransactionOutgoingPacket : IMinecraftOutgoingPacket
{
    val windowId: Byte
    val actionNumber: Short

    @JvmDefault
    override val baseType: Class<out IMinecraftOutgoingPacket>
        get() = IConfirmTransactionOutgoingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Confirm Transaction | Window Id: $windowId | Action Number: $actionNumber"
    }

    private open class StubConfirmTransactionOutgoingPacket : IConfirmTransactionOutgoingPacket
    {
        override val windowId: Byte
            get() = throw UnsupportedOperationException()
        override val actionNumber: Short
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun newPreConfirmInstance(): IConfirmTransactionOutgoingPacket = object : StubConfirmTransactionOutgoingPacket()
        {
            override val windowId: Byte
                get() = IClickWindowIncomingPacket.PLAYER_INVENTORY_ID.toByte()

            override val actionNumber: Short
                get() = IConfirmTransactionIncomingPacket.CONFIRM_TRANSACTION_PREV_ID
        }

        @JvmStatic
        fun newConfirmInstance(): IConfirmTransactionOutgoingPacket = object : StubConfirmTransactionOutgoingPacket()
        {
            override val windowId: Byte
                get() = IClickWindowIncomingPacket.PLAYER_INVENTORY_ID.toByte()

            override val actionNumber: Short
                get() = IConfirmTransactionIncomingPacket.CONFIRM_TRANSACTION_ID
        }
    }
}