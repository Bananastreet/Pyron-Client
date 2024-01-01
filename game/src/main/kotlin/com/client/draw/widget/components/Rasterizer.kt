package com.client.draw.widget.components

import com.client.draw.widget.InterfaceBuilder
import com.client.draw.widget.InterfaceComponent
import com.client.draw.widget.Markers
import com.client.draw.widget.WidgetType
import com.client.graphics.interfaces.RSInterface
import com.client.graphics.interfaces.RSInterface.interfaceCache
import com.runescape.utils.Position
import net.runelite.api.widgets.Widget

object Rasterizer {

    fun InterfaceBuilder.rasterizer(builder: RasterizerContainerComponent.() -> Unit) {
        val bld = RasterizerContainerComponent()
        builder.invoke(bld)
        bld.componentId = nextId()


        if (bld.tooltips.isNotEmpty()) {
            addRaterizerContainer(bld.componentId, bld.width, bld.height, bld.outerBorder,bld.innerBorder,bld.background,bld.tooltips,bld.outerBorderHover,bld.innerBorderHover,bld.backgroundHover,bld.rasterizerType,bld.teleportHover)
        } else {
            addRaterizerContainer(bld.componentId, bld.width, bld.height, bld.outerBorder,bld.innerBorder,bld.background,bld.tooltip,bld.outerBorderHover,bld.innerBorderHover,bld.backgroundHover,bld.rasterizerType,bld.teleportHover)
        }


        children.add(bld)
        bld.childType = WidgetType.RASTERIZER

    }

    fun InterfaceBuilder.rasterizers(amount : Int, builder: RasterizerContainerComponent.(Int) -> Unit) {
        repeat(amount) { rasterizer { builder(it) } }
    }

    fun InterfaceBuilder.rasterizers(amount : Int, rowSize : Int, builder: RasterizerContainerComponent.(Int, Int) -> Unit) {
        repeat(amount) { rasterizer { builder(it % rowSize, Math.floorDiv(it, rowSize)) } }
    }

    fun InterfaceBuilder.rasterizers(amount : Int, rowSize : Int, padX : Int = 0, padY : Int = 0, add : Boolean = true, builder: RasterizerContainerComponent.(id : Int) -> Unit) {
        repeat(amount) {
            val bld = RasterizerContainerComponent()
            val row = (it % rowSize)
            val col = Math.floorDiv(it, rowSize)
            val width = if(add) bld.width + padX else  bld.width - padX
            val height = if(add) bld.height + padY else bld.height - padY

            builder.invoke(bld,it)
            bld.componentId = nextId()
            bld.position = Position(bld.position.x + (row  * width), bld.position.y + (col * height))
            bld.childType = WidgetType.RASTERIZER
            if (bld.tooltips.isNotEmpty()) {
                addRaterizerContainer(bld.componentId, bld.width, bld.height, bld.outerBorder,bld.innerBorder,bld.background,bld.tooltips,bld.outerBorderHover,bld.innerBorderHover,bld.backgroundHover,bld.rasterizerType,bld.teleportHover)
            } else {
                addRaterizerContainer(bld.componentId, bld.width, bld.height, bld.outerBorder,bld.innerBorder,bld.background,bld.tooltip,bld.outerBorderHover,bld.innerBorderHover,bld.backgroundHover,bld.rasterizerType,bld.teleportHover)
            }
            children.add(bld)

        }
    }

    enum class RasterizerType {
        NORMAL, ROUNDED, OUTLINE
    }

