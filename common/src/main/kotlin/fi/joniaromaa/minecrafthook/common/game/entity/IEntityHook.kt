package fi.joniaromaa.minecrafthook.common.game.entity

import fi.joniaromaa.minecrafthook.common.game.entity.attribute.IAttributeHook
import fi.joniaromaa.minecrafthook.common.game.entity.attribute.IAttributeModifier

interface IEntityHook
{
    val attributeHook: IAttributeHook
    val sprintingSpeedBoostModifier: IAttributeModifier
}