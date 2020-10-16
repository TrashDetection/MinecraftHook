package fi.joniaromaa.minecrafthook.fabric1_16.mixins.hooks;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaa.minecrafthook.common.IMinecraftVersion;
import net.minecraft.MinecraftVersion;

@Mixin(MinecraftVersion.class)
public abstract class MixinMinecraftVersion_Hooks implements IMinecraftVersion
{
	@Shadow @Final private String name;
	@Shadow @Final private int protocolVersion;
    
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public int getProtocolVersion()
	{
		return this.protocolVersion;
	}
}
