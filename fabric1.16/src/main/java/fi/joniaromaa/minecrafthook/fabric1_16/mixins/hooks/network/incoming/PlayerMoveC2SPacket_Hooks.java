package fi.joniaromaa.minecrafthook.fabric1_16.mixins.hooks.network.incoming;

import fi.joniaromaa.minecrafthook.common.network.incoming.IPlayerIncomingPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerMoveC2SPacket.class)
public abstract class PlayerMoveC2SPacket_Hooks implements IPlayerIncomingPacket
{
    @Shadow protected double x;
    @Shadow protected double y;
    @Shadow protected double z;
    @Shadow protected float yaw;
    @Shadow protected float pitch;
    @Shadow protected boolean onGround;
    @Shadow protected boolean changePosition;
    @Shadow protected boolean changeLook;

    @Override
    public double getX()
    {
        return this.x;
    }

    @Override
    public double getY()
    {
        return this.y;
    }

    @Override
    public double getZ()
    {
        return this.z;
    }

    @Override
    public float getYaw()
    {
        return this.yaw;
    }

    @Override
    public float getPitch()
    {
        return this.pitch;
    }

    @Override
    public boolean isOnGround()
    {
        return this.onGround;
    }

    @Override
    public boolean isMoving()
    {
        return this.changePosition;
    }

    @Override
    public boolean isRotating()
    {
        return this.changeLook;
    }
}
