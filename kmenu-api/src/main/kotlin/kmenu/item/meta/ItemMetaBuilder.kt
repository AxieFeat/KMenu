package kmenu.item.meta

import kmenu.annotations.MetaDsl
import net.kyori.adventure.text.Component
import org.jetbrains.annotations.Contract
import kmenu.item.data.ItemFlag

/**
 * The base builder for item metadata.
 */
@MetaDsl
interface ItemMetaBuilder<B : ItemMetaBuilder<B, I>, I : ItemMeta> {

    /**
     * Sets the damage to the item to the given [damage].
     *
     * @param damage The damage.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun damage(damage: Int): B

    /**
     * Sets whether the item is unbreakable to the given [value].
     *
     * @param value Whether the item is unbreakable.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun unbreakable(value: Boolean): B

    /**
     * Makes the item unbreakable.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("-> this", mutates = "this")
    fun unbreakable(): B = unbreakable(true)

    /**
     * Sets the custom model data for the item to the given [data].
     *
     * @param data The custom model data.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun customModelData(data: Int): B

    /**
     * Sets the name of the item to the given [name].
     *
     * @param name The name.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun name(name: Component?): B

    /**
     * Sets the lore of the item to the given [lore].
     *
     * @param lore The lore.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun lore(lore: Collection<Component>): B

    /**
     * Sets the lore of the item to the given [lore].
     *
     * @param lore The lore.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun lore(vararg lore: Component): B = lore(lore.asList())

    /**
     * Adds the given [lore] line to the lore of the item.
     *
     * @param lore The lore line to add.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun addLore(lore: Component): B

    /**
     * Sets the hide flags for the item to the given [flags].
     *
     * @param flags The hide flags.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun hideFlags(flags: Int): B

    /**
     * Sets the given hide [flag] on the item.
     *
     * @param flag The hide flag to set.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun addFlag(flag: ItemFlag): B

    /**
     * Sets the list of blocks the item can destroy to the given [blocks].
     *
     * @param blocks The blocks.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun canDestroy(blocks: Collection<String>): B

    /**
     * Sets the list of blocks the item can destroy to the given [blocks].
     *
     * @param blocks The blocks.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun canDestroy(vararg blocks: String): B = canDestroy(blocks.asList())

    /**
     * Adds the given [block] to the list of blocks the item can destroy.
     *
     * @param block The block to add.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun addCanDestroy(block: String): B

    /**
     * Sets the list of blocks the item can be placed on to the given
     * [blocks].
     *
     * @param blocks The blocks.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun canPlaceOn(blocks: Collection<String>): B

    /**
     * Sets the list of blocks the item can be placed on to the given
     * [blocks].
     *
     * @param blocks The blocks.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun canPlaceOn(vararg blocks: String): B = canPlaceOn(blocks.asList())

    /**
     * Adds the given [block] to the list of blocks the item can be placed on.
     *
     * @param block The block to add.
     *
     * @return This builder.
     */
    @MetaDsl
    @Contract("_ -> this", mutates = "this")
    fun addCanPlaceOn(block: String): B

    /**
     * Builds the resulting item metadata.
     *
     * @return The built item metadata.
     */
    @MetaDsl
    @Contract("-> new", pure = true)
    fun build(): I

    /**
     * A provider of an item meta builder.
     */
    interface Provider<T> {

        /**
         * Converts this object to a builder with all the properties of this
         * object set by default.
         *
         * @return A new builder.
         */
        @Contract("-> new", pure = true)
        fun toBuilder(): T
    }
}
