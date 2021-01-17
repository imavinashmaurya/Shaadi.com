package com.avinash.shaadi.api

import com.avinash.shaadi.BuildConfig


object APIConstants {

    /**
     * This defines the environment or the server to which the app is pointing to.
     */
    const val DEV: String = "DEV"
    const val UAT: String = "UAT"

    /**
     * App environment enum.
     * (can be more like: UAT/STAGING/DEBUG...)
     */
    enum class Environment {
        DEVELOPMENT,
        PRODUCTION
    }

    /**
     * Check the current environment of the app.
     *
     * @return current environment value of the app.
     */
    private val environment = if (BuildConfig.POINTING == DEV) {
        Environment.DEVELOPMENT
    } else {
        Environment.PRODUCTION
    }

    // Domain/Server
    private var DEVELOPMENT_DOMAIN = BuildConfig.DOMAIN_DEV
    private var PRODUCTION_DOMAIN = BuildConfig.DOMAIN_UAT

    /**
     * Get domain based on the environment of the app.
     *
     * @return domain based on the app environment. (e.g. development/production)
     */

     val domain: String = when (environment) {
        Environment.DEVELOPMENT -> DEVELOPMENT_DOMAIN
        Environment.PRODUCTION -> PRODUCTION_DOMAIN
    }

    val apiPath = domain + "api/"

}

