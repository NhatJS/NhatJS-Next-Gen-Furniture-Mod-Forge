package net.nhatjs.nextgen_furniture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.swing.text.html.BlockView;

public class LaptopBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty OPEN_STAGE = IntegerProperty.create("open_stage", 0, 8);
    public static final BooleanProperty OPEN_TARGET = BooleanProperty.create("open_target");
    public static final IntegerProperty BOOT_STAGE = IntegerProperty.create("boot_stage", 0, 5);
    public static final BooleanProperty SCREEN_ON = BooleanProperty.create("screen_on");

    public LaptopBlock(Properties props) {
        super(props);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN_STAGE, 0)
                .setValue(OPEN_TARGET, false)
                .setValue(BOOT_STAGE, 0)
                .setValue(SCREEN_ON, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> box(2, 0, 2, 14, 2, 14);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(FACING, OPEN_STAGE, OPEN_TARGET, BOOT_STAGE, SCREEN_ON);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState s, Rotation r) { return s.setValue(FACING, r.rotate(s.getValue(FACING))); }
    @Override
    public BlockState mirror(BlockState s, Mirror m) { return s.rotate(m.getRotation(s.getValue(FACING))); }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        int stage = state.getValue(OPEN_STAGE);
        boolean screenOn = state.getValue(SCREEN_ON);

        if (player.isShiftKeyDown()) {
            if (stage == 0) {
                level.setBlock(pos, state.setValue(OPEN_TARGET, true), Block.UPDATE_ALL);
                schedule(level, pos, 2);
            } else if ((stage == 7 || stage == 8) && !screenOn) {
                level.setBlock(pos, state.setValue(OPEN_TARGET, false), Block.UPDATE_ALL);
                schedule(level, pos, 2);
            }
            return InteractionResult.CONSUME;
        }

        if (stage == 7) {
            level.setBlock(pos, state.setValue(OPEN_STAGE, 8).setValue(BOOT_STAGE, 0).setValue(SCREEN_ON, false), Block.UPDATE_ALL);
            schedule(level, pos, 10);
            return InteractionResult.CONSUME;
        }
        if (stage == 8) {
            if (screenOn) {
                level.setBlock(pos, state.setValue(SCREEN_ON, false).setValue(BOOT_STAGE, 0), Block.UPDATE_ALL);
            } else {
                level.setBlock(pos, state.setValue(BOOT_STAGE, 0), Block.UPDATE_ALL);
                schedule(level, pos, 10);
            }
            return InteractionResult.CONSUME;
        }

        return InteractionResult.CONSUME;
    }

    private static void schedule(Level level, BlockPos pos, int delay) {
        if (level instanceof ServerLevel sl) sl.scheduleTick(pos, sl.getBlockState(pos).getBlock(), delay);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        int stage = state.getValue(OPEN_STAGE);
        boolean wantOpen = state.getValue(OPEN_TARGET);

        if ((wantOpen && stage < 7) || (!wantOpen && stage > 0)) {
            int next = wantOpen ? stage + 1 : stage - 1;
            level.setBlock(pos, state.setValue(OPEN_STAGE, next), Block.UPDATE_ALL);
            schedule(level, pos, 1);
            return;
        }

        if (stage == 8 && !state.getValue(SCREEN_ON)) {
            int boot = state.getValue(BOOT_STAGE);
            if (boot < 5) {
                level.setBlock(pos, state.setValue(BOOT_STAGE, boot + 1), Block.UPDATE_ALL);
                schedule(level, pos, 20);
            } else {
                level.setBlock(pos, state.setValue(SCREEN_ON, true).setValue(BOOT_STAGE, 0), Block.UPDATE_ALL);
            }
        }
    }
}
