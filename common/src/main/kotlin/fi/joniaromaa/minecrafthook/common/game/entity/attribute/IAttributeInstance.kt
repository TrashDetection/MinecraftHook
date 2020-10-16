package fi.joniaromaa.minecrafthook.common.game.entity.attribute

interface IAttributeInstance
{
    val value: Double

    fun setBaseValue(value: Double)

    fun hasModifier(modifier: IAttributeModifier): Boolean
    fun removeModifier(modifier: IAttributeModifier)
    fun applyModifier(modifier: IAttributeModifier)

    fun removeAllModifiers()
}