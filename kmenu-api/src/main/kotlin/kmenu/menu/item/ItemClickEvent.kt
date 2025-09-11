package kmenu.menu.item

/**
 * This interface represents click event on some item of menu.
 */
interface ItemClickEvent : ItemEvent {

    /**
     * The type of click.
     */
    val type: ClickType

    /**
     * The action type in inventory.
     */
    val action: InventoryAction

    /**
     * What the client did to trigger this action (not the result).
     */
    enum class ClickType {

        /**
         * The left (or primary) mouse button.
         */
        LEFT,

        /**
         * Holding shift while pressing the left mouse button.
         */
        SHIFT_LEFT,

        /**
         * The right mouse button.
         */
        RIGHT,

        /**
         * Holding shift while pressing the right mouse button.
         */
        SHIFT_RIGHT,

        /**
         * Clicking the left mouse button on the grey area around the inventory.
         */
        WINDOW_BORDER_LEFT,

        /**
         * Clicking the right mouse button on the grey area around the inventory.
         */
        WINDOW_BORDER_RIGHT,

        /**
         * The middle mouse button, or a "scrollwheel click".
         */
        MIDDLE,

        /**
         * One of the number keys 1-9, correspond to slots on the hotbar.
         */
        NUMBER_KEY,

        /**
         * Pressing the left mouse button twice in quick succession.
         */
        DOUBLE_CLICK,

        /**
         * The "Drop" key (defaults to Q).
         */
        DROP,

        /**
         * Holding Ctrl while pressing the "Drop" key (defaults to Q).
         */
        CONTROL_DROP,

        /**
         * Any action done with the Creative inventory open.
         */
        CREATIVE,

        /**
         * The "swap item with offhand" key (defaults to F).
         */
        SWAP_OFFHAND,

        /**
         * A type of inventory manipulation not yet recognized by KMenu.
         */
        UNKNOWN,
    }

    /**
     * An estimation of what the result will be.
     */
    enum class InventoryAction {

        /**
         * Nothing will happen from the click.
         *
         * There may be cases where nothing will happen and this is value is not
         * provided, but it is guaranteed that this value is accurate when given.
         */
        NOTHING,

        /**
         * All the items on the clicked slot are moved to the cursor.
         */
        PICKUP_ALL,

        /**
         * Some of the items on the clicked slot are moved to the cursor.
         */
        PICKUP_SOME,

        /**
         * Half of the items on the clicked slot are moved to the cursor.
         */
        PICKUP_HALF,

        /**
         * One of the items on the clicked slot are moved to the cursor.
         */
        PICKUP_ONE,

        /**
         * All the items on the cursor are moved to the clicked slot.
         */
        PLACE_ALL,

        /**
         * Some of the items from the cursor are moved to the clicked slot
         * (usually up to the max stack size).
         */
        PLACE_SOME,

        /**
         * A single item from the cursor is moved to the clicked slot.
         */
        PLACE_ONE,

        /**
         * The clicked item and the cursor are exchanged.
         */
        SWAP_WITH_CURSOR,

        /**
         * The entire cursor item is dropped.
         */
        DROP_ALL_CURSOR,

        /**
         * One item is dropped from the cursor.
         */
        DROP_ONE_CURSOR,

        /**
         * The entire clicked slot is dropped.
         */
        DROP_ALL_SLOT,

        /**
         * One item is dropped from the clicked slot.
         */
        DROP_ONE_SLOT,

        /**
         * The item is moved to the opposite inventory if a space is found.
         */
        MOVE_TO_OTHER_INVENTORY,

        /**
         * The clicked slot and the picked hotbar slot are swapped.
         *
         * The hotbar includes the player's offhand.
         */
        HOTBAR_SWAP,

        /**
         * A max-size stack of the clicked item is put on the cursor.
         */
        CLONE_STACK,

        /**
         * The inventory is searched for the same material, and they are put on
         * the cursor up to [kmenu.item.ItemType.maximumStackSize].
         */
        COLLECT_TO_CURSOR,

        /**
         * An unrecognized ClickType.
         */
        UNKNOWN,

        /**
         * The first stack of items in the clicked bundle is moved to the cursor.
         */
        PICKUP_FROM_BUNDLE,

        /**
         * All the items on the clicked slot are moved into the bundle on the cursor.
         */
        PICKUP_ALL_INTO_BUNDLE,

        /**
         * Some of the items on the clicked slot are moved into the bundle on the cursor.
         */
        PICKUP_SOME_INTO_BUNDLE,

        /**
         * The first stack of items is moved to the clicked slot.
         */
        PLACE_FROM_BUNDLE,

        /**
         * All the items on the cursor are moved into the bundle in the clicked slot.
         */
        PLACE_ALL_INTO_BUNDLE,

        /**
         * Some of the items on the cursor are moved into the bundle in the clicked slot.
         */
        PLACE_SOME_INTO_BUNDLE,
    }
}
