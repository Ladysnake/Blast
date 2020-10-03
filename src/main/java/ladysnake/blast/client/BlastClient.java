package ladysnake.blast.client;

import ladysnake.blast.client.network.EntityDispatcher;
import ladysnake.blast.client.renderers.GunpowderBlockEntityRenderer;
import ladysnake.blast.common.init.BlastBlocks;
import ladysnake.blast.common.init.BlastEntities;
import ladysnake.blast.common.network.Packets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class BlastClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerRenders();
    }

    public static void registerRenders() {
        EntityRendererRegistry.INSTANCE.register(BlastEntities.BOMB, (manager, context) -> new FlyingItemEntityRenderer(manager, context.getItemRenderer()));
        EntityRendererRegistry.INSTANCE.register(BlastEntities.DIAMOND_BOMB, (manager, context) -> new FlyingItemEntityRenderer(manager, context.getItemRenderer()));
        EntityRendererRegistry.INSTANCE.register(BlastEntities.GOLDEN_BOMB, (manager, context) -> new FlyingItemEntityRenderer(manager, context.getItemRenderer()));
        EntityRendererRegistry.INSTANCE.register(BlastEntities.NAVAL_MINE, (manager, context) -> new FlyingItemEntityRenderer(manager, context.getItemRenderer()));
        EntityRendererRegistry.INSTANCE.register(BlastEntities.PULVERIS, (manager, context) -> new FlyingItemEntityRenderer(manager, context.getItemRenderer()));
        EntityRendererRegistry.INSTANCE.register(BlastEntities.GUNPOWDER_BLOCK, (manager, context) -> new GunpowderBlockEntityRenderer(manager));

        ClientSidePacketRegistry.INSTANCE.register(Packets.SPAWN, EntityDispatcher::spawnFrom);

        BlockRenderLayerMap.INSTANCE.putBlock(BlastBlocks.GUNPOWDER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlastBlocks.STRIPMINER, RenderLayer.getCutout());
    }

}
