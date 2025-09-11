package kmenu.inventory

import kmenu.item.ItemStack
import net.kyori.adventure.text.Component

/**
 * An inventory that contains items.
 *
 * The absence of a value in an inventory will always be represented by
 * [ItemStack.empty], not null. This includes the default values in lists of
 * items, such as [items].
 */
interface Inventory<T : InventoryType, V : ItemStack> : Iterable<V> {

    /**
     * The title of this inventory.
     */
    var title: Component

    /**
     * The type of this inventory.
     */
    val type: T

    /**
     * The items in this inventory.
     */
    val items: List<V>

    /**
     * If this inventory contains the specified [item].
     *
     * @param item The item.
     *
     * @return `true` if the [item] is in this inventory, `false` otherwise.
     */
    fun hasItem(item: V): Boolean

    /**
     * Retrieve an item from this inventory at the specified [index].
     *
     * @param index the index (slot, starts from 0) of the item to retrieve.
     *
     * @return The item at that slot, or [ItemStack.empty] if there is no item
     * at that slot.
     *
     * @throws ArrayIndexOutOfBoundsException If [index] is out of bounds
     * (not in 0 <= [index] < [InventoryType.size]).
     */
    fun getItem(index: Int): V

    /**
     * Sets the item at the given [index] to the given [item].
     *
     * @param index The index of the item.
     * @param item The new item.
     */
    fun setItem(index: Int, item: V)

    /**
     * Puts the specified item in the first available empty slot in this
     * inventory, or does nothing if the inventory is full.
     *
     * @param item The item to add.
     */
    fun addItem(item: V)

    /**
     * Removes the specified [item] from the array, or does nothing if there
     * isn't an element that matches this [item].
     *
     * @param item The item to remove.
     */
    fun removeItem(item: V)

    /**
     * Clears this inventory.
     */
    fun clear()
}
