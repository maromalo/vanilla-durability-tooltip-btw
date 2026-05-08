package ar.maro.vanilladurabilitytooltip.mixin;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackTooltipMixin {
    
    @Shadow
    public abstract boolean isItemStackDamageable();
    
    @Shadow
    public abstract int getMaxDamage();
    
    @Shadow
    public abstract int getItemDamage();
    
    @Inject(method = "getTooltip", at = @At("RETURN"))
    private void addDurabilityTooltip(EntityPlayer par1EntityPlayer, boolean par2, CallbackInfoReturnable<List> cir) {
        if (this.isItemStackDamageable()) {
            List<String> tooltip = cir.getReturnValue();
            int durabilityRemaining = this.getMaxDamage() - this.getItemDamage();
            int maxDurability = this.getMaxDamage();
            tooltip.add("Durability: " + durabilityRemaining + " / " + maxDurability);
        }
    }
}
