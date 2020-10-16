package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IConfirmTransactionIncomingPacket : IMinecraftIncomingPacket
{
    val windowId: Byte
    val actionNumber: Short

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IConfirmTransactionIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Confirm Transaction | Window Id: $windowId | Action Number: $actionNumber"
    }

    private open class StubConfirmTransactionIncomingPacket : IConfirmTransactionIncomingPacket
    {
        override val windowId: Byte
            get() = throw UnsupportedOperationException()
        override val actionNumber: Short
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        const val CONFIRM_TRANSACTION_PREV_ID: Short = -5
        const val CONFIRM_TRANSACTION_ID: Short = -3

        @JvmStatic
        fun newPreConfirmInstance(): IConfirmTransactionIncomingPacket = object : StubConfirmTransactionIncomingPacket()
        {
            override val windowId: Byte
                get() = IClickWindowIncomingPacket.PLAYER_INVENTORY_ID.toByte()

            override val actionNumber: Short
                get() = CONFIRM_TRANSACTION_PREV_ID
        }

        @JvmStatic
        fun newConfirmInstance(): IConfirmTransactionIncomingPacket = object : StubConfirmTransactionIncomingPacket()
        {
            override val windowId: Byte
                get() = IClickWindowIncomingPacket.PLAYER_INVENTORY_ID.toByte()

            override val actionNumber: Short
                get() = CONFIRM_TRANSACTION_ID
        }
    }
}