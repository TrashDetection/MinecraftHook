package fi.joniaromaa.minecrafthook.common.utils

interface IGamemode
{
    val isSurvivalOrAdventure: Boolean
    val isCreative: Boolean
    val isSpectator: Boolean

    enum class Type
    {
        SURVIVAL, CREATIVE, ADVENTURE, SPECTATOR;

        val stubGamemode: IGamemode

        companion object
        {
            private val VALUES = values()

            @JvmStatic
            fun valueOf(value: Int): Type
            {
                return VALUES[value]
            }
        }

        init
        {
            stubGamemode = StubGamemode(this)
        }
    }

    private class StubGamemode(private val type: Type) : IGamemode
    {
        override val isSurvivalOrAdventure: Boolean
            get() = type == Type.SURVIVAL || type == Type.ADVENTURE

        override val isCreative: Boolean
            get() = type == Type.CREATIVE

        override val isSpectator: Boolean
            get() = type == Type.SPECTATOR
    }
}