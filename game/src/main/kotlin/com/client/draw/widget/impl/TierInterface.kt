package com.client.draw.widget.impl

import com.client.draw.widget.*
import com.client.draw.widget.components.Background
import com.client.draw.widget.components.Background.background
import com.client.draw.widget.components.Button.buttons
import com.client.draw.widget.components.ItemContainer.container
import com.client.draw.widget.components.Rasterizer.rasterizer
import com.client.draw.widget.components.Rasterizer.rasterizers
import com.client.draw.widget.components.Sprites.sprite
import com.client.draw.widget.components.Text
import com.client.draw.widget.components.Text.text
import com.client.draw.widget.components.Text.texts
import com.runescape.utils.Position

class TierInterface : Interface() {
    override fun load() {
        buildFrame()
        itemInfo()
        info()
        main()
    }

    private val category = listOf(
        "Upgrade",
        "Items",
        "Info"
    )

    val textOffset = listOf(
        Position(0,1),
        Position(0,0),
        Position(0,0)
    )

    private fun buildFrame() {
        buildInterface(45291,410,330,true) {

            background {
                width { 410 }
                height { 330 }
                title { "Item Upgrade" }
                devider { true }
                force { Background.ForceType.NEW }
                position { Position(0, 0) }
                closeButton { true }
            }

            rasterizer {
                setColours { Colors.SELECTION_BOX_OSRS }
                width { 84 }
                height { 280 }
                position { Position(10,40) }
            }

            rasterizer {
                setColours { listOf(0x2C2922,0x736551,0x4B4439) }
                width { 299 }
                height { 272 }
                position { Position(97,44) }
            }

            buttons(category.size,1,0,2) { idx ->
                normal { if(idx ==0) 23 else 24 }
                hover { if(idx ==0) 23 else 25 }
                position { Position(14,44) }
                tooltip { category[idx] }
            }

            sprite {
                id { 20 }
                position { Position(19,48) }
            }

            sprite {
                id { 21 }
                position { Position(19,76) }
            }

            sprite {
                id { 22 }
                position { Position(19,103) }
            }

            texts(category.size,1,0,20) { idx ->
                text { category[idx] }
                type { Text.FontType.SMALL }
                center { false }
                color { if(idx == 0) 0xFFDA72 else 0xFFBC00 }
                position { Position(40 + textOffset[idx].x,51 + textOffset[idx].y) }
            }

            text {
                type { Text.FontType.REGULAR }
                text { "Total Tokens\\n34" }
                color { Colors.GOLD }
                position { Position(10 + (84 / 2),280 + 10) }
            }

            widget {
                widgetID { 50809 }
                position { Position(99,46) }
            }

        }
    }

    fun main() {
        buildInterface(50809) {

            setName { "upgrade List" }

            rasterizer {
                width { 279 }
                height { 240 }
                setColours { listOf(0x2C2922,0x6F624F,0x000000) }
                position { Position(0,0) }
            }
            rasterizer {
                width { 295 }
                height { 21 }
                setColours { listOf(0x2C2922,0x6F624F,0x362F26) }
                position { Position(0,0) }
            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Tokens" }
                position { Position(211 + (68 / 2),2) }
            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Item" }
                position { Position(33 + (90 / 2),2) }
            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Progress" }
                position { Position(137 + (74 / 2),2) }
            }

            scroll(279,245,(35 * 28)) {
                rasterizers(28,1,0,35) { idx ->
                    width { 279 }
                    height { 35 }
                    setColour { if(idx % 2 == 0) 0x382E22 else 0x332A21 }
                    position { Position(0,0) }
                    setColourHover { if(idx % 2 == 0) 0x40362A else 0x3B3229 }
                    tooltip { "Upgrade" }
                }
                container {
                    width { 1 }
                    height { 28 }
                    paddingY { 3 }
                    position { Position(2,1) }
                }

                texts(28,1,0,26) {
                    text { "Item Name" }
                    color { Colors.GOLD }
                    center { false }
                    position { Position(36,12) }
                }

                texts(28,1,0,26) {
                    text { "1 / 5" }
                    color { Colors.WHITE }
                    position { Position(138 + (72 / 2),12) }
                }

                texts(28,1,0,26) {
                    text { "3.3k" }
                    color { 0xFFDA72 }
                    position { Position(211 + (67 / 2),12) }
                }

                position { Position(0,21) }
            }
        }
    }

