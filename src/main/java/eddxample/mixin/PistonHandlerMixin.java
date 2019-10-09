package eddxample.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(PistonHandler.class)
public abstract class PistonHandlerMixin {
    @Shadow @Final private World world;
    @Shadow protected abstract boolean tryMove(BlockPos blockPos_1, Direction direction_1);
    @Shadow private boolean method_23367(Block b) { return false; }


    @Redirect(method = "method_11538", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/piston/PistonHandler;tryMove(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)Z"))
    private boolean sticksToBlock(PistonHandler ph, BlockPos pos, Direction direction) {
        Block from = world.getBlockState(pos.offset(direction.getOpposite())).getBlock();
        Block to = world.getBlockState(pos).getBlock();
        if (from != to && method_23367(from) && method_23367(to)) return true;

        return tryMove(pos, direction);
    }

}
