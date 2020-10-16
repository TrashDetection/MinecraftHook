package fi.joniaromaa.minecrafthook.fabric1_16;

import fi.joniaromaa.minecrafthook.common.IMinecraftHook;
import fi.joniaromaa.minecrafthook.common.IMinecraftVersion;
import fi.joniaromaa.minecrafthook.common.game.IGameHook;
import fi.joniaromaa.minecrafthook.common.network.INetworkHook;
import fi.joniaromaa.minecrafthook.fabric1_16.network.NetworkHook;
import net.minecraft.SharedConstants;
import org.jetbrains.annotations.NotNull;

public final class MinecraftHook implements IMinecraftHook
{
	private final NetworkHook networkHook;

	private MinecraftHook()
	{
		this.networkHook = new NetworkHook();
	}
	
	@Override
	public IMinecraftVersion getVersion()
	{
		return (IMinecraftVersion)SharedConstants.getGameVersion();
	}

	@NotNull
	@Override
	public INetworkHook getNetworkHook()
	{
		return this.networkHook;
	}

	@NotNull
	@Override
	public IGameHook getGameHook()
	{
		return null;
	}

	public static MinecraftHook build()
	{
		return new MinecraftHook();
	}
}
