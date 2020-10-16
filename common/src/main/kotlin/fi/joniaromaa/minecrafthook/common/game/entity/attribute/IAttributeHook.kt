package fi.joniaromaa.minecrafthook.common.game.entity.attribute

interface IAttributeHook
{
    val sharedMovementSpeedAttribute: IAttribute

    fun createAttributeMap(): IAttributeMap
}