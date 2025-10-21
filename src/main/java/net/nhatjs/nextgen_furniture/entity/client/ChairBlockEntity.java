package net.nhatjs.nextgen_furniture.entity.client;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.nhatjs.nextgen_furniture.entity.ModEntities;

import java.util.List;

public class ChairBlockEntity extends Entity {
    public ChairBlockEntity(Level pLevel) {
        super(ModEntities.CHAIR.get(), pLevel);
    }

    private ChairBlockEntity(Level level, BlockPos source, double yOffset, Direction direction)
    {
        this(level);
        this.setPos(source.getX() + 0.5, source.getY() + yOffset, source.getZ() + 0.5);
        this.setRot(direction.getOpposite().toYRot(), 0F);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        this.kill();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide)
        {
            BlockPos pos = this.blockPosition();
            if (this.getPassengers().isEmpty() || this.level().isEmptyBlock(pos)) {
                this.discard();
                this.level().updateNeighbourForOutputSignal(pos, this.level().getBlockState(pos).getBlock());
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    public void remove(RemovalReason reason) {
        if (!this.level().isClientSide) {
            if (this.isVehicle()) this.getPassengers().forEach(p -> p.stopRiding());
            this.ejectPassengers();
        }
        super.remove(reason);
    }

    public static InteractionResult create(Level level, BlockPos pos, double yOffset, Player player, Direction direction)
    {
        if(!level.isClientSide())
        {
            List<ChairBlockEntity> seats = level.getEntitiesOfClass(ChairBlockEntity.class, new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));
            if(seats.isEmpty())
            {
                ChairBlockEntity seat = new ChairBlockEntity(level, pos, yOffset, direction);
                level.addFreshEntity(seat);
                player.startRiding(seat, false);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
