package kmenu.menu.context

/**
 * This interface represents a menu context that can be saved.
 *
 * Unlike the [MenuContext] - this one can save context information.
 * This can be either saving in the runtime or saving to files.
 *
 * There are two main implementations of this interface:
 *
 * [RuntimeMenuContext] - implements a persistent context and saves the context until the server is shut down
 * (The context is created once and then reused each time the menu is opened)
 *
 * [FileMenuContext] - works the same as [RuntimeMenuContext], but unlike the first one -
 * saves the context to a file.
 *
 * Also, you can write your own implementation of this interface if you need to save the context in some other way.
 * In example - context with saving into database.
 *
 * @see RuntimeMenuContext
 * @see FileMenuContext
 */
interface SaveableMenuContext : MenuContext {

    /**
     * This function should simply save the context to some `storage`.
     *
     * See other implementation of this interface like [RuntimeMenuContext] and [FileMenuContext]
     * for more details.
     */
    fun save()

    /**
     * This function should load the context from some `storage`.
     *
     * See other implementation of this interface like [RuntimeMenuContext] and [FileMenuContext]
     * for more details.
     */
    fun load()
}
