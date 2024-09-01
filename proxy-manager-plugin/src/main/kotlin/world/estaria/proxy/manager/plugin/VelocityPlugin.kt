package world.estaria.proxy.manager.plugin

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyReloadEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import world.estaria.proxy.manager.api.ProxyManagerApi

/**
 * @author Niklas Nieberler
 */

@Plugin(id = "proxy-manager", name = "proxy-manager", version = "1.0.1", authors = ["MrManHD"])
class VelocityPlugin @Inject constructor(
    private val server: ProxyServer
) {

    @Subscribe
    fun handleInitialize(event: ProxyInitializeEvent) {
        ProxyManagerApi.initialize("estaria-world/proxy-configurations/master/configuration.yaml")
    }

    @Subscribe
    fun handleProxyReload(event: ProxyReloadEvent) {
        ProxyManagerApi.instance.configHandler.updateConfig()
    }

}