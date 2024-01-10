package com.client.graphics.interfaces.impl;

import com.client.TextDrawingArea;
import com.client.graphics.interfaces.RSInterface;

public class BPInterface extends RSInterface {

    public static void build(TextDrawingArea[] tda) {
        setupBP(tda);
    }

    private static void setupBP(TextDrawingArea[] tda) {
        char bulletSymbol='\u2023';
        RSInterface inter = addInterface(44000);

        addSprite(44001, 0, "Interfaces/Battlepass/BACKGROUND");
        addText(44002, "Vanguard 2024 BATTLE PASS - 25 Donator Tokens", tda, 2, 0xff9933, false, true);
        addText(44003, "Benefits", tda, 1, 0x2FD458, false, true);
        addText(44004, "- Double Vote Crystals From Voting", tda, 0, 0xcccccc, false, true);
        addText(44005, "- Double cash from Vote Boss", tda, 0, 0xcccccc, false, true);
        addText(44006, "- Cost of battle pass added towards donator rank", tda, 0, 0xcccccc, false, true);
        addText(44007, "- Loot quantity from corrupt slayer keys doubled", tda, 0, 0xcccccc, false, true);
        addText(44008, "- 3% drop rate boost", tda, 0, 0xcccccc, false, true);
        addText(44009, "- Higher CoX Rare Key Chance", tda, 0, 0xcccccc, false, true);
        addText(44010, "- Free Items: boost scroll set, random H'ween mask, 5 upgrade tokens", tda, 0, 0xcccccc, false, true);
        addText(44013, "- Automatically bury bones from npc drops", tda, 0, 0xcccccc, false, true);
        hoverButton(44011, "Purchase", 180, 181, "Purchase", rsFont, 0xff8a1f, 0xff8a1f, true);
        addHoverButton(44012, "Interfaces/CollectionLog/CLOSE", 0, 16, 16, "Close", -1, 39003, 3);

        inter.totalChildren(13);
        setBounds(44001, 4, 15, 0, inter);
        setBounds(44002, 80, 70, 1, inter);
        setBounds(44003, 230, 100, 2, inter);
        setBounds(44004, 48, 126, 3, inter);
        setBounds(44005, 48, 138, 4, inter);
        setBounds(44006, 48, 150, 5, inter);
        setBounds(44007, 48, 162, 6, inter);
        setBounds(44008, 48, 174, 7, inter);
        setBounds(44009, 48, 186, 8, inter);
        setBounds(44010, 48, 198, 9, inter);
        setBounds(44013, 48, 210, 12, inter);
        setBounds(44011, 210, 240, 10, inter);
        setBounds(44012, 478, 28, 11, inter);
    }


}
