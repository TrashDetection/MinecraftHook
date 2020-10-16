package fi.joniaromaa.minecrafthook.common.game

import fi.joniaromaa.minecrafthook.common.game.entity.IEntityHook
import fi.joniaromaa.minecrafthook.common.game.world.IWorldHook

interface IGameHook
{
    val entityHook: IEntityHook
    val worldHook: IWorldHook
}