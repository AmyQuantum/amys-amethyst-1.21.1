package net.amy.amythest.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import com.llamalad7.mixinextras.sugar.Local;
import net.amy.amythest.client.render.AmethystTridentItemRenderer;
import net.amy.amythest.item.ModItems;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import net.amy.amythest.client.render.AmethystTridentItemRenderer;
import static net.amy.amythest.item.ModItems.*;
import static net.minecraft.item.Items.TRIDENT;


@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @WrapOperation(
            method = {"getModel", "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"},
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean checkAmethystTrident(ItemStack instance, Item item, Operation<Boolean> original) {
        if (original.call(instance, item)) {
            return true;
        }
        if (item == TRIDENT) {
            return original.call(instance, AMETHYST_TRIDENT);
        }

        return false;





    }

    @ModifyExpressionValue(
            method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/item/ItemRenderer;TRIDENT:Lnet/minecraft/client/util/ModelIdentifier;"))
    private ModelIdentifier handler2(ModelIdentifier original, @Local()ItemStack itemStack) {
        return itemStack.isOf(AMETHYST_TRIDENT) ? AmethystTridentItemRenderer.AMETHYST_TRIDENT_MODEL_IDENTIFIER : original;
    }

}

/*@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Definition(id = "isOf", method = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    @Definition(id = "TRIDENT", field = "Lnet/minecraft/item/Items;TRIDENT:Lnet/minecraft/item/Item;")
    @Expression("?.isOf(TRIDENT)")
    @WrapOperation(method = {"getModel", "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"}, at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean checkModdedTrident(ItemStack instance, Item item, Operation<Boolean> original) {
        return original.call(instance, item) || original.call(instance, ModItems.AMETHYST_TRIDENT);
    }

    @ModifyExpressionValue(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/item/ItemRenderer;TRIDENT:Lnet/minecraft/client/util/ModelIdentifier;"))
    private ModelIdentifier getModdedTridentInventory(ModelIdentifier original, @Local(argsOnly = true) ItemStack stack) {
        return stack.isOf(ModItems.AMETHYST_TRIDENT) ? AmethystTridentItemRenderer.AMYTHEST_TRIDENT : original;
    }
}*/