    fun itemInfo() {
        buildInterface(50681) {
            setName { "itemInfo" }

            rasterizer {
                width { 138 }
                height { 268 }
                setColours { listOf(0x2C2922,0x6F624F,0x362F26) }
                position { Position(0,0) }
            }

            scroll(118,264,2000) {
                position { Position(2,2) }
                texts(60,1,0,10) {
                    text { "dfsdfsdf" }
                    color { 0xFFDA72 }
                    center { false }
                    type { Text.FontType.SMALL }
                    hover { Colors.GOLD }
                    width { 108 }
                    position { Position(3,3) }
                    tooltip { "Info" }
                }
            }

            scroll(158,264,0) {
                position { Position(120,0) }

                container {
                    width { 1 }
                    height { 1 }
                    paddingY { 2 }
                    position { Position(18,6) }
                }

                text {
                    text { "Rune Axe" }
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    center { false }
                    position { Position(56,5) }
                }

                text {
                    text { "A powerful axe." }
                    color { 0xFFB83F }
                    type { Text.FontType.SMALL }
                    center { false }
                    position { Position(57,24) }
                }

                text {
                    text { "Items:" }
                    color { 0xFFB83F }
                    type { Text.FontType.REGULAR }
                    center { false }
                    position { Position(18,42) }
                }

                text {
                    text { "- Dragon Axe (t5) (100 Tokens)" }
                    color { Colors.WHITE }
                    type { Text.FontType.SMALL }
                    center { false }
                    position { Position(18,61) }
                }

                text {
                    text { "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam" }
                    color { Colors.WHITE }
                    type { Text.FontType.SMALL }
                    center { false }
                    position { Position(18,61) }
                    width { 178 }
                }




            }

        }
    }

    fun info() {
        buildInterface(45145) {
            setName { " info" }

            scroll(279,266,300) {
                text {
                    color { Colors.GOLD }
                    width { 259 }
                    type { Text.FontType.REGULAR }
                    text { "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vel leo imperdiet, faucibus nisl eget, elementum erat. Integer scelerisque, quam quis vehicula feugiat, odio justo maximus lacus, vitae auctor ligula nisi porttitor neque. Praesent sagittis mauris id massa fringilla placerat. Mauris iaculis ornare risus. Fusce sed nisi volutpat, tempor neque eu, ultricies lacus. Phasellus tincidunt pharetra lorem, vel lacinia ex dapibus et. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi at mauris eget neque laoreet ultricies. Integer in mollis libero. Etiam tempor, purus ac posuere varius, nulla dolor pulvinar mauris, vitae imperdiet diam quam porta velit. Nullam congue quam ante, nec congue massa fermentum nec. Ut porttitor nisl nec magna sodales sollicitudin. In hac habitasse platea dictumst. Suspendisse ac justo id mauris semper scelerisque non eu tellus.\n" +
                            "\n" +
                            "Donec tincidunt ligula eget felis pellentesque, sed ornare sapien imperdiet. Sed accumsan dictum lorem ac rhoncus. Donec non est nisl. Suspendisse sit amet tincidunt nulla. Aenean nisi dolor, sodales id tempus non, imperdiet et lectus. Duis aliquam eget lectus vitae vulputate. Suspendisse sed arcu sit amet lorem ornare accumsan in sed leo. Proin at congue arcu. Mauris ac lectus justo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed feugiat turpis et arcu dapibus, id accumsan sem viverra. Aenean interdum eu lectus in sagittis.\n" +
                            "\n" +
                            "Ut auctor semper enim id tempor. In dictum, est quis ullamcorper rhoncus, nisl dui accumsan odio, eget faucibus augue tellus id lectus. Sed interdum, libero bibendum dapibus aliquam, mi nisi finibus justo, sed lacinia urna felis eget felis. In hac habitasse platea dictumst. Maecenas condimentum aliquet elit, in iaculis orci porta eu. Ut id volutpat nulla. Suspendisse augue justo, volutpat vel quam tempus, consequat vulputate nunc. Praesent lobortis pulvinar hendrerit. Morbi tellus est, dictum ut posuere eget, facilisis at ligula. Sed in vestibulum orci. Vivamus cursus turpis vitae lacinia dictum. Vivamus pretium orci in massa sagittis, in tempus eros varius. Curabitur accumsan ante eget maximus eleifend. Praesent erat odio, scelerisque varius nisl quis, fringilla hendrerit diam. Morbi sed blandit metus, at volutpat tellus.\n" +
                            "\n" +
                            "Quisque a pretium nunc, a fermentum dolor. Mauris varius urna vel sem euismod tincidunt. Quisque id vulputate nulla. Duis vitae dignissim dui. Curabitur egestas metus elit, in mollis elit fringilla eu. Integer vestibulum urna fringilla aliquet mollis. Sed viverra nisi non risus placerat convallis. Nullam nibh eros, blandit eu euismod at, placerat eget tortor. Fusce pulvinar lacus a ultrices semper.\n" +
                            "\n" +
                            "Nunc ut lacinia erat, nec pretium tellus. Proin erat ante, ultricies et efficitur a, consequat vel est. Maecenas vitae aliquet mauris, sed interdum elit. Cras vel lorem id sapien pellentesque pharetra quis quis ante. Duis tincidunt ex in sem faucibus euismod. Nam metus sem, congue in urna non, tempus aliquet ante. Maecenas vel lectus eget elit dapibus fermentum ut vitae ex. Pellentesque ornare suscipit dolor. Cras porta metus arcu." }
                    position { Position(279 / 2,2) }
                }

                position { Position(0,0) }
            }

        }
    }

}