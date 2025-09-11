package kmenu.inventory

import kmenu.annotations.ImmutableType

/**
 * A type of inventory, that have rectangle form.
 */
@ImmutableType
interface RectangleInventoryType : InventoryType {

    /**
     * The width of the inventory.
     */
    val sizeX: Int

    /**
     * The height of the inventory.
     */
    val sizeY: Int

    /**
     * Get indexes of slots for given row ordinal.
     *
     * @param ordinal The row ordinal, starting from 0.
     *
     * @return List of slot indexes for the given row.
     */
    fun getRow(ordinal: Int): List<Int>

    /**
     * Get indexes of slots for given column ordinal.
     *
     * @param ordinal The column ordinal, starting from 0.
     *
     * @return List of slot indexes for the given column.
     */
    fun getColumn(ordinal: Int): List<Int>

    /**
     * Get indexes of slots for the outline of the inventory.
     *
     * @return List of slot indexes for the outline.
     */
    fun getOutline(): List<Int>
}
