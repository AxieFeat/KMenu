package kmenu.item.data

import kmenu.KMenu
import kmenu.annotations.ImmutableType
import kmenu.annotations.TypeFactory
import org.jetbrains.annotations.ApiStatus
import org.jetbrains.annotations.Contract

/**
 * A pattern for a banner. These are immutable and may be reused.
 */
@ImmutableType
interface BannerPattern {

    /**
     * The type of this banner pattern.
     */
    val type: String?

    /**
     * The color of this banner pattern.
     */
    val color: DyeColor

    @ApiStatus.Internal
    @TypeFactory
    interface Factory {

        fun of(type: String, color: DyeColor): BannerPattern
    }

    companion object {

        /**
         * Creates a new banner pattern with the given values.
         *
         * @param type The type.
         * @param color The color.
         *
         * @return A new banner pattern.
         */
        @JvmStatic
        @Contract("_, _ -> new", pure = true)
        fun of(type: String, color: DyeColor): BannerPattern = KMenu.factory<Factory>().of(type, color)
    }
}
