package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.game.item.IItemStack
import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket

interface IClickWindowIncomingPacket : IMinecraftIncomingPacket
{
    val windowId: Byte
    val slot: Short
    val mode: Mode
    val button: Byte
    val actionNumber: Short

    val item: IItemStack

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IClickWindowIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Click Window | Window Id: $windowId | Slot: $slot | Mode: $mode | Button: $button | Action Number: $actionNumber | Item: $item";
    }

    enum class Mode
    {
        CLICK,
        SHIFT_CLICK,
        HOTBAR,
        MIDDLE_CLICK,
        DROP,
        DRAG,
        DOUBLE_CLICK
    }

    companion object
    {
        const val PLAYER_INVENTORY_ID = 0
    }
}