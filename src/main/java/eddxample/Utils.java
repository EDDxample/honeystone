package eddxample;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Utils {
    public static boolean isStickyBlock(Block block) {
        return block == Blocks.SLIME_BLOCK || block == Blocks.HONEY_BLOCK;
    }

    public static boolean sticksToBlock(World world, BlockPos stickyPos, Direction side) {
        Block selfBlock = world.getBlockState(stickyPos).getBlock();
        Block otherBlock = world.getBlockState(stickyPos.offset(side)).getBlock();
        return !(selfBlock != otherBlock && isStickyBlock(selfBlock) && isStickyBlock(otherBlock));
    }
}
