package com.client.draw.widget.components

import com.client.draw.ImageCache
import com.client.draw.widget.*
import com.client.graphics.interfaces.RSInterface
import com.client.graphics.interfaces.RSInterface.*
import com.runescape.draw.widget.*
import com.runescape.utils.Position

object Button {

    fun InterfaceBuilder.button(builder: ButtonComponent.() -> Unit) {


        val bld = ButtonComponent()
        builder.invoke(bld)
        bld.componentId = nextId()
        addButton(bld.componentId, bld.spriteNormal,bld.spriteHover,bld.tooltip)
        children.add(bld)
        bld.childType = WidgetType.BUTTON
        if(bld.textCopmponent != null) {
            val tbld = Text.TextComponent()
            bld.textCopmponent?.invoke(tbld)
            tbld.componentId = nextId()

            tbld.position += bld.position

            Text.addText(tbld.componentId, tbld.text, newFonts, tbld.type.id, tbld.color, tbld.center, tbld.shadow,tbld.lineSpace,tbld.width,tbld.tooltips)
            children.add(tbld)
            tbld.childType = WidgetType.BUTTON
        }

        if(bld.spriteComponent != null) {
            val tbld = Sprites.SpriteComponent()
            bld.spriteComponent?.invoke(tbld)
            tbld.componentId = nextId()

            tbld.position = tbld.position + bld.position
            tbld.childType = WidgetType.SPRITE
            Sprites.addSprite(bld.componentId, tbld.spriteId,tbld.hd)
            children.add(tbld)
        }

    }

    fun InterfaceBuilder.buttons(amount : Int, builder: ButtonComponent.(Int) -> Unit) {
        repeat(amount) { button { builder(it) } }
    }

    fun InterfaceBuilder.buttons(amount : Int, rowSize : Int, builder: ButtonComponent.(Int, Int) -> Unit) {
        repeat(amount) { button { builder(it % rowSize, Math.floorDiv(it, rowSize)) } }
    }

    fun InterfaceBuilder.buttons(amount : Int, rowSize : Int, padX : Int = 0, padY : Int = 0, add : Boolean = true,builder: ButtonComponent.(id : Int) -> Unit) {

        repeat(amount) {

            val bld = ButtonComponent()
            builder.invoke(bld,it)

            val row = (it % rowSize)
            val col = Math.floorDiv(it, rowSize)

            val width = if(add) ImageCache.getWidth(bld.spriteNormal) + padX else ImageCache.getWidth(bld.spriteNormal) - padX
            val height = if(add) ImageCache.getHeight(bld.spriteNormal) + padY else ImageCache.getHeight(bld.spriteNormal) - padY

            bld.componentId = nextId()
            bld.position = Position(bld.position.x + (row  * width), bld.position.y + (col * height))

            if (bld.tooltips.isNotEmpty()) {
                addButton(bld.componentId, bld.spriteNormal,bld.spriteHover,bld.tooltips)
            } else {
                addButton(bld.componentId, bld.spriteNormal,bld.spriteHover,bld.tooltip)
            }

            children.add(bld)

            if(bld.textCopmponent != null) {
                val tbld = Text.TextComponent()
                bld.textCopmponent?.invoke(tbld)
                tbld.componentId = nextId()

                tbld.position += bld.position

                Text.addText(tbld.componentId, tbld.text, newFonts, tbld.type.id, tbld.color, tbld.center, tbld.shadow,tbld.lineSpace,tbld.width,tbld.tooltips,tbld.hover)
                children.add(tbld)
            }

            if(bld.spriteComponent != null) {
                val tbld = Sprites.SpriteComponent()
                bld.spriteComponent?.invoke(tbld)
                tbld.componentId = nextId()

                tbld.position += bld.position

                Sprites.addSprite(bld.componentId, tbld.spriteId,tbld.hd)
                children.add(tbld)

            }
        }

    }

    fun addButton(id: Int, normal: Int, hover: Int, tooltip: String) {
        interfaceCache[id] = RSInterface()
        val tab = interfaceCache[id]
        tab.id = id
        tab.parentID = id
        tab.type = TYPE_BUTTON
        tab.atActionType = TYPE_TOOLTIP
        tab.toggled = false
        tab.contentType = 0
        tab.opacity = 0
        tab.hoverType = 52
        tab.sprite1Number = normal
        tab.sprite2Number = hover

        tab.sprite1 = ImageCache.get(normal)
        tab.sprite2 = ImageCache.get(hover)
        tab.newButtonClicking = true
        tab.width = ImageCache.getWidth(normal)
        tab.height = ImageCache.getHeight(normal)
        tab.tooltip = tooltip

    }

    fun addButton(id: Int, normal: Int, hover: Int, tooltip: Array<String>) {
        interfaceCache[id] = RSInterface()
        val tab = interfaceCache[id]
        tab.id = id
        tab.parentID = id
        tab.type = TYPE_BUTTON
        tab.atActionType = TYPE_TOOLTIP
        tab.toggled = false
        tab.contentType = 0
        tab.opacity = 0
        tab.hoverType = 52

        tab.sprite1 = ImageCache.get(normal)
        tab.sprite2 = ImageCache.get(hover)
        tab.newButtonClicking = true
        tab.sprite1Number = hover
        tab.sprite2Number = normal

        tab.width = ImageCache.getWidth(normal)
        tab.height = ImageCache.getHeight(normal)
        tab.tooltips = tooltip
    }


    @Markers
    open class ButtonComponent : InterfaceComponent() {
        var spriteNormal = 0
        var spriteHover = -1
        var tooltip = ""
        var tooltips = emptyArray<String>()
        var textCopmponent : (Text.TextComponent.() -> Unit)? = null
        var spriteComponent : (Sprites.SpriteComponent.() -> Unit)? = null

        fun normal(bld: () -> Int) {
            this.spriteNormal = bld()
        }
        fun hover(bld: () -> Int) {
            this.spriteHover = bld()
        }
        fun tooltip(bld: () -> String) {
            this.tooltip = bld()
        }

        fun tooltips(bld: () -> Array<String>) {
            this.tooltips = bld()
        }

        fun text(bld: Text.TextComponent.() -> Unit) {
            this.textCopmponent = bld
        }
        fun sprite(bld: Sprites.SpriteComponent.() -> Unit) {
            this.spriteComponent = bld
        }
    }
}
