package kmenu.menu.context

import net.kyori.adventure.identity.Identity
import java.util.UUID

/**
 * This interface represents a menu context that is persistent only during the runtime of the application.
 *
 * Unlike the [MenuContext], this one can save context information until the server is shut down.
 * The context is created once and then reused each time the menu is opened.
 *
 * @see FileMenuContext
 */
interface RuntimeMenuContext : SaveableMenuContext, Identity {

    /**
     * Get the unique id of this runtime context.
     *
     * It can be Player UUID in example.
     */
    override fun uuid(): UUID
}
