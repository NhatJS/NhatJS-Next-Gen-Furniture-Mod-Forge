package net.nhatjs.nextgen_furniture.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nhatjs.nextgen_furniture.entity.ModEntities;
import net.nhatjs.nextgen_furniture.entity.client.ChairBlockEntity;

import java.util.List;


public class SofaBlock extends Block {
    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<Part> PART = EnumProperty.create("part", Part.class);

    private final DyeColor color;

    public SofaBlock(DyeColor color, Properties settings)
    {
        super(settings);
        this.color = color;
    }

    public DyeColor getColor()
    {
        return this.color;
    }

    public enum Part implements StringRepresentable
    {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right");

        private final String name;

        Part(String name)
        {
            this.name = name;
        }

        @Override
        public String getSerializedName()
        {
            return this.name;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(DIRECTION)) {
            default -> Block.box(0, 1, 0, 16, 7.525, 16);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DIRECTION, PART);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction facing = ctx.getHorizontalDirection();
        BlockState state = this.defaultBlockState().setValue(DIRECTION, facing);
        if(state != null)
        {
            return state.setValue(PART, this.getShape(state, ctx.getLevel(), ctx.getClickedPos()));
        }
        return null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos)
    {
        return state.setValue(PART, this.getShape(state, level, pos));
    }

    public Part getShape(BlockState state, LevelAccessor level, BlockPos pos)
    {
        Direction facing = state.getValue(DIRECTION);
        Direction front = this.getSofaState(level, pos, facing.getOpposite());
        if(front != null)
        {
            if(front == facing.getClockWise())
            {
                return Part.CORNER_RIGHT;
            }
            else if(front == facing.getCounterClockWise())
            {
                return Part.CORNER_LEFT;
            }
        }
        boolean left = this.isConnectable(level, pos, facing, facing.getCounterClockWise());
        boolean right = this.isConnectable(level, pos, facing, facing.getClockWise());
        if(left && right)
        {
            return Part.MIDDLE;
        }
        else if(left)
        {
            return Part.RIGHT;
        }
        else if(right)
        {
            return Part.LEFT;
        }
        return Part.SINGLE;
    }

    private Direction getSofaState(LevelAccessor level, BlockPos pos, Direction side)
    {
        BlockState relativeState = level.getBlockState(pos.relative(side));
        return relativeState.getBlock() instanceof SofaBlock ? relativeState.getValue(DIRECTION) : null;
    }

    private boolean isConnectable(LevelAccessor level, BlockPos pos, Direction facing, Direction offset)
    {
        BlockPos relativePos = pos.relative(offset);
        BlockState relativeState = level.getBlockState(pos.relative(offset));
        if(relativeState.getBlock() instanceof SofaBlock)
        {
            Direction other = relativeState.getValue(DIRECTION);
            return other == facing || other == offset;
        }
        return relativeState.isFaceSturdy(level, relativePos, offset.getOpposite());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return ChairBlockEntity.create(level, pos, 0.5, player, state.getValue(DIRECTION));
    }
}
