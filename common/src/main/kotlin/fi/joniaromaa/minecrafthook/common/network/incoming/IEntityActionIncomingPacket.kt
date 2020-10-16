package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket

interface IEntityActionIncomingPacket : IMinecraftIncomingPacket
{
    val entityId: Int
    val action: Action
    val auxData: Int

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IEntityActionIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        return "Entity Action | Entity Id: $entityId | Action: $action | Aux: $auxData"
    }

    enum class Action
    {
        START_SNEAKING,
        STOP_SNEAKING,
        STOP_SLEEPING,
        START_SPRINTING,
        STOP_SPRINTING,
        RIDING_JUMP,
        OPEN_INVENTORY
    }

    private open class StubEntityActionIncomingPacket : IEntityActionIncomingPacket
    {
        override val entityId: Int
            get() = throw UnsupportedOperationException()
        override val action: Action
            get() = throw UnsupportedOperationException()
        override val auxData: Int
            get() = throw UnsupportedOperationException()
    }

    companion object
    {
        @JvmStatic
        fun newInstance(action: Action): IEntityActionIncomingPacket = object : StubEntityActionIncomingPacket()
        {
            override val action: Action
                get() = action
        }
    }
}