package net.nhatjs.nextgen_furniture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ChairBlock extends Block {
    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty MOVE = BooleanProperty.create("move");

    public ChairBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(MOVE, false));
    }

    private static VoxelShape shapeFor(Direction d) {
        return switch (d) {
            default -> Block.box(3, 0, 2.25, 13, 10.65, 13.75);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return state.getValue(MOVE) ? Shapes.empty() : shapeFor(state.getValue(DIRECTION));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shapeFor(state.getValue(DIRECTION));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(DIRECTION, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, MOVE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        boolean move = state.getValue(MOVE);

        if (player.isShiftKeyDown()) {
            if (move == false) {
                level.setBlock(pos, state.setValue(MOVE, true), Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            if (move == true) {
                level.setBlock(pos, state.setValue(MOVE, false), Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.SUCCESS;
        }
        if (move == true) {
            return InteractionResult.SUCCESS;
        }
        return ChairBlockEntity.create(level, pos, 0.4, player, state.getValue(DIRECTION));
    }
}
