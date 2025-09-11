package kmenu

import kmenu.util.FactoryProvider

internal object KMenu {

    // Implementation note: These need to be set reflectively.
    @JvmStatic
    private var factoryProvider: FactoryProvider? = null

    @JvmStatic
    @JvmSynthetic
    internal inline fun <reified T> factory(): T = factoryProvider!!.provide(T::class.java)
}
