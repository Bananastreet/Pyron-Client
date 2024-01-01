package com.client.draw.widget.impl

import com.client.draw.widget.*
import com.client.draw.widget.components.Background
import com.client.draw.widget.components.Background.background
import com.client.draw.widget.components.Button.button
import com.client.draw.widget.components.Button.buttons
import com.client.draw.widget.components.Divider.divider
import com.client.draw.widget.components.ItemContainer.container
import com.client.draw.widget.components.Rasterizer.rasterizer
import com.client.draw.widget.components.Rasterizer.rasterizers
import com.client.draw.widget.components.Sprites.sprite
import com.client.draw.widget.components.Text
import com.client.draw.widget.components.Text.text
import com.client.draw.widget.components.Text.texts
import com.runescape.utils.Position

class LeaderboardInterface : Interface() {
    override fun load() {
        buildInterface()
        rankSelection()
    }


    val ranks = listOf("All","All Rogue","Standard","Iron Man","Ultimate Iron Man","HC Iron Man","Rogue","Rogue HC Iron Man","Rogue Iron Man", "Group Ironman")

    private fun rankSelection() {
        buildInterface(59820,219,290,true) {
            background {
                width { 219 }
                height { 290 }
                title { "Rank Selection" }
                devider { true }
                force { Background.ForceType.NEW }
                position { Position(0, 0) }
                closeButton { true }
            }
            scroll(190,246,247) {
                position { Position(7, 37) }
                rasterizers(ranks.size, 1, 0, 25) { idx ->
                    width { 190 }
                    height { 25 }
                    setColour { if (idx % 2 == 0) 0x382E22 else 0x332A21 }
                    position { Position(0, 0) }
                    setColourHover { if(idx % 2 == 0) 0x40362A else 0x3B3229 }
                    tooltip { ranks[idx] }
                }

                texts(ranks.size,1,0,16) { idx ->
                    text { ranks[idx] }
                    color { 0xFFDA72 }
                    type { Text.FontType.REGULAR }
                    position { Position(190 / 2,4) }
                }

            }
        }
    }

    private fun buildInterface() {
        buildInterface(46025,500,313,true) {

            background {
                width { 500 }
                height { 313 }
                title { "Leaderboards" }
                devider { true }
                force { Background.ForceType.NEW }
                position { Position(0, 0) }
                closeButton { true }
            }

            rasterizer {
                width { 486 }
                height { 268 }
                setColour { 0x473D32 }
                position { Position(7,37) }
            }

            rasterizer {
                width { 486 }
                height { 1 }
                setColour { 0x000000 }
                position { Position(7,58) }
            }

            button {
                normal { 30 }
                hover { 31 }
                tooltip { "Bosses" }
                position { Position(26,37) }
                text {
                    text { "Bosses" }
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    position { Position(108 / 2,4) }
                }
            }

            button {
                normal { 30 }
                hover { 31 }
                tooltip { "Raids" }
                position { Position(140,37) }
                text {
                    text { "Raids" }
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    position { Position(108 / 2,4) }
                }
            }

            button {
                normal { 30 }
                hover { 31 }
                tooltip { "Mystery Boxes" }
                position { Position(253,37) }
                text {
                    text { "Mystery Boxes" }
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    position { Position(108 / 2,4) }
                }
            }

            button {
                normal { 30 }
                hover { 31 }
                tooltip { "Miscellaneous" }
                position { Position(366,37) }
                text {
                    text { "Miscellaneous" }
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    position { Position(108 / 2,4) }
                }
            }

            divider {
                size { 486 }
                force { Background.ForceType.NEW }
                position { Position(7,272) }
            }

            rasterizer {
                width { 126 }
                height { 211 }
                setColours { listOf(0x000000,0x6F624F,0x362F26) }
                position { Position(8,60) }
            }

            rasterizer {
                width { 126 }
                height { 21 }
                setColours { listOf(0x2C2922,0x6F624F,0x362F26) }
                position { Position(8,60) }
            }

            text {
                text { "Bosses" }
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                position { Position(8 + (126 / 2),63) }
            }

            scroll(106,185,2000) {
                position { Position(10,83) }
                texts(60,1,0,12) {
                    text { "dfsdfsdf" }
                    color { 0xFFDA72 }
                    center { false }
                    type { Text.FontType.REGULAR }
                    hover { Colors.GOLD }
                    width { 108 }
                    position { Position(3,3) }
                    tooltip { "View" }
                }
            }

            val offsetX = 135
            val offsetY = 60

            rasterizer {
                width { 341 }
                height { 211 }
                setColours { listOf(0x2C2922,0x6F624F,0x000000) }
                position { Position(offsetX,offsetY) }
            }
            rasterizer {
                width { 357 }
                height { 21 }
                setColours { listOf(0x2C2922,0x6F624F,0x362F26) }
                position { Position(offsetX,offsetY) }
            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Rank" }
                center { false }
                position { Position(offsetX + 8,2 + offsetY) }
            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Name" }
                position { Position(33 + (90 / 2)  + offsetX + 80,2  + offsetY) }
            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Amount" }
                position { Position(137 + (74 / 2)  + offsetX + 140,2  + offsetY) }
            }

            scroll(341,190,(35 * 25)) {
                position { Position(offsetX,offsetY + 21) }
                rasterizers(35,1,0,25) { idx ->
                    width { 341 }
                    height { 25 }
                    setColour { if(idx % 2 == 0) 0x382E22 else 0x332A21 }
                    position { Position(0,0) }
                }

                texts(35,1,0,16) {
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    text { "--" }
                    center { false }
                    position { Position( 12,5) }
                }

                texts(35,1,0,16) {
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    text { "--" }
                    position { Position(33 + (90 / 2) + 80,5) }
                }

                texts(35,1,0,16) {idx ->
                    color { Colors.GOLD }
                    type { Text.FontType.REGULAR }
                    text { "--" }
                    position { Position(137 + (74 / 2) + 139,5) }
                }

            }

            text {
                color { Colors.GOLD }
                type { Text.FontType.REGULAR }
                text { "Page 1/20" }
                position { Position(138 + (353 / 2),285) }
            }

            button {
                normal { 33 }
                hover { 34 }
                tooltip { "Previous" }
                position { Position(138,281) }
            }

            button {
                normal { 35 }
                hover { 36 }
                tooltip { "Next" }
                position { Position(461,281) }
            }

        }
    }

}