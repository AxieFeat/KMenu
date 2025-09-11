package kmenu.menu

import kmenu.inventory.RectangleInventoryType
import kmenu.item.ItemStack

/**
 * A menu with rectangle inventory type.
 */
interface RectangleMenu : Menu<RectangleInventoryType> {

    /**
     * Pattern of this menu.
     * Can be null if patter is not used in this menu.
     */
    var pattern: MenuPattern?

    /**
     * Sets the item by X and Y coords.
     *
     * @param x X cord in menu, starting from `0` (Column number).
     * @param y Y cord in menu, starting from `0` (Row number).
     * @param item Item to set.
     */
    fun setItem(x: Int, y: Int, item: ItemStack)

    /**
     * Fill the given column with the given item.
     *
     * @param ordinal The column ordinal, starting from 0.
     * @param item The item to fill the column with.
     */
    fun fillColumn(ordinal: Int, item: ItemStack)

    /**
     * Fill the given row with the given item.
     *
     * @param ordinal The row ordinal, starting from 0.
     * @param item The item to fill the row with.
     */
    fun fillRow(ordinal: Int, item: ItemStack)

    /**
     * Fill the outline of the inventory with the given item.
     *
     * @param item The item to fill the outline with.
     */
    fun fillOutline(item: ItemStack)
}
