package world.estaria.proxy.manager.api

import io.fabric8.kubernetes.client.KubernetesClient
import io.fabric8.kubernetes.client.KubernetesClientBuilder

/**
 * @author Niklas Nieberler
 */

class ProxyManagerApi(
    private val kubernetesClient: KubernetesClient
) {

    val configHandler = ProxyConfigHandler(kubernetesClient)

    init {
        instance = this
    }

    companion object {
        lateinit var instance: ProxyManagerApi
            private set

        /**
         * Initialize a proxy manager instance
         * @return new instance of [ProxyManagerApi]
         */
        fun initialize(): ProxyManagerApi {
            val kubernetesClient = KubernetesClientBuilder().build()
            return ProxyManagerApi(kubernetesClient)
        }

        /**
         * Initialize a proxy manager instance
         * @param kubernetesClient the kubernetes client
         * @return new instance of [ProxyManagerApi]
         */
        fun initialize(kubernetesClient: KubernetesClient): ProxyManagerApi {
            return ProxyManagerApi(kubernetesClient)
        }
    }

}