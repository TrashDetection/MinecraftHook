package fi.joniaromaa.minecrafthook.common.game.entity.attribute

import java.util.*

interface IAttributeModifier
{
    val uniqueId: UUID
    val amount: Double
    val modifier: Modifier

    enum class Modifier
    {
        ADDITIVE,
        MULTIPLICATIVE_ADDITIVE,
        MULTIPLICATIVE_CURRENT
    }
}