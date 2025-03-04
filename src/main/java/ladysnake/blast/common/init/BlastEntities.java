package ladysnake.blast.common.init;

import ladysnake.blast.common.Blast;
import ladysnake.blast.common.entity.*;
import ladysnake.blast.common.entity.projectiles.AmethystShardEntity;
import ladysnake.blast.common.entity.projectiles.IcicleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlastEntities {

    public static EntityType<BombEntity> BOMB;
    public static EntityType<BombEntity> TRIGGER_BOMB;
    public static EntityType<BombEntity> GOLDEN_BOMB;
    public static EntityType<BombEntity> GOLDEN_TRIGGER_BOMB;
    public static EntityType<BombEntity> DIAMOND_BOMB;
    public static EntityType<BombEntity> DIAMOND_TRIGGER_BOMB;
    public static EntityType<BombEntity> NAVAL_MINE;
    public static EntityType<BombEntity> CONFETTI_BOMB;
    public static EntityType<BombEntity> CONFETTI_TRIGGER_BOMB;
    public static EntityType<BombEntity> DIRT_BOMB;
    public static EntityType<BombEntity> DIRT_TRIGGER_BOMB;
    public static EntityType<BombEntity> PEARL_BOMB;
    public static EntityType<BombEntity> PEARL_TRIGGER_BOMB;
    public static EntityType<BombEntity> SLIME_BOMB;
    public static EntityType<BombEntity> SLIME_TRIGGER_BOMB;
    public static EntityType<BombEntity> AMETHYST_BOMB;
    public static EntityType<BombEntity> AMETHYST_TRIGGER_BOMB;
    public static EntityType<BombEntity> FROST_BOMB;
    public static EntityType<BombEntity> FROST_TRIGGER_BOMB;
    public static EntityType<PipeBombEntity> PIPE_BOMB;

    public static EntityType<GunpowderBlockEntity> GUNPOWDER_BLOCK;
    public static EntityType<StripminerEntity> STRIPMINER;
    public static EntityType<ColdDiggerEntity> COLD_DIGGER;
    public static EntityType<BonesburrierEntity> BONESBURRIER;

    public static EntityType<AmethystShardEntity> AMETHYST_SHARD;
    public static EntityType<IcicleEntity> ICICLE;

    public static void init() {
        // throwable explosives
        BOMB = register("bomb", createBombEntityType(BombEntity::new));
        TRIGGER_BOMB = register("trigger_bomb", createBombEntityType(TriggerBombEntity::new));
        GOLDEN_BOMB = register("golden_bomb", createBombEntityType(GoldenBombEntity::new));
        GOLDEN_TRIGGER_BOMB = register("golden_trigger_bomb", createBombEntityType(GoldenTriggerBombEntity::new));
        DIAMOND_BOMB = register("diamond_bomb", createBombEntityType(DiamondBombEntity::new));
        DIAMOND_TRIGGER_BOMB = register("diamond_trigger_bomb", createBombEntityType(DiamondTriggerBombEntity::new));
        NAVAL_MINE = register("naval_mine", createBombEntityType(NavalMineEntity::new));
        CONFETTI_BOMB = register("confetti_bomb", createBombEntityType(ConfettiBombEntity::new));
        CONFETTI_TRIGGER_BOMB = register("confetti_trigger_bomb", createBombEntityType(ConfettiTriggerBombEntity::new));
        DIRT_BOMB = register("dirt_bomb", createBombEntityType(DirtBombEntity::new));
        DIRT_TRIGGER_BOMB = register("dirt_trigger_bomb", createBombEntityType(DirtTriggerBombEntity::new));
        PEARL_BOMB = register("pearl_bomb", createBombEntityType(PearlBombEntity::new));
        PEARL_TRIGGER_BOMB = register("pearl_trigger_bomb", createBombEntityType(PearlTriggerBombEntity::new));
        SLIME_BOMB = register("slime_bomb", createBombEntityType(SlimeBombEntity::new));
        SLIME_TRIGGER_BOMB = register("slime_trigger_bomb", createBombEntityType(SlimeTriggerBombEntity::new));
        AMETHYST_BOMB = register("amethyst_bomb", createBombEntityType(AmethystBombEntity::new));
        AMETHYST_TRIGGER_BOMB = register("amethyst_trigger_bomb", createBombEntityType(AmethystTriggerBombEntity::new));
        FROST_BOMB = register("frost_bomb", createBombEntityType(FrostBombEntity::new));
        FROST_TRIGGER_BOMB = register("frost_trigger_bomb", createBombEntityType(FrostTriggerBombEntity::new));
        PIPE_BOMB = register("pipe_bomb", createBombEntityType(PipeBombEntity::new));

        // explosive blocks
        GUNPOWDER_BLOCK = register("gunpowder_block", EntityType.Builder.create(GunpowderBlockEntity::new, SpawnGroup.MISC).dimensions(1, 1).maxTrackingRange(10).trackingTickInterval(20).build());
        STRIPMINER = register("stripminer", EntityType.Builder.create(StripminerEntity::new, SpawnGroup.MISC).dimensions(1, 1).maxTrackingRange(10).trackingTickInterval(10).build());
        COLD_DIGGER = register("cold_digger", EntityType.Builder.create(ColdDiggerEntity::new, SpawnGroup.MISC).dimensions(1, 1).maxTrackingRange(10).trackingTickInterval(10).build());
        BONESBURRIER = register("bonesburrier", EntityType.Builder.create(BonesburrierEntity::new, SpawnGroup.MISC).dimensions(1, 1).maxTrackingRange(10).trackingTickInterval(10).build());

        // projectiles
        AMETHYST_SHARD = register("amethyst_shard", EntityType.Builder.create(AmethystShardEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build());
        ICICLE = register("icicle", EntityType.Builder.create(IcicleEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build());

        // custom falling block entity (Needed for claims protection)
        register("shrapnel_block", EntityType.Builder.create(ShrapnelBlockEntity::new, SpawnGroup.MISC).dimensions(1, 1).build());
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, Blast.id(name), entityType);
    }

    private static <T extends Entity> EntityType<T> createBombEntityType(EntityType.EntityFactory<T> factory) {
        return EntityType.Builder.create(factory, SpawnGroup.MISC).dimensions(0.25f, 0.25f).build();
    }
}
