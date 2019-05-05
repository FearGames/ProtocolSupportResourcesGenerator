package protocolsupportresourcesgenerator.utils.minecraft;

import java.util.Arrays;
import java.util.stream.Stream;

import org.bukkit.Material;

public class MinecraftData {

	public static final int ITEM_COUNT = (int) getItems().count();

	public static final int BLOCK_COUNT = (int) getBlocks().count();

	public static final int BLOCKDATA_COUNT =
		getBlocks()
		.mapToInt(material -> MaterialAPI.getBlockDataList(material).size())
		.sum();

	@SuppressWarnings("deprecation")
	public static Stream<Material> getBlocks() {
		return
			Arrays.stream(Material.values())
			.filter(mat -> !mat.isLegacy())
			.filter(Material::isBlock);
	}

	@SuppressWarnings("deprecation")
	public static Stream<Material> getItems() {
		return
			Arrays.stream(Material.values())
			.filter(mat -> !mat.isLegacy())
			.filter(Material::isItem);
	}

}
