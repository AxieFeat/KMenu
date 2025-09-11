package kmenu.menu.item

import kmenu.item.ItemStack

/**
 * This interface represents wrapped item.
 */
interface MenuItem : ItemStack {

    /**
     * Add consumer for click event.
     *
     * @param click Click consumer.
     */
    fun onClick(click: Event<ItemClickEvent>)

    /**
     * Add consumer for drag event.
     *
     * @param drag Drag consumer.
     */
    fun onDrag(drag: Event<ItemDragEvent>)
}

typealias Event<T> = (T) -> Unit
