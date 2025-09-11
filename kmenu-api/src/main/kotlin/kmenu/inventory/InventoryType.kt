package kmenu.inventory

import kmenu.annotations.ImmutableType
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component

/**
 * A type of inventory.
 */
@ImmutableType
interface InventoryType : Keyed {

    /**
     * The size of the inventory.
     */
    val size: Int

    /**
     * The default title that will be displayed when inventories of this type
     * are sent, and no custom title has been defined.
     */
    val defaultTitle: Component
}
