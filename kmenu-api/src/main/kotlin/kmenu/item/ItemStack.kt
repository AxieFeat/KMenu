package kmenu.item

import kmenu.KMenu
import kmenu.annotations.ImmutableType
import kmenu.annotations.ItemDsl
import kmenu.annotations.TypeFactory
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.event.HoverEventSource
import net.kyori.adventure.util.Buildable
import org.jetbrains.annotations.ApiStatus
import org.jetbrains.annotations.Contract
import kmenu.item.meta.ItemMeta
import kmenu.item.meta.ItemMetaBuilder
import java.util.function.Consumer

/**
 * A stack of items in an inventory.
 */
@ImmutableType
interface ItemStack : Buildable<ItemStack, ItemStack.Builder>, HoverEventSource<HoverEvent.ShowItem> {

    /**
     * The type of item in this stack.
     */
    val type: ItemType

    /**
     * The number of items in this stack.
     */
    val amount: Int

    /**
     * The metadata for this item stack.
     */
    val meta: ItemMeta

    /**
     * Gets the metadata for this item stack as the given type [I], or returns
     * null if the metadata could not be casted to the given [type].
     *
     * @param I The type of metadata.
     * @param type The type.
     *
     * @return The metadata as the type, or null if the metadata is not of the
     * type.
     */
    fun <I : ItemMeta> meta(type: Class<I>): I?

    /**
     * Creates a new item stack with the given [type].
     *
     * @param type The new type.
     *
     * @return A new item stack.
     */
    @Contract("_ -> new", pure = true)
    fun withType(type: ItemType): ItemStack

    /**
     * Creates a new item stack with the given [amount].
     *
     * @param amount The new amount.
     *
     * @return A new item stack.
     */
    @Contract("_ -> new", pure = true)
    fun withAmount(amount: Int): ItemStack

    /**
     * Grows the amount of this item stack by the given [amount] and returns
     * the resulting item stack.
     *
     * This will calculate the new amount by adding the given [amount] to the
     * current [ItemStack.amount].
     *
     * @param amount The amount to grow by.
     *
     * @return The resulting item stack.
     */
    @Contract("_ -> new", pure = true)
    fun grow(amount: Int): ItemStack = withAmount(this.amount + amount)

    /**
     * Shrinks the amount of this item stack by the given [amount] and returns
     * the resulting item stack.
     *
     * This will calculate the new amount by taking the given [amount] away
     * from the current [ItemStack.amount].
     *
     * @param amount The amount to shrink by.
     *
     * @return The resulting item stack.
     */
    @Contract("_ -> new", pure = true)
    fun shrink(amount: Int): ItemStack = withAmount(this.amount - amount)

    /**
     * Creates a new item stack with the given [meta].
     *
     * @param meta The new meta.
     *
     * @return A new item stack.
     */
    @Contract("_ -> new", pure = true)
    fun withMeta(meta: ItemMeta): ItemStack

    /**
     * Creates a new item stack with meta retrieved applying the given
     * [builder] to a new item metadata builder.
     *
     * @param builder The builder to apply.
     *
     * @return A new item stack.
     */
    @Contract("_ -> new", pure = true)
    fun withMeta(builder: Consumer<ItemMeta.Builder>): ItemStack = withMeta(ItemMeta.builder().apply { builder.accept(this) }.build())

    /**
     * Creates a new item stack with meta retrieved applying the given
     * [builder] to a new meta builder created with the given [type].
     *
     * @param B The builder type.
     * @param P The metadata type.
     * @param type The type.
     * @param builder The builder to apply.
     *
     * @return A new item stack.
     */
    @Contract("_, _ -> new", pure = true)
    fun <B : ItemMetaBuilder<B, P>, P> withMeta(type: Class<P>, builder: Consumer<B>): ItemStack
        where P : ItemMetaBuilder.Provider<B>, P : ItemMeta {
        return withMeta(ItemMeta.builder(type).apply { builder.accept(this) }.build() as ItemMeta)
    }

    /**
     * For building new [ItemStack]s.
     */
    @ItemDsl
    interface Builder : Buildable.Builder<ItemStack> {

        /**
         * Sets the type of the [ItemStack] being built.
         *
         * @param type The type of the item.
         *
         * @return This builder.
         */
        @ItemDsl
        @Contract("_ -> this", mutates = "this")
        fun type(type: ItemType): Builder

        /**
         * Sets the number of items in the [ItemStack] being built.
         *
         * @param amount The number of items.
         *
         * @return This builder.
         */
        @ItemDsl
        @Contract("_ -> this", mutates = "this")
        fun amount(amount: Int): Builder

        /**
         * Sets the metadata for the item stack to the given [meta].
         *
         * @param meta The metadata.
         *
         * @return This builder.
         */
        @ItemDsl
        @Contract("_ -> this", mutates = "this")
        fun meta(meta: ItemMeta): Builder

        /**
         * Applies the given [builder] function to the metadata builder for
         * this builder.
         *
         * @param builder The builder function to apply.
         *
         * @return This builder.
         */
        @ItemDsl
        @Contract("_ -> this", mutates = "this")
        fun meta(builder: Consumer<ItemMeta.Builder>): Builder = meta(ItemMeta.builder().apply { builder.accept(this) }.build())

        /**
         * Applies the given [builder] function to the metadata builder for
         * this builder.
         *
         * @param B The builder type.
         * @param P The metadata type.
         * @param type The type of the metadata.
         * @param builder The builder function to apply.
         *
         * @return This builder.
         */
        @ItemDsl
        @Contract("_, _ -> this", mutates = "this")
        fun <B : ItemMetaBuilder<B, P>, P> meta(type: Class<P>, builder: Consumer<B>): Builder
            where P : ItemMetaBuilder.Provider<B>, P : ItemMeta {
            return meta(ItemMeta.builder(type).apply { builder.accept(this) }.build())
        }

        /**
         * Builds a new [ItemStack] with the settings retrieved from
         * this builder.
         */
        @Contract("_ -> new", pure = true)
        override fun build(): ItemStack
    }

    @ApiStatus.Internal
    @TypeFactory
    interface Factory {

        fun builder(): Builder

        fun empty(): ItemStack
    }

    companion object {

        /**
         * Creates a new builder for building an item stack.
         *
         * @return A new builder.
         */
        @JvmStatic
        @Contract("-> new", pure = true)
        fun builder(): Builder = KMenu.factory<Factory>().builder()

        /**
         * Creates a new item stack with the given [type].
         *
         * @param type The type.
         *
         * @return A new item stack.
         */
        @JvmStatic
        @Contract("_ -> new", pure = true)
        fun of(type: ItemType): ItemStack = KMenu.factory<Factory>().builder().type(type).build()

        /**
         * Creates a new item stack with the given [type] and [amount].
         *
         * @param type The item type.
         * @param amount The number of items.
         *
         * @return A new item stack.
         */
        @JvmStatic
        @Contract("_, _ -> new", pure = true)
        fun of(type: ItemType, amount: Int): ItemStack = KMenu.factory<Factory>().builder().type(type).amount(amount).build()

        /**
         * Gets the empty item stack.
         *
         * This item stack is generally used as a default value instead of
         * using `null`.
         *
         * It must satisfy the following requirements:
         * * It's type must always be [air][ItemTypes.AIR].
         * * It's amount must always be `1`.
         * * Its metadata must always be empty. The definition of "empty" is
         *   up to the implementation, but generally, it should be defined as
         *   having all of its properties set to their default values.
         */
        @JvmStatic
        @Contract(pure = true)
        fun empty(): ItemStack = KMenu.factory<Factory>().empty()
    }
}
