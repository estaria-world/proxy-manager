package world.estaria.proxy.manager.api

import world.estaria.github.file.manager.properties.GitHubYamlLoader

/**
 * @author Niklas Nieberler
 */

class ProxyConfigHandler(
    path: String
) {

    private val yamlLoader = GitHubYamlLoader(path, ProxyConfig.serializer())
    private var config = yamlLoader.getYaml()

    init {
        if (this.yamlLoader.getYaml() == null)
            throw NullPointerException("failed to find proxyConfig.yaml in github")
    }

    fun updateConfig() {
        this.config = this.yamlLoader.getYaml()
    }

    fun getConfig(): ProxyConfig {
        return this.config ?: throw NullPointerException("failed to find proxyConfig.yaml")
    }

}