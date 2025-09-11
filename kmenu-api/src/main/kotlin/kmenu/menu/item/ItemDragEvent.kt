package kmenu.menu.item

/**
 * This interface represents drag event on some item of menu.
 */
interface ItemDragEvent : ItemEvent {

    /**
     * The type of drag.
     */
    val type: DragType

    /**
     * Represents the effect of a drag that will be applied to an Inventory.
     */
    enum class DragType {

        /**
         * One item from the cursor is placed in each selected slot.
         */
        SINGLE,

        /**
         * The cursor is split evenly across all selected slots, not to exceed the
         * ItemType's max stack size, with the remainder going to the cursor.
         */
        EVEN,
    }
}
