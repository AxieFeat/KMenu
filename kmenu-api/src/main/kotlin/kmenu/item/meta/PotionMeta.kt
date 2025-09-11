package kmenu.item.meta

import kmenu.annotations.ImmutableType
import kmenu.annotations.MetaDsl
import kmenu.util.Color
import org.jetbrains.annotations.Contract

/**
 * Item metadata for a potion effects.
 */
@ImmutableType
interface PotionMeta : ScopedItemMeta<PotionMeta.Builder, PotionMeta> {

    /**
     * Displayable color of potion.
     */
    val color: Color?

    /**
     * Creates new potion metadata with the given [color].
     *
     * @param color The new color.
     *
     * @return New potion metadata.
     */
    @Contract("_ -> new", pure = true)
    fun withColor(color: Color?): PotionMeta

    /**
     * A builder for building potion effect metadata.
     */
    @MetaDsl
    interface Builder : ItemMetaBuilder<Builder, PotionMeta> {

        /**
         * Sets the color of the potion metadata.
         *
         * @param color The color.
         *
         * @return This builder.
         */
        @MetaDsl
        @Contract("_ -> this", mutates = "this")
        fun color(color: Color?): Builder
    }

    companion object {

        /**
         * Creates a new builder for potion effect metadata.
         *
         * @return A new builder.
         */
        @JvmStatic
        @Contract("-> new", pure = true)
        fun builder(): Builder = ItemMeta.builder(PotionMeta::class.java)
    }
}
