package com.client.draw.widget.components

import com.client.draw.ImageCache
import com.client.draw.widget.InterfaceBuilder
import com.client.draw.widget.InterfaceComponent
import com.client.draw.widget.Markers
import com.client.draw.widget.WidgetType
import com.client.graphics.interfaces.RSInterface
import com.client.graphics.interfaces.RSInterface.interfaceCache
import com.runescape.utils.Position


object Sprites {

    fun InterfaceBuilder.sprite(builder: SpriteComponent.(id : Int) -> Unit) {
        val bld = SpriteComponent()
        builder.invoke(bld,id)
        bld.componentId = nextId()
        addSprite(bld.componentId, bld.spriteId,bld.hd)
        children.add(bld)
        bld.childType = WidgetType.SPRITE
    }

    fun InterfaceBuilder.sprites(amount : Int, builder: SpriteComponent.(Int) -> Unit) {
        repeat(amount) { sprite { builder(it) } }
    }

    fun InterfaceBuilder.sprites(amount : Int, rowSize : Int, builder: SpriteComponent.(Int, Int) -> Unit) {
        repeat(amount) { sprite { builder(it % rowSize, Math.floorDiv(it, rowSize)) } }
    }

    fun InterfaceBuilder.sprites(amount : Int, rowSize : Int, padX : Int = 0, padY : Int = 0, add : Boolean = true , builder: SpriteComponent.(id : Int) -> Unit) {
        repeat(amount) {

            val bld = SpriteComponent()

            builder.invoke(bld,it)
            val row = (it % rowSize)
            val col = Math.floorDiv(it, rowSize)

            val width = if(add) ImageCache.getWidth(bld.spriteId) + padX else  ImageCache.getWidth(bld.spriteId) - padX
            val height = if(add) ImageCache.getHeight(bld.spriteId) + padY else ImageCache.getHeight(bld.spriteId) - padY

            bld.childType = WidgetType.SPRITE
            bld.componentId = nextId()
            bld.position = Position(bld.position.x + (row  * width), bld.position.y + (col * height))

            addSprite(bld.componentId, bld.spriteId,bld.hd)
            children.add(bld)

        }

    }

    fun addSprite(id: Int, spriteId: Int, hd: Boolean) {
        interfaceCache[id] = RSInterface()
        val rsint = interfaceCache[id]
        rsint.id = id
        rsint.parentID = id
        rsint.type = RSInterface.TYPE_BUTTON
        rsint.atActionType = 0
        rsint.contentType = 0
        rsint.opacity = 0
        rsint.hoverType = 0
        if (spriteId != -1) {
            rsint.sprite1Number = spriteId
        }
        rsint.width = ImageCache.getWidth(spriteId)
        rsint.height = ImageCache.getHeight(spriteId)
    }

    @Markers
    open class SpriteComponent : InterfaceComponent() {
        var spriteId = 0
        var hd = true
        fun id(bld: () -> Int) {
            this.spriteId = bld()
        }
        fun hd(bld: () -> Boolean) {
            this.hd = bld()
        }
    }


}