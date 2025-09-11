package kmenu.item.meta

import kmenu.annotations.ImmutableType
import kmenu.annotations.MetaDsl
import org.jetbrains.annotations.Contract

/**
 * Item metadata for a writable book (book and quill).
 */
@ImmutableType
interface WritableBookMeta : BookMeta<WritableBookMeta.Builder, WritableBookMeta> {

    /**
     * A builder for building writable book metadata.
     */
    @MetaDsl
    interface Builder : BookMeta.Builder<Builder, WritableBookMeta>

    companion object {

        /**
         * Creates a new builder for building writable book metadata.
         *
         * @return A new builder.
         */
        @JvmStatic
        @Contract("-> new", pure = true)
        fun builder(): Builder = ItemMeta.builder(WritableBookMeta::class.java)
    }
}
