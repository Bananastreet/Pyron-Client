package com.client.graphics.interfaces.impl;

import com.client.TextDrawingArea;
import com.client.graphics.interfaces.RSInterface;

public class UpgradeInterface extends RSInterface {

    public static void build(TextDrawingArea[] tda) {
        int interfaceId = 29000;
        int nameScrollId = 29020;
        int ingScrollId = 29080;
        RSInterface mode = addInterface(interfaceId);
        int index = 1;
        String dir = "Interfaces/Upgrade/sprite";
        addSprite(interfaceId + index++, 0, dir);
        configHoverButtonTest(interfaceId + index, "Close", dir, 1, 2, 2, 2, false, interfaceId + index++);

        addText(interfaceId + index++, "Item upgrade machine", tda, 2, 0xff9933, true, true);
        addText(interfaceId + index++, "", tda, 0, 0xff9933, true, true);
        addText(interfaceId + index++, "Items required:", tda, 1, 0xff9933, true, true);

        configHoverButtonTest(interfaceId + index, "Upgrade", dir, 3, 4, 4, 4, false, interfaceId + index++);
        addText(interfaceId + index++, "Upgrade", tda, 2, 0xff9933, true, true);

        addText(interfaceId + index++, "", tda, 1, 0xff9933, true, true);

        itemGroup(interfaceId + index++, 1, 1, 5, 3, true, true);

        configHoverButtonTest(29010, "View weapon upgrades", dir, 5, 6, 6, 6, false, 29011, 29012);
        configHoverButtonTest(29011, "View armour upgrades", dir, 5, 6, 6, 6, false, 29010, 29012);
        configHoverButtonTest(29012, "View misc upgrades", dir, 5, 6, 6, 6, false, 29010, 29011);

        addText(29013, "Weaponry", tda, 0, 0xff9933, true, true);
        addText(29014, "Armour", tda, 0, 0xff9933, true, true);
        addText(29015, "Misc", tda, 0, 0xff9933, true, true);
        addText(29016, "Safe item:", tda, 1, 0xff9933, true, true);
        addSprite(29017, 7, dir);
        itemGroup(29018, 1, 1, 5, 3, true, true);

        index = 0;
        int x = 60; int y = 47;
        mode.totalChildren(20);
        mode.child(index++, interfaceId + index, x, y); //BACKGROUND
        mode.child(index++, interfaceId + index, x + 375, y + 9); //CLOSE BUTTON

        mode.child(index++, interfaceId + index, x + 196, y + 9); //HEAD TEXT
        mode.child(index++, interfaceId + index, x + 88, y + 58); //CURRECY COSTS TEXT
        mode.child(index++, interfaceId + index, x + 270, y + 41); //ITEMS REQUIRED TEXT

        mode.child(index++, interfaceId + index, x + 273, y + 208); //UPGRADE BUTTON
        mode.child(index++, interfaceId + index, x + 314, y + 210); //UPGRADE TEXT

        mode.child(index++, interfaceId + index, x + 283+34, y + 186); //SUCCESS RATE

        mode.child(index++, interfaceId + index, x + 210, y + 203); //PREVIEW UPGRADE ITEM

        mode.child(index++, interfaceId + index, x + 9, y + 40); //HOVERBUTTON
        mode.child(index++, interfaceId + index, x + 73, y + 40); //HOVERBUTTON
        mode.child(index++, interfaceId + index, x + 136, y + 40); //HOVERBUTTON

        mode.child(index++, interfaceId + index, x + 40, y + 44); //WEAPONRY
        mode.child(index++, interfaceId + index, x + 103, y + 44); //ARMOUR
        mode.child(index++, interfaceId + index, x + 167, y + 44); //PETS
        mode.child(index++, interfaceId + index, x + 283, y + 156); //safe item
        mode.child(index++, interfaceId + index, x + 283 + 34, y + 144); //Safe item container
        mode.child(index++, interfaceId + index, x + 283 + 41, y + 149); //item group safe item
        mode.child(index++, nameScrollId, x + 10, y + 66);

        mode.child(index++, ingScrollId, x + 208, y + 66);

        RSInterface nameScroll = addTabInterface(nameScrollId);
        int totalBoxes = 50;
        nameScroll.width = 172;
        nameScroll.height = 175;
        nameScroll.scrollMax = nameScroll.height + 1;

        nameScroll.totalChildren(totalBoxes);
        nameScrollId++;
        index = 0; x = 0; y = 0;
        for(int i = 0; i < totalBoxes; i++) {
            addClickableText(nameScrollId, "Item name", "View upgrade", tda, 0, 0xff9933, false, true, 165);
            nameScroll.child(index++, nameScrollId++, x + 2, y + 2);
            y += 14;
        }
        nameScroll.scrollMax = y;

        RSInterface ingScroll = addTabInterface(ingScrollId);
        ingScroll.width = 167;
        ingScroll.height = 72;
        ingScroll.scrollMax = 120;

        ingScroll.totalChildren(1);
        ingScrollId++;
        index = 0; x = 0; y = 0;
        itemGroup(ingScrollId, 4, 2, 7, 3, true, true);
        ingScroll.child(index, ingScrollId, x + 4, y + 2);
    }

}
