package net.nhatjs.nextgen_furniture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.network.syncher.EntityDataSerializers.DIRECTION;

public class ChairBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ChairBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Block.box(3, 0, 2.25, 13, 10.65, 13.75);
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;
        if (level.isClientSide) return InteractionResult.sidedSuccess(true);

        if (player.isPassenger() || player.isSecondaryUseActive()) {
            return InteractionResult.CONSUME;
        }

        AABB box = new AABB(pos).inflate(0.25D);
        List<ChairBlockEntity> seats = level.getEntitiesOfClass(ChairBlockEntity.class, box, Entity::isAlive);

        ChairBlockEntity seat;
        if (seats.isEmpty()) {
            seat = ModEntities.CHAIR.get().create(level);
            if (seat == null) return InteractionResult.CONSUME;

            double seatY = 0.05D;
            Vec3 center = Vec3.atBottomCenterOf(pos).add(0.0D, seatY, 0.0D);

            float yaw = 0f;
            if (state.hasProperty(HorizontalDirectionalBlock.FACING)) {
                yaw = state.getValue(HorizontalDirectionalBlock.FACING).toYRot();
            }
            seat.moveTo(center.x, center.y, center.z, yaw, 0.0F);

            seat.setLockYaw(true);

            level.addFreshEntity(seat);
        } else {
            seat = seats.get(0);
        }

        player.startRiding(seat, true);

        return InteractionResult.CONSUME;
    }
}
