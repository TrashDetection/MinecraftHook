package fi.joniaromaa.minecrafthook.common.network.incoming

import fi.joniaromaa.minecrafthook.common.network.IMinecraftIncomingPacket
import fi.joniaromaa.minecrafthook.common.network.IMinecraftPacket
import fi.joniaromaa.minecrafthook.common.utils.IVectorPos

interface IUseEntityIncomingPacket : IMinecraftIncomingPacket
{
    val entityId: Int

    val action: Action
    val position: IVectorPos

    @JvmDefault
    override val baseType: Class<out IMinecraftIncomingPacket>
        get() = IUseEntityIncomingPacket::class.java

    @JvmDefault
    override fun asString(): String
    {
        if (action == Action.INTERACT_AT)
        {
            return "Use Entity | Entity Id: $entityId | Action: $action | Position: $position"
        }
        else
        {
            return "Use Entity | Entity Id: $entityId | Action: $action"
        }
    }

    enum class Action
    {
        INTERACT,
        ATTACK,
        INTERACT_AT
    }
}