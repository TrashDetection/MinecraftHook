package fi.joniaromaa.minecrafthook.common

import fi.joniaromaa.minecrafthook.common.game.IGameHook
import fi.joniaromaa.minecrafthook.common.network.INetworkHook

interface IMinecraftHook
{
    val version: IMinecraftVersion

    val networkHook: INetworkHook;
    val gameHook: IGameHook;
}