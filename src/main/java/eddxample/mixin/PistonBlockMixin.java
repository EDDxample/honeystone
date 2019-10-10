package eddxample.mixin;

import eddxample.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PistonBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonBlock.class)
public class PistonBlockMixin {
    @Inject(method = "isMovable", at = @At("HEAD"), cancellable = true)
    private static void ignoreStickyBlock(BlockState state, World world, BlockPos pos, Direction direction_1, boolean flag, Direction direction_2, CallbackInfoReturnable<Boolean> cir)
    {
        if (direction_1 != direction_2)
        {
            Block block = state.getBlock();
            if (block != Blocks.HONEY_BLOCK && block != Blocks.SLIME_BLOCK) return;
            Block otherBlock = world.getBlockState(pos.method_10079(direction_2.getOpposite(),1)).getBlock();
            if (otherBlock != Blocks.HONEY_BLOCK && otherBlock != Blocks.SLIME_BLOCK) return;
            cir.setReturnValue(block == otherBlock);
        }
    }
}
