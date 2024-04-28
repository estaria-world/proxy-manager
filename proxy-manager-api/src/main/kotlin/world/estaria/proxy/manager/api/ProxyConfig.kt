package world.estaria.proxy.manager.api

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class ProxyConfig(
    val maintenance: Boolean,
    val maximumPlayers: Int,
    val whitelistedPlayers: List<String>,
    val supportedProtocolVersions: List<Int>
) {

    object Default {
        fun get(): ProxyConfig {
            return ProxyConfig(
                true,
                100,
                arrayListOf(
                    "MrManHD"
                ),
                arrayListOf(
                    600
                )
            )
        }
    }

}