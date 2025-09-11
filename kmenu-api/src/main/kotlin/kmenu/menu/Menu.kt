package kmenu.menu

import kmenu.inventory.Inventory
import kmenu.inventory.InventoryType
import kmenu.menu.context.MenuContext
import kmenu.menu.item.MenuItem

/**
 * This interface represents menu.
 */
interface Menu<T : InventoryType> : Inventory<T, MenuItem> {

    /**
     * Context of this menu instance.
     */
    val context: MenuContext
}
