package eddxample.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.PistonBlockEntity;
import net.minecraft.class_4623;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonBlockEntity.class)
public abstract class PistonBlockEntityMixin {
    @Shadow private BlockState pushedBlock;

    @Redirect(method = "pushEntities", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/class_4623;method_23362(Lnet/minecraft/util/math/Box;Lnet/minecraft/util/math/Direction;D)Lnet/minecraft/util/math/Box;"
    ))
    private Box extendMore(Box box_1, Direction direction_1, double double_1) {
        Box ret = class_4623.method_23362(box_1, direction_1, double_1);
        if (pushedBlock.getBlock() == Blocks.HONEY_BLOCK) return ret.expand(1);
        return ret;
    }
}