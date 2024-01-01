package com.client.draw.widget.components

import com.client.draw.widget.InterfaceBuilder
import com.client.draw.widget.InterfaceComponent
import com.client.draw.widget.Markers
import com.client.graphics.interfaces.RSInterface
import com.client.graphics.interfaces.RSInterface.interfaceCache
import com.client.draw.widget.WidgetType
import com.runescape.utils.Position

object ItemContainer {

    fun InterfaceBuilder.container(builder: ItemContainerComponent.() -> Unit) {
        val bld = ItemContainerComponent()
        builder.invoke(bld)
        bld.componentId = nextId()
        bld.childType = WidgetType.ITEM

        itemContainer(bld.componentId,bld.width,bld.height,bld.paddingX,bld.paddingY,
            bld.options
        )
        children.add(bld)

    }

    fun InterfaceBuilder.containers(amount : Int, rowSize : Int, padX : Int = 0, padY : Int = 0, add : Boolean = true, builder: ItemContainerComponent.(id : Int) -> Unit) {
        repeat(amount) {
            val bld = ItemContainerComponent()
            val row = (it % rowSize)
            val col = Math.floorDiv(it, rowSize)
            val width = if(add) bld.width + padX else  bld.width - padX
            val height = if(add) bld.height + padY else bld.height - padY

            builder.invoke(bld,it)
            bld.componentId = nextId()
            bld.position = Position(bld.position.x + (row  * width), bld.position.y + (col * height))
            bld.childType = WidgetType.ITEM
            itemContainer(bld.componentId,bld.width,bld.height,bld.paddingX,bld.paddingY,
                bld.options
            )
            children.add(bld)

        }
    }

    fun itemContainer(id: Int, w: Int, h: Int, x: Int, y: Int, action: Array<String?>) {
        interfaceCache[id] = RSInterface()
        val rsi = interfaceCache[id]
        rsi.width = w
        rsi.id = id
        rsi.height = h
        rsi.parentID = id
        rsi.inventoryItemId = IntArray(w * h)
        rsi.inventoryAmounts = IntArray(w * h)

        rsi.usableItemInterface = false
        rsi.aBoolean235 = false
        rsi.hoverType = 52
        rsi.atActionType = 1
        rsi.modelZoom = 45
        rsi.invSpritePadX = x
        rsi.invSpritePadY = y
        rsi.spritesX = IntArray(20)
        rsi.spritesY = IntArray(20)
        rsi.sprites = arrayOfNulls(20)
        rsi.actions = arrayOfNulls(5)
        for (i in action.indices) {
            if (action[i] != null) {
                rsi.actions[i] = action[i]
            }
        }
        rsi.type = 2
    }

    @Markers
    open class ItemContainerComponent : InterfaceComponent() {
        var paddingX : Int = 0
        var paddingY : Int = 0
        var width : Int = 0
        var height : Int = 1
        var transparent = false
        var options : Array<String?> = arrayOfNulls(5)

        fun paddingX(bld: () -> Int) {
            this.paddingX = bld()
        }
        fun paddingY(bld: () -> Int) {
            this.paddingY = bld()
        }
        fun width(bld: () -> Int) {
            this.width = bld()
        }
        fun height(bld: () -> Int) {
            this.height = bld()
        }
        fun options(bld: () -> Array<String?>) {
            this.options = bld()
        }

    }

}