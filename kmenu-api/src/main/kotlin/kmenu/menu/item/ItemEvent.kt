package kmenu.menu.item

import kmenu.menu.context.MenuContext

/**
 * This interface represents event of menu item.
 */
interface ItemEvent {

    /**
     * Context where are event called.
     */
    val context: MenuContext

    /**
     * Item that has been changed.
     */
    val item: MenuItem
}
