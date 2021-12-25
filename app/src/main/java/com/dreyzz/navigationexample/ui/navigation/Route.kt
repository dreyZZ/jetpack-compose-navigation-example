package com.dreyzz.navigationexample.ui.navigation

sealed class Route(val path: String) {
    object MainScreen : Route("main_screen")
    object DetailScreen : Route("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach {
                if (it.isNotBlank()) append("/$it")
            }
        }
    }
}
