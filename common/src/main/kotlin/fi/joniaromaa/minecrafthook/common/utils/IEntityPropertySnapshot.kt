package fi.joniaromaa.minecrafthook.common.utils

import fi.joniaromaa.minecrafthook.common.game.entity.attribute.IAttributeModifier

interface IEntityPropertySnapshot
{
    val name: String
    val initialValue: Double
    val modifiers: Collection<IAttributeModifier>
}