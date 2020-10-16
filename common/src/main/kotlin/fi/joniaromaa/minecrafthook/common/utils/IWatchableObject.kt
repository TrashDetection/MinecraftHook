package fi.joniaromaa.minecrafthook.common.utils

interface IWatchableObject
{
    val dataValueId: Int
    val watchedObject: Any?

    fun asString(): String
    {
        return String.format("%d=%s", dataValueId, watchedObject)
    }
}