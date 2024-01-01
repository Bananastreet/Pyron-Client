package com.client.draw.widget

import java.util.*

enum class WidgetType {
    TEXT,
    SPRITE,
    BACKGROUND,
    CHAR,
    DIVIDER,
    BUTTON,
    DROPDOWN,
    HEAD,
    ITEM,
    PROGRESS,
    RASTERIZER,
    SPRITES,
    TEST,
    TOOLTIPS,
    PLAYER,
    SCROLL;

    override fun toString(): String {
        return name.lowercase()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }

}