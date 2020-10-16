package fi.joniaromaa.minecrafthook.common.game.item

interface IItemStack
{
    val itemId: Int
    val metadata: Int

    val isAir: Boolean

    private open class StubItemStack : IItemStack
    {
        override val itemId: Int
            get() = throw UnsupportedOperationException();

        override val metadata: Int
            get() = throw UnsupportedOperationException();

        override val isAir: Boolean
            get() = throw UnsupportedOperationException();
    }

    companion object
    {
        @JvmStatic
        fun item(itemId: Int): IItemStack = object : StubItemStack()
        {
            override val itemId: Int
                get() = itemId

            override val isAir: Boolean
                get() = false
        }

        @JvmStatic
        fun air(): IItemStack = object : StubItemStack()
        {
            override val isAir: Boolean
                get() = true
        }
    }
}