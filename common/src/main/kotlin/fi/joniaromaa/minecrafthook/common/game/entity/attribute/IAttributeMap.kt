package fi.joniaromaa.minecrafthook.common.game.entity.attribute

interface IAttributeMap
{
    fun registerAttribute(attribute: IAttribute): IAttributeInstance

    fun getAttributeInstance(attribute: IAttribute): IAttributeInstance
    fun getAttributeInstanceByName(name: String): IAttributeInstance
}