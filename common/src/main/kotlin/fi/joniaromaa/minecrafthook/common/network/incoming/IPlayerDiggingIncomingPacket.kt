package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IFacing
import fi.joniaromaa.minecrafthook.common.utils.IPos

interface IPlayerDiggingIncomingPacket : IMinecraftIncomingPacket
{
    val action: Action
    val position: IPos
    val facing: IFacing

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IPlayerDiggingIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Digging | Action: $action | Pos: $position | Facing: $facing";
    }

    enum class Action
    {
        START_DESTROY_BLOCK,
        ABORT_DESTROY_BLOCK,
        STOP_DESTROY_BLOCK,
        DROP_ALL_ITEMS,
        DROP_ITEM,
        RELEASE_USE_ITEM
    }

    private open class StubPlayerDiggingIncomingPacket : IPlayerDiggingIncomingPacket
    {
        override val position: IPos
            get() = throw UnsupportedOperationException()
        override val facing: IFacing
            get() = throw UnsupportedOperationException()
        override val action: Action
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun action(action: Action): IPlayerDiggingIncomingPacket = object : StubPlayerDiggingIncomingPacket()
        {
            override val action: Action
                get() = action
        }
    }
}