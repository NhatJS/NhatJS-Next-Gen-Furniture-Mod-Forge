package net.nhatjs.nextgen_furniture.entity.client;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class ChairBlockEntity extends Entity {
    public ChairBlockEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {

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
    public void remove(RemovalReason reason) {
        if (!this.level().isClientSide) {
            if (this.isVehicle()) this.getPassengers().forEach(p -> p.stopRiding());
            this.ejectPassengers();
        }
        super.remove(reason);
    }

    public void setLockYaw(boolean b) {
    }
}
