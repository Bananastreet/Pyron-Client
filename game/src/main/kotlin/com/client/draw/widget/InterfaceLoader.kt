package com.client.draw.widget

import com.client.draw.widget.impl.*
import kotlin.system.measureTimeMillis


object InterfaceLoader {

    val interfaces = listOf(
        TierInterface(),
        LeaderboardInterface()
    )

    fun init() {
        val time = measureTimeMillis {
            interfaces.forEach {
                it.load()
            }
        }
        println("Interfaces read -> ${interfaces.size} (${time})")

    }


}