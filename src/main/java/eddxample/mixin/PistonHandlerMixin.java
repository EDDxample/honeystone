package eddxample.mixin;

import com.google.common.collect.Lists;
import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.enums.ChestType;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(PistonHandler.class)
public abstract class PistonHandlerMixin {
    @Shadow @Final private World world;
    @Shadow protected abstract boolean tryMove(BlockPos blockPos_1, Direction direction_1);
    @Shadow @Final private List<BlockPos> movedBlocks;
    @Shadow @Final private Direction direction;
    @Shadow @Final private List<BlockPos> brokenBlocks;
    @Shadow @Final private BlockPos posFrom;

}
