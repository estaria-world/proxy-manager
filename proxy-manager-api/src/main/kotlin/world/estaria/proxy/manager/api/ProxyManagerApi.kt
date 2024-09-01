package world.estaria.proxy.manager.api

/**
 * @author Niklas Nieberler
 */

class ProxyManagerApi(
    path: String
) {

    val configHandler = ProxyConfigHandler(path)

    init {
        instance = this
    }

    companion object {
        lateinit var instance: ProxyManagerApi
            private set


        /**
         * Initialize a proxy manager instance
         * @param path the config url path
         * @return new instance of [ProxyManagerApi]
         */
        fun initialize(path: String): ProxyManagerApi {
            return ProxyManagerApi(path)
        }
    }

}