package com.client.graphics.interfaces.impl;

import com.client.TextDrawingArea;
import com.client.graphics.interfaces.RSInterface;

public class SigilsInterface extends RSInterface {

    public static void build(TextDrawingArea[] tda) {
        setupInterface(tda);
    }

    private static void setupInterface(TextDrawingArea[] tda) {
        RSInterface inter = addInterface(46000);
        char bulletSymbol='\u2023';

        addSprite(46001, 0, "Interfaces/Collectionlog/BACKGROUND");
        addHoverButton(46002, "Interfaces/CollectionLog/CLOSE", 0, 16, 16, "Close", -1, 39003, 3);
        addHoveredButton(46003, "Interfaces/CollectionLog/CLOSE", 1, 16, 16, 39005);
        addText(46004, "Sigils of Vanguard", tda, 1, 0xff9933, true, true);
        addItemContainer(46005, 1, 1, 0, 0, true);
        addText(46006, "Sigil title", tda, 2, 0x2FD458, true, true);
        addText(46007, "Information", tda, 2, 0xff9933, false, true);
        addText(46008, "Information line 1", tda, 1, 0xff9933, false, false);
        addText(46009, "Information line 2", tda, 1, 0xff9933, false, false);
        addText(46010, "Information line 3", tda, 1, 0xff9933, false, false);
        addText(46011, "Obtaining", tda, 2, 0xff9933, false, true);
        addText(46012, "Obtaining line 1", tda, 1, 0xff9933, false, false);
        addText(46013, "Obtaining line 2", tda, 1, 0xff9933, false, false);
        addText(46014, "Obtaining line 3", tda, 1, 0xff9933, false, false);
        addClickableText(46015, "Sigil 1", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46016, "Sigil 2", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46017, "Sigil 3", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46018, "Sigil 4", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46019, "Sigil 5", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46020, "Sigil 6", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46021, "Sigil 7", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46022, "Sigil 8", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46023, "Sigil 9", "Information", tda, 1, 0xff9933, false, true, 200);
        addClickableText(46024, "Sigil 10", "Information", tda, 1, 0xff9933, false, true, 200);

        inter.totalChildren(24);
        setBounds(46001, 15, 15, 0, inter);
        setBounds(46002, 478, 25, 1, inter);
        setBounds(46003, 478, 25, 2, inter);
        setBounds(46004, 268, 25, 3, inter);
        setBounds(46005, 349, 75, 4, inter);
        setBounds(46006, 268, 52, 5, inter);
        setBounds(46007, 242, 123, 6, inter);
        setBounds(46008, 242, 143, 7, inter);
        setBounds(46009, 242, 163, 8, inter);
        setBounds(46010, 242, 183, 9, inter);
        setBounds(46011, 242, 213, 10, inter);
        setBounds(46012, 242, 233, 11, inter);
        setBounds(46013, 242, 253, 12, inter);
        setBounds(46014, 242, 273, 13, inter);
        setBounds(46015, 31, 78, 14, inter);
        setBounds(46016, 31, 98, 15, inter);
        setBounds(46017, 31, 118, 16, inter);
        setBounds(46018, 31, 138, 17, inter);
        setBounds(46019, 31, 158, 18, inter);
        setBounds(46020, 31, 178, 19, inter);
        setBounds(46021, 31, 198, 20, inter);
        setBounds(46022, 31, 218, 21, inter);
        setBounds(46023, 31, 238, 22, inter);
        setBounds(46024, 31, 258, 23, inter);

    }


}
