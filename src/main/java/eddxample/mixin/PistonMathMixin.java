package eddxample.mixin;

import net.minecraft.class_4623;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(class_4623.class)
public class PistonMathMixin {
    @Inject(method = "method_23363", at = @At("RETURN"))
    private static List<Box> growAABB(boolean bl, Box box, Direction dir, double d, CallbackInfoReturnable<List<Box>> cir) {
        List<Box> out = cir.getReturnValue();
        if (bl) out.add(box.expand(0.1));
        return out;
    }
}
