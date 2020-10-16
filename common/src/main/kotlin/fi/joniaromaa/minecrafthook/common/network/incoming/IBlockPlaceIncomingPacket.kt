package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.game.item.IItemStack
import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IBlockPos
import fi.joniaromaa.minecrafthook.common.utils.IFacing

interface IBlockPlaceIncomingPacket : IMinecraftIncomingPacket
{
    val position: IBlockPos
    val facing: IFacing
    val item: IItemStack

    val facingX: Float
    val facingY: Float
    val facingZ: Float

    val isInteract: Boolean

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IBlockPlaceIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        if (!isInteract)
        {
            return "Block Place | Pos: $position | Facing: $facing | Facing X: $facingX | Facing Y: $facingY | Facing Z: $facingZ | Item: $item";
        }
        else
        {
            return "Item Interact | Pos: $position | Facing X: $facingX | Facing Y: $facingY | Facing Z: $facingZ | Item: $item";
        }
    }

    private open class StubBlockPlaceIncomingPacket : IBlockPlaceIncomingPacket
    {
        override val position: IBlockPos
            get() = throw UnsupportedOperationException();
        override val facing: IFacing
            get() = throw UnsupportedOperationException();
        override val item: IItemStack
            get() = throw UnsupportedOperationException();

        override val facingX: Float
            get() = throw UnsupportedOperationException();
        override val facingY: Float
            get() = throw UnsupportedOperationException();
        override val facingZ: Float
            get() = throw UnsupportedOperationException();

        override val isInteract: Boolean
            get() = throw UnsupportedOperationException();
    }

    companion object
    {
        @JvmStatic
        fun interact(item: IItemStack): IBlockPlaceIncomingPacket = object : StubBlockPlaceIncomingPacket()
        {
            override val item: IItemStack
                get() = item

            override val isInteract: Boolean
                get() = true
        }
    }
}