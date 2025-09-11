package kmenu.menu.context

import kmenu.menu.Menu
import kmenu.menu.MenuViewer
import xyz.axie.nbt.MutableCompoundTag

/**
 * This interface represents unique context of menu for viewer.
 *
 * This context is unique for each viewer and is also not saved when the menu is closed.
 *
 * Context allows you to get various information about the current viewer.
 * Also, the context can store your personal information in NBT format,
 * but... Perhaps you should use the [SaveableMenuContext] for normal use.
 *
 * @see SaveableMenuContext
 */
interface MenuContext {

    /**
     * The viewer of this menu context.
     */
    val viewer: MenuViewer

    /**
     * A unique menu instance that belongs to this context.
     * That is, you should take into account that if you change any values here,
     * they will be local to this instance of [MenuContext].
     */
    val menu: Menu<*>

    /**
     * The NBT container that stores the context data. You can write any data here.
     *
     * This container is unique for each viewer and is not saved when the menu is closed.
     * If you need to save data between menu openings, consider using [SaveableMenuContext].
     */
    val container: MutableCompoundTag
}
