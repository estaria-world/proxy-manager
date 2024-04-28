package world.estaria.proxy.manager.api

import io.fabric8.kubernetes.client.KubernetesClient
import world.estaria.kube.configmap.kit.KubeConfigMapKit

/**
 * @author Niklas Nieberler
 */

class ProxyConfigHandler(
    kubernetesClient: KubernetesClient
) {

    private val configSerializer = ProxyConfig.serializer()
    private val configName = "proxy-configuration.yaml"
    private val configMapManager = KubeConfigMapKit.initializeKubeConfig("strela-system", kubernetesClient)

    init {
        if (!this.configMapManager.existsConfig(configName)) {
            this.configMapManager.createConfigMap(configName, configSerializer, ProxyConfig.Default.get())
        }
    }

    fun updateConfig() {
        this.configMapManager.updateConfig(this.configName)
    }

    fun getConfig(): ProxyConfig {
        return this.configMapManager.getConfig(this.configName, this.configSerializer)
            ?: throw NullPointerException("failed to find $configName")
    }

}