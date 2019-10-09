package eddxample.mixin;

import eddxample.Utils;
import net.minecraft.block.BlockState;
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
    private static void ignoreStickyBlock(BlockState state, World world, BlockPos pos, Direction moveDir, boolean flag, Direction side, CallbackInfoReturnable<Boolean> cir) {
        if (side.getOpposite() != moveDir) return;
        if (!Utils.sticksToBlock(world, pos, moveDir)) {
            cir.setReturnValue(false);
        }
    }
}
