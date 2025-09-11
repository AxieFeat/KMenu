package kmenu.menu.context

import java.nio.file.Path

/**
 * This interface represents a menu context that is associated with a file location.
 *
 * @see RuntimeMenuContext
 */
interface FileMenuContext : SaveableMenuContext {

    /**
     * The path where the context is stored.
     */
    val location: Path
}
