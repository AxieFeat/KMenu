package kmenu.menu

import kmenu.menu.context.MenuContext
import kmenu.menu.context.SaveableMenuContext
import net.kyori.adventure.audience.Audience

/**
 * This interface represents a viewer of a menu.
 *
 * In fact, you should use some backend implementation of this interface,
 * because this interface only defines the basic functionality of a menu viewer and
 * doesn't even have player name, uuid etc.
 */
interface MenuViewer : Audience {

    /**
     * Current active context for this viewer.
     * Active context means the menu of this context currently opened for this viewer.
     *
     * In can be null if player has no active context.
     */
    val context: MenuContext?

    /**
     * History of all previous contexts for this viewer.
     *
     * The elements in this set are sorted in descending order
     * (Most Recent -> Oldest)
     *
     * Size of this set can be limited by backend implementation.
     */
    val contextHistory: LinkedHashSet<SaveableMenuContext>
}
