package fi.joniaromaa.minecrafthook.forge1_8;

import fi.joniaromaa.minecrafthook.common.IMinecraftHook;
import fi.joniaromaa.minecrafthook.common.IMinecraftVersion;
import net.minecraft.realms.RealmsSharedConstants;

public final class MinecraftHook implements IMinecraftHook
{
	private MinecraftHook()
	{
	}
	
	@Override
	public IMinecraftVersion getVersion()
	{
		return MinecraftVersion.INSTANCE;
	}

	public static MinecraftHook build()
	{
		return new MinecraftHook();
	}
	
	private static final class MinecraftVersion implements IMinecraftVersion
	{
		static final MinecraftVersion INSTANCE = new MinecraftVersion();
		
		@Override
		public String getName()
		{
			return RealmsSharedConstants.VERSION_STRING;
		}

		@Override
		public int getProtocolVersion()
		{
			return RealmsSharedConstants.NETWORK_PROTOCOL_VERSION;
		}
	}
}
