package io.github.afamiliarquiet.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.github.afamiliarquiet.MagnificentMaw.id;

public class MawItems {
    public static final Identifier CURIOUS_VIAL_ID = id("curious_vial");
    public static final CuriousVialItem CURIOUS_VIAL = new CuriousVialItem(new Item.Settings());

    public static final Identifier CHOMPED_WOODEN_SWORD_ID = id("chomped_wooden_sword");
    public static final Identifier CHOMPED_STONE_SWORD_ID = id("chomped_stone_sword");
    public static final Identifier CHOMPED_IRON_SWORD_ID = id("chomped_iron_sword");
    public static final Identifier CHOMPED_GOLDEN_SWORD_ID = id("chomped_golden_sword");
    public static final Identifier CHOMPED_DIAMOND_SWORD_ID = id("chomped_diamond_sword");
    public static final Identifier CHOMPED_NETHERITE_SWORD_ID = id("chomped_netherite_sword");

    public static final Item CHOMPED_WOODEN_SWORD = new Item(new Item.Settings().maxCount(1));
    public static final Item CHOMPED_STONE_SWORD = new Item(new Item.Settings().maxCount(1));
    public static final Item CHOMPED_IRON_SWORD = new Item(new Item.Settings().maxCount(1));
    public static final Item CHOMPED_GOLDEN_SWORD = new Item(new Item.Settings().maxCount(1));
    public static final Item CHOMPED_DIAMOND_SWORD = new Item(new Item.Settings().maxCount(1));
    public static final Item CHOMPED_NETHERITE_SWORD = new Item(new Item.Settings().maxCount(1));

    public static void register() {
        registerItem(CURIOUS_VIAL_ID, CURIOUS_VIAL);

        // todo - add source for curious vial - vaults? wandering traders?
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(
                content -> content.addAfter(Items.OMINOUS_BOTTLE, CURIOUS_VIAL)
        );

        registerItem(CHOMPED_WOODEN_SWORD_ID, CHOMPED_WOODEN_SWORD);
        registerItem(CHOMPED_STONE_SWORD_ID, CHOMPED_STONE_SWORD);
        registerItem(CHOMPED_IRON_SWORD_ID, CHOMPED_IRON_SWORD);
        registerItem(CHOMPED_GOLDEN_SWORD_ID, CHOMPED_GOLDEN_SWORD);
        registerItem(CHOMPED_DIAMOND_SWORD_ID, CHOMPED_DIAMOND_SWORD);
        registerItem(CHOMPED_NETHERITE_SWORD_ID, CHOMPED_NETHERITE_SWORD);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(
                content -> content.addBefore(Items.WOODEN_AXE, CHOMPED_WOODEN_SWORD, CHOMPED_STONE_SWORD,
                        CHOMPED_IRON_SWORD, CHOMPED_GOLDEN_SWORD, CHOMPED_DIAMOND_SWORD, CHOMPED_NETHERITE_SWORD)
        );
    }

    private static void registerItem(Identifier id, Item item) {
        Registry.register(Registries.ITEM, id, item);
    }
}
