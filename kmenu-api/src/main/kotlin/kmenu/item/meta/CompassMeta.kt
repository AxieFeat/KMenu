package kmenu.item.meta

import kmenu.annotations.ImmutableType
import kmenu.annotations.MetaDsl
import kmenu.util.Vec3i
import org.jetbrains.annotations.Contract

/**
 * Item metadata for a compass.
 */
@ImmutableType
interface CompassMeta : ScopedItemMeta<CompassMeta.Builder, CompassMeta> {

    /**
     * Whether the compass is tracking lodestone.
     */
    val isTrackingLodestone: Boolean

    /**
     * The dimension that the tracked lodestone is in.
     */
    val lodestoneDimension: String?

    /**
     * The position of the lodestone the compass is tracking.
     */
    val lodestonePosition: Vec3i?

    /**
     * Creates new item metadata tracking the lodestone in the given
     * [dimension] at the given [position].
     *
     * This will set [isTrackingLodestone] to true.
     *
     * @param dimension The dimension the lodestone is in.
     * @param position The position the lodestone is at.
     *
     * @return New item metadata.
     */
    @Contract("_, _ -> new", pure = true)
    fun withLodestone(dimension: String, position: Vec3i): CompassMeta

    /**
     * Creates new item metadata without tracked lodestone.
     *
     * This will set [isTrackingLodestone] to false, and both
     * [lodestoneDimension] and [lodestonePosition] to null.
     *
     * @return New item metadata.
     */
    @Contract("-> new", pure = true)
    fun withoutLodestone(): CompassMeta

    /**
     * A builder for building compass metadata.
     */
    @MetaDsl
    interface Builder : ItemMetaBuilder<Builder, CompassMeta> {

        /**
         * Sets the dimension and position of the lodestone the compass is
         * tracking to the given [dimension] and [position].
         *
         * @param dimension The dimension the lodestone is in.
         * @param position The position the lodestone is at.
         *
         * @return This builder.
         */
        @MetaDsl
        @Contract("_, _ -> this", mutates = "this")
        fun lodestone(dimension: String, position: Vec3i): Builder
    }

    companion object {

        /**
         * Creates a new builder for building compass metadata.
         *
         * @return A new builder.
         */
        @JvmStatic
        @Contract("-> new", pure = true)
        fun builder(): Builder = ItemMeta.builder(CompassMeta::class.java)
    }
}
