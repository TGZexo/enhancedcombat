
package net.mcreator.enhancedcombat.block;

import net.minecraft.block.material.Material;

@EnhancedcombatModElements.ModElement.Tag
public class FuckYouJessBlock extends EnhancedcombatModElements.ModElement {

	@ObjectHolder("enhancedcombat:fuck_you_jess")
	public static final Block block = null;

	public FuckYouJessBlock(EnhancedcombatModElements instance) {
		super(instance, 1);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("fuck_you_jess");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
