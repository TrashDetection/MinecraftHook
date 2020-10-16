package fi.joniaromaa.minecrafthook.common.game.world

import fi.joniaromaa.minecrafthook.common.utils.IGamemode

interface IWorldHook
{
    fun getGamemode(type: IGamemode.Type): IGamemode
}