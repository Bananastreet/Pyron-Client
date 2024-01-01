package com.client.draw.widget.components

import com.client.Sprite
import com.client.draw.ImageCache
import com.client.draw.widget.InterfaceBuilder
import com.client.draw.widget.InterfaceComponent
import com.client.draw.widget.Markers
import com.client.draw.widget.WidgetType
import com.client.graphics.interfaces.RSInterface
import com.client.graphics.interfaces.RSInterface.addInterface
import com.client.utils.MathUtils.d2Tod1
import com.client.utils.MathUtils.fillPixels


object Divider {

    fun InterfaceBuilder.divider(builder: DeviderComponent.() -> Unit) {
        val bld = DeviderComponent()
        builder.invoke(bld)
        bld.componentId = nextId()
        addDividerImage(bld.componentId, bld.width,bld.across,bld.style)
        children.add(bld)
        bld.childType = WidgetType.BUTTON

    }

    fun addDividerImage(id: Int, width: Int, across: Boolean, forceType: Background.ForceType) {
        val tab: RSInterface = addInterface(id)
        tab.id = id
        tab.parentID = id
        tab.type = RSInterface.TYPE_DIVIDER

        tab.contentType = 0
        tab.opacity = 0
        tab.forceStyle = forceType
        tab.across = across
        tab.width = width
        tab.height = 7
    }



    fun buildDevider(across : Boolean = true,width: Int,osrs : Boolean): Sprite {
        if (!across) {
            return buildDeviderHeight(width,osrs)
        }
        val pixels = Array(7) { IntArray(width) }
        fillPixels(pixels, ImageCache.get(if(osrs) 3  else 2), 0, 0, width, 7)
        return Sprite(width, 7, 0, 0, d2Tod1(pixels))
    }

    fun buildDeviderHeight(height: Int,osrs : Boolean): Sprite {
        val pixels = Array(height) { IntArray(7) }
        fillPixels(pixels, ImageCache.get(if(osrs) 7  else 6), 0, 0, 7, height)
        return Sprite(7, height, 0, 0, d2Tod1(pixels))
    }


    @Markers
    open class DeviderComponent : InterfaceComponent() {
        var width : Int = 0
        var across : Boolean = true
        var style : Background.ForceType = Background.ForceType.NONE
        fun size(bld: () -> Int) {
            this.width = bld()
        }
        fun across(bld: () -> Boolean) {
            this.across = bld()
        }

        fun force(bld: () -> Background.ForceType) {
            this.style = bld()
        }
    }

}