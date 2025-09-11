package kmenu.item

import kmenu.annotations.ImmutableType
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.translation.Translatable

/**
 * Represents a type of item.
 */
@Suppress("INAPPLICABLE_JVM_NAME")
@ImmutableType
interface ItemType : Translatable, Keyed {

    /**
     * The rarity of the item.
     */
    val rarity: ItemRarity

    /**
     * The maximum amount of this item type that can be stacked in a single
     * [item stack][ItemStack].
     */
    val maximumStackSize: Int

    /**
     * If items of this type actually take damage when they use or break blocks.
     */
    @get:JvmName("canBreak")
    val canBreak: Boolean

    /**
     * The maximum number of things items of this type can use/break before
     * they break.
     */
    val durability: Int
}