    fun addRaterizerContainer(id: Int, width: Int, height: Int, outter: Int, inner: Int, background: Int, tooltip: String, outterHover: Int, innerHover: Int, backgroundHover: Int, rasterizerType: RasterizerType, teleportInterface : Boolean) {
        interfaceCache[id] = RSInterface()
        val tab = interfaceCache[id]
        tab.id = id
        tab.parentID = id
        tab.type = RSInterface.TYPE_RASTERIZER
        tab.contentType = 0
        tab.opacity = 0
        tab.outerBorder = outter
        tab.innerBorder = inner
        tab.background = background
        tab.width = width
        tab.height = height
        tab.rasterizerType = rasterizerType

        if(teleportInterface) {
            tab.atActionType = RSInterface.TYPE_TOOLTIP
            tab.tooltip = ""
        }
        if (tooltip.isNotEmpty()) {
            tab.atActionType = RSInterface.TYPE_TOOLTIP
            tab.tooltip = tooltip
            tab.newButtonClicking = true
            tab.outerBorderHover = outterHover
            tab.innerBorderHover = innerHover
            tab.backgroundHover = backgroundHover
        }
    }

    fun addRaterizerContainer(id: Int, width: Int, height: Int, outter: Int, inner: Int, background: Int, tooltips: List<String>, outterHover: Int, innerHover: Int, backgroundHover: Int, rasterizerType: RasterizerType, teleportInterface : Boolean) {
        interfaceCache[id] = RSInterface()
        val tab = interfaceCache[id]
        tab.id = id
        tab.parentID = id
        tab.type = RSInterface.TYPE_RASTERIZER
        tab.contentType = 0
        tab.opacity = 0
        tab.outerBorder = outter
        tab.innerBorder = inner
        tab.background = background
        tab.width = width
        tab.height = height
        tab.rasterizerType = rasterizerType
        if(teleportInterface) {
            tab.atActionType = RSInterface.TYPE_TOOLTIP
            tab.tooltip = ""
        }
        if (tooltips.isNotEmpty()) {
            tab.atActionType = RSInterface.TYPE_TOOLTIP
            tab.tooltips = tooltips.toTypedArray()
            tab.outerBorderHover = outterHover
            tab.newButtonClicking = true
            tab.innerBorderHover = innerHover
            tab.backgroundHover = backgroundHover
        }
    }


    @Markers
    open class RasterizerContainerComponent : InterfaceComponent() {
        var outerBorder = 0
        var innerBorder = 0
        var background = 0
        var outerBorderHover = 0
        var innerBorderHover = 0
        var backgroundHover = 0

        var width = 0
        var height = 0
        var tooltip = ""
        var tooltips = listOf<String>()
        var rasterizerType = RasterizerType.NORMAL
        var teleportHover = false

        fun teleportHover(bld: () -> Boolean) {
            this.teleportHover = bld()
        }

        fun outer(bld: () -> Int) {
            this.outerBorder = bld()
        }
        fun inner(bld: () -> Int) {
            this.innerBorder = bld()
        }
        fun background(bld: () -> Int) {
            this.background = bld()
        }
        fun outerHover(bld: () -> Int) {
            this.outerBorderHover = bld()
        }
        fun type(bld: () -> RasterizerType) {
            this.rasterizerType = bld()
        }

        fun setColour(bld: () -> Int) {
            val cols = bld()
            this.outerBorder = cols
            this.innerBorder = cols
            this.background = cols
        }

        fun setColours(bld: () -> List<Int>) {
            val cols = bld()
            this.outerBorder = cols[0]
            this.innerBorder = cols[1]
            this.background = cols[2]
        }
        fun setColourHovers(bld: () -> List<Int>) {
            val cols = bld()
            this.outerBorderHover = cols[0]
            this.innerBorderHover = cols[1]
            this.backgroundHover = cols[2]
        }

        fun setColourHover(bld: () -> Int) {
            val cols = bld()
            this.outerBorderHover = cols
            this.innerBorderHover = cols
            this.backgroundHover = cols
        }

        fun innerHover(bld: () -> Int) {
            this.innerBorderHover = bld()
        }

        fun backgroundHover(bld: () -> Int) {
            this.backgroundHover = bld()
        }

        fun width(bld: () -> Int) {
            this.width = bld()
        }
        fun height(bld: () -> Int) {
            this.height = bld()
        }

        fun tooltip(bld: () -> String) {
            this.tooltip = bld()
        }
        fun tooltips(bld: () -> List<String>) {
            this.tooltips = bld()
        }

    }


}