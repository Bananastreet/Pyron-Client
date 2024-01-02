package com.client.definitions;

import com.client.*;
import com.client.utilities.FileOperations;
import com.google.common.base.Preconditions;
import net.runelite.api.IterableHashTable;
import net.runelite.rs.api.RSItemComposition;
import net.runelite.rs.api.RSIterableNodeHashTable;

import java.util.HashMap;

public final class ItemDefinition implements RSItemComposition {

    public static ReferenceCache sprites = new ReferenceCache(100);
    public static ReferenceCache models = new ReferenceCache(50);
    public static boolean isMembers = true;
    public static int totalItems;
    public static ItemDefinition[] cache;
    private static int cacheIndex;
    private static Buffer item_data;
    private static int[] streamIndices;
    public int cost;
    public int[] colorReplace;
    public int id;
    public int[] colorFind;
    public boolean members;
    public int noted_item_id;
    public int femaleModel1;
    public int maleModel0;
    public String[] options;
    public int xOffset2d;
    public String name;
    public int modelId;
    public int maleHeadModel;
    public boolean stackable;
    public int unnoted_item_id;
    public int zoom2d;
    public int maleModel1;
    public String[] interfaceOptions;
    public int xan2d;
    public int[] countObj;
    public int yOffset2d;//
    public int femaleHeadModel;
    public int yan2d;
    public int femaleModel0;
    public int[] countCo;
    public int team;
    public int zan2d;
    public String[] equipActions;
    public boolean tradeable;
    public HashMap<Integer, Object> params;
    public int glowColor = -1;
    private short[] textureReplace;
    private short[] textureFind;
    private byte femaleOffset;
    private int femaleModel2;
    private int maleHeadModel2;
    private int resizeX;
    private int femaleHeadModel2;
    private int contrast;
    private int maleModel2;
    private int resizeZ;
    private int resizeY;
    private int ambient;
    private byte maleOffset;
    private int shiftClickIndex = -2;
    private int category;
    private int bought_id;
    private int bought_template_id;
    private int placeholder_id;
    private int placeholder_template_id;

    private ItemDefinition() {
        id = -1;
    }

    public void createCustomSprite(String img) {
        customSpriteLocation = getCustomSprite(img);
    }

    public void createSmallCustomSprite(String img) {
        customSmallSpriteLocation = getCustomSprite(img);
    }

    public String getName(int itemID) {
        return name;
    }


    private byte[] getCustomSprite(String img) {
        String location = (Sprite.location + Configuration.CUSTOM_ITEM_SPRITES_DIRECTORY + img).toLowerCase();
        byte[] spriteData = FileOperations.readFile(location);
        Preconditions.checkState(spriteData != null, "No sprite: " + location);
        return spriteData;
    }

    public byte[] customSpriteLocation;
    public byte[] customSmallSpriteLocation;


    public static void clear() {
        models = null;
        sprites = null;
        streamIndices = null;
        cache = null;
        item_data = null;
    }

    public static void init(FileArchive archive) {
        item_data = new Buffer(archive.readFile("obj.dat"));
        Buffer stream = new Buffer(archive.readFile("obj.idx"));

        totalItems = stream.readUShort();
        streamIndices = new int[totalItems + 30_000];
        int offset = 2;

        for (int _ctr = 0; _ctr < totalItems; _ctr++) {
            streamIndices[_ctr] = offset;
            offset += stream.readUShort();
        }

        cache = new ItemDefinition[10];

        for (int _ctr = 0; _ctr < 10; _ctr++) {
            cache[_ctr] = new ItemDefinition();
        }

        System.out.println("Loaded: " + totalItems + " items");
    }

    public int weight;
    public int wearPos1;
    public int wearPos2;
    public int wearPos3;

    public static ItemDefinition copy(ItemDefinition itemDef, int newId, int copyingItemId, String newName, String... actions) {
        ItemDefinition copyItemDef = lookup(copyingItemId);
        itemDef.id = newId;
        itemDef.name = newName;
        itemDef.colorFind = copyItemDef.colorFind;
        itemDef.colorReplace = copyItemDef.colorReplace;
        itemDef.modelId = copyItemDef.modelId;
        itemDef.maleModel0 = copyItemDef.maleModel0;
        itemDef.femaleModel0 = copyItemDef.femaleModel0;
        itemDef.zoom2d = copyItemDef.zoom2d;
        itemDef.xan2d = copyItemDef.xan2d;
        itemDef.yan2d = copyItemDef.yan2d;
        itemDef.xOffset2d = copyItemDef.xOffset2d;
        itemDef.yOffset2d = copyItemDef.yOffset2d;
        itemDef.interfaceOptions = copyItemDef.interfaceOptions;
        itemDef.interfaceOptions = new String[5];
        if (actions != null) {
            for (int index = 0; index < actions.length; index++) {
                itemDef.interfaceOptions[index] = actions[index];
            }
        }
        return itemDef;
    }


    private static void customItems(int itemId) {
        ItemDefinition itemDef = lookup(itemId);

        switch (itemId) {
            case 75:
                ItemDefinition trinketOne = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 75;
                itemDef.name = "Trinket of luck";
                itemDef.modelId = trinketOne.modelId;
                itemDef.xan2d = trinketOne.xan2d;
                itemDef.zoom2d = trinketOne.zoom2d;
                itemDef.yan2d = trinketOne.yan2d;
                itemDef.yOffset2d = trinketOne.yOffset2d;
                itemDef.xOffset2d = trinketOne.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{1030, 1050, 1030, 1050, 7114};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 76:
                ItemDefinition trinketTwo = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 76;
                itemDef.name = "Trinket of vengeance";
                itemDef.modelId = trinketTwo.modelId;
                itemDef.xan2d = trinketTwo.xan2d;
                itemDef.zoom2d = trinketTwo.zoom2d;
                itemDef.yan2d = trinketTwo.yan2d;
                itemDef.yOffset2d = trinketTwo.yOffset2d;
                itemDef.xOffset2d = trinketTwo.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{1030, 1050, 1030, 1050, 675};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 77:
                ItemDefinition trinketThree = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 77;
                itemDef.name = "Trinket of protection";
                itemDef.modelId = trinketThree.modelId;
                itemDef.xan2d = trinketThree.xan2d;
                itemDef.zoom2d = trinketThree.zoom2d;
                itemDef.yan2d = trinketThree.yan2d;
                itemDef.yOffset2d = trinketThree.yOffset2d;
                itemDef.xOffset2d = trinketThree.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{1030, 1050, 1030, 1050, 689484};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 78:
                ItemDefinition trinketFour = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 78;
                itemDef.name = "Trinket of the ninja";
                itemDef.modelId = trinketFour.modelId;
                itemDef.xan2d = trinketFour.xan2d;
                itemDef.zoom2d = trinketFour.zoom2d;
                itemDef.yan2d = trinketFour.yan2d;
                itemDef.yOffset2d = trinketFour.yOffset2d;
                itemDef.xOffset2d = trinketFour.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{1030, 1050, 1030, 1050, 50000};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 79:
                ItemDefinition trinketFive = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 79;
                itemDef.name = "Trinket of superiority";
                itemDef.modelId = trinketFive.modelId;
                itemDef.xan2d = trinketFive.xan2d;
                itemDef.zoom2d = trinketFive.zoom2d;
                itemDef.yan2d = trinketFive.yan2d;
                itemDef.yOffset2d = trinketFive.yOffset2d;
                itemDef.xOffset2d = trinketFive.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{1030, 1050, 1030, 1050, 9583};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 80:
                ItemDefinition trinketSix = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 80;
                itemDef.name = "Trinket of tricks";
                itemDef.modelId = trinketSix.modelId;
                itemDef.xan2d = trinketSix.xan2d;
                itemDef.zoom2d = trinketSix.zoom2d;
                itemDef.yan2d = trinketSix.yan2d;
                itemDef.yOffset2d = trinketSix.yOffset2d;
                itemDef.xOffset2d = trinketSix.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{6073, 6093, 6073, 6093, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 81:
                ItemDefinition trinketSeven = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 81;
                itemDef.name = "Trinket of experience";
                itemDef.modelId = trinketSeven.modelId;
                itemDef.xan2d = trinketSeven.xan2d;
                itemDef.zoom2d = trinketSeven.zoom2d;
                itemDef.yan2d = trinketSeven.yan2d;
                itemDef.yOffset2d = trinketSeven.yOffset2d;
                itemDef.xOffset2d = trinketSeven.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{350, 370, 350, 370, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 82:
                ItemDefinition trinketEight = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 82;
                itemDef.name = "Trinket of the undead";
                itemDef.modelId = trinketEight.modelId;
                itemDef.xan2d = trinketEight.xan2d;
                itemDef.zoom2d = trinketEight.zoom2d;
                itemDef.yan2d = trinketEight.yan2d;
                itemDef.yOffset2d = trinketEight.yOffset2d;
                itemDef.xOffset2d = trinketEight.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{43297, 43277, 43297, 43277, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 83:
                ItemDefinition trinketNine = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 83;
                itemDef.name = "Trinket of advanced weaponry";
                itemDef.modelId = trinketNine.modelId;
                itemDef.xan2d = trinketNine.xan2d;
                itemDef.zoom2d = trinketNine.zoom2d;
                itemDef.yan2d = trinketNine.yan2d;
                itemDef.yOffset2d = trinketNine.yOffset2d;
                itemDef.xOffset2d = trinketNine.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{9583, 9563, 9583, 9563, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 84:
                ItemDefinition trinketTen = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 84;
                itemDef.name = "Trinket of escape";
                itemDef.modelId = trinketTen.modelId;
                itemDef.xan2d = trinketTen.xan2d;
                itemDef.zoom2d = trinketTen.zoom2d;
                itemDef.yan2d = trinketTen.yan2d;
                itemDef.yOffset2d = trinketTen.yOffset2d;
                itemDef.xOffset2d = trinketTen.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{6850, 6870, 6850, 6870, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 85:
                ItemDefinition trinketEleven = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 85;
                itemDef.name = "Trinket of essence";
                itemDef.modelId = trinketEleven.modelId;
                itemDef.xan2d = trinketEleven.xan2d;
                itemDef.zoom2d = trinketEleven.zoom2d;
                itemDef.yan2d = trinketEleven.yan2d;
                itemDef.yOffset2d = trinketEleven.yOffset2d;
                itemDef.xOffset2d = trinketEleven.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{7833, 7853, 7833, 7853, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 86:
                ItemDefinition trinketTwelve = lookup(26544);
                itemDef.setDefaults();
                itemDef.id = 86;
                itemDef.name = "Trinket of restoration";
                itemDef.modelId = trinketTwelve.modelId;
                itemDef.xan2d = trinketTwelve.xan2d;
                itemDef.zoom2d = trinketTwelve.zoom2d;
                itemDef.yan2d = trinketTwelve.yan2d;
                itemDef.yOffset2d = trinketTwelve.yOffset2d;
                itemDef.xOffset2d = trinketTwelve.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{40458, 40210, 40094, 40103, 29656};
                itemDef.colorFind = new int[]{38693, 38673, 38693, 38673, 0};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 87:
                ItemDefinition serverBoostScroll = lookup(21259);
                itemDef.setDefaults();
                itemDef.id = 87;
                itemDef.name = "@red@Server Boost Scroll";
                itemDef.modelId = serverBoostScroll.modelId;
                itemDef.xan2d = serverBoostScroll.xan2d;
                itemDef.zoom2d = serverBoostScroll.zoom2d;
                itemDef.yan2d = serverBoostScroll.yan2d;
                itemDef.yOffset2d = serverBoostScroll.yOffset2d;
                itemDef.xOffset2d = serverBoostScroll.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;

            case 90:
                ItemDefinition trinketMBOX = lookup(6199);
                itemDef.setDefaults();
                itemDef.id = 90;
                itemDef.name = "Trinket Mystery Box";
                itemDef.modelId = trinketMBOX.modelId;
                itemDef.xan2d = trinketMBOX.xan2d;
                itemDef.zoom2d = trinketMBOX.zoom2d;
                itemDef.yan2d = trinketMBOX.yan2d;
                itemDef.yOffset2d = trinketMBOX.yOffset2d;
                itemDef.xOffset2d = trinketMBOX.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{22410, 2999};
                itemDef.colorFind = new int[]{0, 17350};
                itemDef.glowColor = 35;
                break;

            case 3692:
                ItemDefinition instance = lookup(22324);
                itemDef.modelId = 35739;
                itemDef.name = "Ghrazi rapier @gre@T2";

                itemDef.zoom2d = instance.zoom2d;
                itemDef.xan2d = instance.xan2d;
                itemDef.yan2d = instance.yan2d;
                itemDef.zan2d = instance.zan2d;
                itemDef.yOffset2d = instance.yOffset2d;
                itemDef.xOffset2d = instance.xOffset2d;

                itemDef.maleModel0 = 35374;
                itemDef.femaleModel0 = 35369;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null; //43113: part of blade, 43090: rest of the blade
                itemDef.interfaceOptions[4] = "Drop"; // 43034, 64414, 43047, 43059, 43090, 43113
                itemDef.colorReplace = new int[]{43113, 43090};
                itemDef.colorFind = new int[]{3008, 3008};
                break;
            case 3693:
                itemDef.name = "Boots of Zenith @gre@T1";
                itemDef.modelId = 36151;
                itemDef.maleModel0 = 36324;
                itemDef.femaleModel0 = 36333;
                itemDef.zoom2d = 880;
                itemDef.xan2d = 135;
                itemDef.yan2d = 228;
                itemDef.yOffset2d = 2;
                itemDef.xOffset2d = -3;
                itemDef.cost = 20000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{111, 40103, 40111, 40214, 40334, 12213, 12221, 127};
                itemDef.colorFind = new int[]{1075, 0, 1075, 1075, 1075, 1075, 0, 0};
                break;
            case 3735:
                itemDef.name = "Boots of Zenith @gre@T2";
                itemDef.modelId = 36151;
                itemDef.maleModel0 = 36324;
                itemDef.femaleModel0 = 36333;
                itemDef.zoom2d = 880;
                itemDef.xan2d = 135;
                itemDef.yan2d = 228;
                itemDef.yOffset2d = 2;
                itemDef.xOffset2d = -3;
                itemDef.cost = 20000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{111, 40103, 40111, 40214, 40334, 12213, 12221, 127};
                itemDef.colorFind = new int[]{7833, 0, 7833, 7833, 7833, 7833, 0, 0};
                break;
            case 3736:
                itemDef.name = "Boots of Zenith @gre@T3";
                itemDef.modelId = 36151;
                itemDef.maleModel0 = 36324;
                itemDef.femaleModel0 = 36333;
                itemDef.zoom2d = 880;
                itemDef.xan2d = 135;
                itemDef.yan2d = 228;
                itemDef.yOffset2d = 2;
                itemDef.xOffset2d = -3;
                itemDef.cost = 20000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{111, 40103, 40111, 40214, 40334, 12213, 12221, 127};
                itemDef.colorFind = new int[]{43297, 0, 43297, 43297, 43297, 43297, 0, 0};
                break;
            case 3737:
                itemDef.name = "Boots of Zenith @gre@T4";
                itemDef.modelId = 36151;
                itemDef.maleModel0 = 36324;
                itemDef.femaleModel0 = 36333;
                itemDef.zoom2d = 880;
                itemDef.xan2d = 135;
                itemDef.yan2d = 228;
                itemDef.yOffset2d = 2;
                itemDef.xOffset2d = -3;
                itemDef.cost = 20000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{111, 40103, 40111, 40214, 40334, 12213, 12221, 127};
                itemDef.colorFind = new int[]{6073, 0, 6073, 6073, 6073, 6073, 0, 0};
                break;
            case 3738:
                itemDef.name = "Boots of Zenith @gre@T5";
                itemDef.modelId = 36151;
                itemDef.maleModel0 = 36324;
                itemDef.femaleModel0 = 36333;
                itemDef.zoom2d = 880;
                itemDef.xan2d = 135;
                itemDef.yan2d = 228;
                itemDef.yOffset2d = 2;
                itemDef.xOffset2d = -3;
                itemDef.cost = 20000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{111, 40103, 40111, 40214, 40334, 12213, 12221, 127};
                itemDef.colorFind = new int[]{9583, 0, 9583, 9583, 9583, 9583, 0, 0};
                break;
            case 6119:
                itemDef.name = "Bank space stone";
                itemDef.interfaceOptions = new String[]{null, null, "Redeem", null, null,};
                break;
            case 23842:
                itemDef.name = "Crystal helm @gre@T2";
                break;
            case 23845:
                itemDef.name = "Crystal body @gre@T2";
                break;
            case 23848:
                itemDef.name = "Crystal legs @gre@T2";
                break;
            case 3697:
                itemDef.name = "Pink partyhat";
                itemDef.modelId = 2635;
                itemDef.maleModel0 = 187;
                itemDef.femaleModel0 = 363;
                itemDef.zoom2d = 440;
                itemDef.xan2d = 76;
                itemDef.yan2d = 1852;
                itemDef.yOffset2d = 1;
                itemDef.xOffset2d = 1;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{350};
                break;
            case 3698:
                itemDef.name = "Lava partyhat";
                itemDef.modelId = 2635;
                itemDef.maleModel0 = 187;
                itemDef.femaleModel0 = 363;
                itemDef.zoom2d = 440;
                itemDef.xan2d = 76;
                itemDef.yan2d = 1852;
                itemDef.yOffset2d = 1;
                itemDef.xOffset2d = 1;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{6073};
                break;
            case 13173:
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Open";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                break;
            case 3699:
                itemDef.name = "Sky blue partyhat";
                itemDef.modelId = 2635;
                itemDef.maleModel0 = 187;
                itemDef.femaleModel0 = 363;
                itemDef.zoom2d = 440;
                itemDef.xan2d = 76;
                itemDef.yan2d = 1852;
                itemDef.yOffset2d = 1;
                itemDef.xOffset2d = 1;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{689484};
                break;
            case 3700:
                ItemDefinition copyItemDefHween1 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "Cyan H'ween mask";
                itemDef.modelId = copyItemDefHween1.modelId;
                itemDef.maleModel0 = copyItemDefHween1.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween1.femaleModel0;
                itemDef.zoom2d = copyItemDefHween1.zoom2d;
                itemDef.xan2d = copyItemDefHween1.xan2d;
                itemDef.yan2d = copyItemDefHween1.yan2d;
                itemDef.yOffset2d = copyItemDefHween1.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween1.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{689484};
                break;
            case 3701:
                ItemDefinition copyItemDefSkeleBoots = lookup(9921);
                itemDef.setDefaults();
                itemDef.name = "Cyan skeletal boots";
                itemDef.modelId = copyItemDefSkeleBoots.modelId;
                itemDef.maleModel0 = copyItemDefSkeleBoots.maleModel0;
                itemDef.femaleModel0 = copyItemDefSkeleBoots.femaleModel0;
                itemDef.zoom2d = copyItemDefSkeleBoots.zoom2d;
                itemDef.xan2d = copyItemDefSkeleBoots.xan2d;
                itemDef.yan2d = copyItemDefSkeleBoots.yan2d;
                itemDef.yOffset2d = copyItemDefSkeleBoots.yOffset2d;
                itemDef.xOffset2d = copyItemDefSkeleBoots.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 70, 127};
                itemDef.colorFind = new int[]{0, 689484, 689484};
                break;
            case 3702:
                ItemDefinition copyItemDefSkeleGloves = lookup(9922);
                itemDef.setDefaults();
                itemDef.name = "Cyan skeletal gloves";
                itemDef.modelId = copyItemDefSkeleGloves.modelId;
                itemDef.maleModel0 = copyItemDefSkeleGloves.maleModel0;
                itemDef.femaleModel0 = copyItemDefSkeleGloves.femaleModel0;
                itemDef.zoom2d = copyItemDefSkeleGloves.zoom2d;
                itemDef.xan2d = copyItemDefSkeleGloves.xan2d;
                itemDef.yan2d = copyItemDefSkeleGloves.yan2d;
                itemDef.yOffset2d = copyItemDefSkeleGloves.yOffset2d;
                itemDef.xOffset2d = copyItemDefSkeleGloves.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 70, 127};
                itemDef.colorFind = new int[]{0, 689484, 689484};
                break;
            case 3703:
                ItemDefinition copyItemDefSkeleLeggings = lookup(9923);
                itemDef.setDefaults();
                itemDef.name = "Cyan skeletal leggings";
                itemDef.modelId = copyItemDefSkeleLeggings.modelId;
                itemDef.maleModel0 = copyItemDefSkeleLeggings.maleModel0;
                itemDef.femaleModel0 = copyItemDefSkeleLeggings.femaleModel0;
                itemDef.zoom2d = copyItemDefSkeleLeggings.zoom2d;
                itemDef.xan2d = copyItemDefSkeleLeggings.xan2d;
                itemDef.yan2d = copyItemDefSkeleLeggings.yan2d;
                itemDef.yOffset2d = copyItemDefSkeleLeggings.yOffset2d;
                itemDef.xOffset2d = copyItemDefSkeleLeggings.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 70, 127};
                itemDef.colorFind = new int[]{0, 689484, 689484};
                break;
            case 3704:
                ItemDefinition copyItemDefSkeleShirt = lookup(9924);
                itemDef.setDefaults();
                itemDef.name = "Cyan skeletal shirt";
                itemDef.modelId = copyItemDefSkeleShirt.modelId;
                itemDef.maleModel0 = copyItemDefSkeleShirt.maleModel0;
                itemDef.femaleModel0 = copyItemDefSkeleShirt.femaleModel0;
                itemDef.maleModel1 = copyItemDefSkeleShirt.maleModel1;
                itemDef.maleModel2 = copyItemDefSkeleShirt.maleModel2;
                itemDef.femaleModel1 = copyItemDefSkeleShirt.femaleModel1;
                itemDef.femaleModel2 = copyItemDefSkeleShirt.femaleModel2;
                itemDef.zoom2d = copyItemDefSkeleShirt.zoom2d;
                itemDef.xan2d = copyItemDefSkeleShirt.xan2d;
                itemDef.yan2d = copyItemDefSkeleShirt.yan2d;
                itemDef.yOffset2d = copyItemDefSkeleShirt.yOffset2d;
                itemDef.xOffset2d = copyItemDefSkeleShirt.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 70, 59515, 127};
                itemDef.colorFind = new int[]{0, 689484, 689484, 689484};
                break;
            case 3705:
                ItemDefinition copyItemDefSkeleMask = lookup(9925);
                itemDef.setDefaults();
                itemDef.name = "Cyan skeletal mask";
                itemDef.modelId = copyItemDefSkeleMask.modelId;
                itemDef.maleModel0 = copyItemDefSkeleMask.maleModel0;
                itemDef.femaleModel0 = copyItemDefSkeleMask.femaleModel0;
                itemDef.zoom2d = copyItemDefSkeleMask.zoom2d;
                itemDef.xan2d = copyItemDefSkeleMask.xan2d;
                itemDef.yan2d = copyItemDefSkeleMask.yan2d;
                itemDef.yOffset2d = copyItemDefSkeleMask.yOffset2d;
                itemDef.xOffset2d = copyItemDefSkeleMask.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 24, 70, 59515};
                itemDef.colorFind = new int[]{0, 689484, 689484, 689484};
                break;
            case 3706:
                ItemDefinition copyItemDefHween2 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "Gold H'ween mask";
                itemDef.modelId = copyItemDefHween2.modelId;
                itemDef.maleModel0 = copyItemDefHween2.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween2.femaleModel0;
                itemDef.zoom2d = copyItemDefHween2.zoom2d;
                itemDef.xan2d = copyItemDefHween2.xan2d;
                itemDef.yan2d = copyItemDefHween2.yan2d;
                itemDef.yOffset2d = copyItemDefHween2.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween2.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{7114};
                break;
            case 3707:
                ItemDefinition copyItemDefHween3 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "Pink H'ween mask";
                itemDef.modelId = copyItemDefHween3.modelId;
                itemDef.maleModel0 = copyItemDefHween3.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween3.femaleModel0;
                itemDef.zoom2d = copyItemDefHween3.zoom2d;
                itemDef.xan2d = copyItemDefHween3.xan2d;
                itemDef.yan2d = copyItemDefHween3.yan2d;
                itemDef.yOffset2d = copyItemDefHween3.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween3.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{350};
                break;
            case 3708:
                ItemDefinition copyItemDefHween4 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "Purple H'ween mask";
                itemDef.modelId = copyItemDefHween4.modelId;
                itemDef.maleModel0 = copyItemDefHween4.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween4.femaleModel0;
                itemDef.zoom2d = copyItemDefHween4.zoom2d;
                itemDef.xan2d = copyItemDefHween4.xan2d;
                itemDef.yan2d = copyItemDefHween4.yan2d;
                itemDef.yOffset2d = copyItemDefHween4.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween4.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{49863};
                break;
            case 3709:
                ItemDefinition copyItemDefHween5 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "White H'ween mask";
                itemDef.modelId = copyItemDefHween5.modelId;
                itemDef.maleModel0 = copyItemDefHween5.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween5.femaleModel0;
                itemDef.zoom2d = copyItemDefHween5.zoom2d;
                itemDef.xan2d = copyItemDefHween5.xan2d;
                itemDef.yan2d = copyItemDefHween5.yan2d;
                itemDef.yOffset2d = copyItemDefHween5.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween5.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{107};
                break;
            case 3710:
                ItemDefinition copyItemDefHween6 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "Lime H'ween mask";
                itemDef.modelId = copyItemDefHween6.modelId;
                itemDef.maleModel0 = copyItemDefHween6.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween6.femaleModel0;
                itemDef.zoom2d = copyItemDefHween6.zoom2d;
                itemDef.xan2d = copyItemDefHween6.xan2d;
                itemDef.yan2d = copyItemDefHween6.yan2d;
                itemDef.yOffset2d = copyItemDefHween6.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween6.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{17350};
                break;
            case 6855:
                itemDef.name = "Cyan halloween set";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[0] = "Open";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                break;
            case 25872:
                itemDef.name = "Blade of Saeldor (e)";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                break;
            case 3694:
                itemDef.name = "Twisted bow @gre@T2";
                itemDef.modelId = 32799;
                itemDef.maleModel0 = 32674;
                itemDef.femaleModel0 = 39561;
                itemDef.zoom2d = 2000;
                itemDef.xan2d = 720;
                itemDef.yan2d = 1500;
                itemDef.yOffset2d = -3;
                itemDef.xOffset2d = 1;
                itemDef.cost = 4000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 8, 16, 24, 33, 41, 10318, 10334, 14236, 13223};
                itemDef.colorFind = new int[]{655, 655, 0, 0, 675, 675, 675, 655, 655, 655};
                break;
            case 3714:
                itemDef.name = "Twisted bow @gre@T3";
                itemDef.modelId = 32799;
                itemDef.maleModel0 = 32674;
                itemDef.femaleModel0 = 39561;
                itemDef.zoom2d = 2000;
                itemDef.xan2d = 720;
                itemDef.yan2d = 1500;
                itemDef.yOffset2d = -3;
                itemDef.xOffset2d = 1;
                itemDef.cost = 4000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 8, 16, 24, 33, 41, 10318, 10334, 14236, 13223};
                itemDef.colorFind = new int[]{36115, 36115, 0, 0, 36133, 36133, 36133, 36115, 36115, 36115};
                break;
            case 3715:
                itemDef.name = "Twisted bow @gre@T4";
                itemDef.modelId = 32799;
                itemDef.maleModel0 = 32674;
                itemDef.femaleModel0 = 39561;
                itemDef.zoom2d = 2000;
                itemDef.xan2d = 720;
                itemDef.yan2d = 1500;
                itemDef.yOffset2d = -3;
                itemDef.xOffset2d = 1;
                itemDef.cost = 4000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 8, 16, 24, 33, 41, 10318, 10334, 14236, 13223};
                itemDef.colorFind = new int[]{49845, 49845, 0, 0, 49863, 49863, 49863, 49845, 49845, 49845};
                break;
            case 3716:
                itemDef.name = "Twisted bow @gre@T5";
                itemDef.modelId = 32799;
                itemDef.maleModel0 = 32674;
                itemDef.femaleModel0 = 39561;
                itemDef.zoom2d = 2000;
                itemDef.xan2d = 720;
                itemDef.yan2d = 1500;
                itemDef.yOffset2d = -3;
                itemDef.xOffset2d = 1;
                itemDef.cost = 4000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 8, 16, 24, 33, 41, 10318, 10334, 14236, 13223};
                itemDef.colorFind = new int[]{6400, 6400, 0, 0, 1075, 1075, 1075, 6400, 6400, 6400};
                break;
            case 3717:
                ItemDefinition zenithGloves1 = lookup(27112);
                itemDef.setDefaults();
                itemDef.id = 3717;
                itemDef.name = "Zenith Gloves @gre@T1";
                itemDef.modelId = zenithGloves1.modelId;
                itemDef.maleModel0 = zenithGloves1.maleModel0;
                itemDef.maleModel1 = zenithGloves1.maleModel1; //male model 2
                itemDef.femaleModel0 = zenithGloves1.femaleModel0;
                itemDef.femaleModel1 = zenithGloves1.femaleModel1; //female model 2
                itemDef.xan2d = zenithGloves1.xan2d;
                itemDef.zoom2d = zenithGloves1.zoom2d;
                itemDef.yan2d = zenithGloves1.yan2d;
                itemDef.yOffset2d = zenithGloves1.yOffset2d;
                itemDef.xOffset2d = zenithGloves1.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{1566, 10394, 8656, 10394, 1566, 1573, 8656, 5462};
                itemDef.colorFind = new int[]{1075, 1055, 1035, 1075, 1055, 1035, 1075, 1055};
                break;
            case 3718:
                ItemDefinition zenithGloves2 = lookup(27112);
                itemDef.setDefaults();
                itemDef.id = 3718;
                itemDef.name = "Zenith Gloves @gre@T2";
                itemDef.modelId = zenithGloves2.modelId;
                itemDef.maleModel0 = zenithGloves2.maleModel0;
                itemDef.maleModel1 = zenithGloves2.maleModel1; //male model 2
                itemDef.femaleModel0 = zenithGloves2.femaleModel0;
                itemDef.femaleModel1 = zenithGloves2.femaleModel1; //female model 2
                itemDef.xan2d = zenithGloves2.xan2d;
                itemDef.zoom2d = zenithGloves2.zoom2d;
                itemDef.yan2d = zenithGloves2.yan2d;
                itemDef.yOffset2d = zenithGloves2.yOffset2d;
                itemDef.xOffset2d = zenithGloves2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{1566, 10394, 8656, 10394, 1566, 1573, 8656, 5462};
                itemDef.colorFind = new int[]{7114, 7134, 3982, 7114, 7134, 3982, 7114, 7134, 3982};
                break;
            case 3719:
                ItemDefinition zenithGloves3 = lookup(27112);
                itemDef.setDefaults();
                itemDef.id = 3719;
                itemDef.name = "Zenith Gloves @gre@T3";
                itemDef.modelId = zenithGloves3.modelId;
                itemDef.maleModel0 = zenithGloves3.maleModel0;
                itemDef.maleModel1 = zenithGloves3.maleModel1; //male model 2
                itemDef.femaleModel0 = zenithGloves3.femaleModel0;
                itemDef.femaleModel1 = zenithGloves3.femaleModel1; //female model 2
                itemDef.xan2d = zenithGloves3.xan2d;
                itemDef.zoom2d = zenithGloves3.zoom2d;
                itemDef.yan2d = zenithGloves3.yan2d;
                itemDef.yOffset2d = zenithGloves3.yOffset2d;
                itemDef.xOffset2d = zenithGloves3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{1566, 10394, 8656, 10394, 1566, 1573, 8656, 5462};
                itemDef.colorFind = new int[]{33, 7114, 3982, 33, 7114, 3982, 33, 7114};
                break;
            case 3720:
                ItemDefinition zenithGloves4 = lookup(27112);
                itemDef.setDefaults();
                itemDef.id = 3720;
                itemDef.name = "Zenith Gloves @gre@T4";
                itemDef.modelId = zenithGloves4.modelId;
                itemDef.maleModel0 = zenithGloves4.maleModel0;
                itemDef.maleModel1 = zenithGloves4.maleModel1; //male model 2
                itemDef.femaleModel0 = zenithGloves4.femaleModel0;
                itemDef.femaleModel1 = zenithGloves4.femaleModel1; //female model 2
                itemDef.xan2d = zenithGloves4.xan2d;
                itemDef.zoom2d = zenithGloves4.zoom2d;
                itemDef.yan2d = zenithGloves4.yan2d;
                itemDef.yOffset2d = zenithGloves4.yOffset2d;
                itemDef.xOffset2d = zenithGloves4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{1566, 10394, 8656, 10394, 1566, 1573, 8656, 5462};
                itemDef.colorFind = new int[]{0, 660, 7114, 0, 660, 7114, 0, 660};
                break;
            case 3721:
                ItemDefinition zenithGloves5 = lookup(27112);
                itemDef.setDefaults();
                itemDef.id = 3721;
                itemDef.name = "Zenith Gloves @gre@T5";
                itemDef.modelId = zenithGloves5.modelId;
                itemDef.maleModel0 = zenithGloves5.maleModel0;
                itemDef.maleModel1 = zenithGloves5.maleModel1; //male model 2
                itemDef.femaleModel0 = zenithGloves5.femaleModel0;
                itemDef.femaleModel1 = zenithGloves5.femaleModel1; //female model 2
                itemDef.xan2d = zenithGloves5.xan2d;
                itemDef.zoom2d = zenithGloves5.zoom2d;
                itemDef.yan2d = zenithGloves5.yan2d;
                itemDef.yOffset2d = zenithGloves5.yOffset2d;
                itemDef.xOffset2d = zenithGloves5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{1566, 10394, 8656, 10394, 1566, 1573, 8656, 5462};
                itemDef.colorFind = new int[]{926, 9583, 906, 926, 9583, 906, 926, 9583};
                break;
            case 3722:
                ItemDefinition imbuedHeart = lookup(20724);
                itemDef.setDefaults();
                itemDef.id = 3722;
                itemDef.name = "Overloaded heart";
                itemDef.modelId = imbuedHeart.modelId;
                itemDef.xan2d = imbuedHeart.xan2d;
                itemDef.zoom2d = imbuedHeart.zoom2d;
                itemDef.yan2d = imbuedHeart.yan2d;
                itemDef.yOffset2d = imbuedHeart.yOffset2d;
                itemDef.xOffset2d = imbuedHeart.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Invigorate", null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{54544, 58904, 54561, 59796, 60826};
                itemDef.colorFind = new int[]{6400, 6400, 6400, 6400, 6400};
                break;
            case 3695:
                itemDef.name = "Fighter torso (i)";
                itemDef.modelId = 20603;
                itemDef.maleModel0 = 19258;
                itemDef.femaleModel0 = 20516;
                itemDef.maleModel1 = 156; //male arms
                itemDef.femaleModel1 = 32966; //female arms
                itemDef.zoom2d = 1178;
                itemDef.xan2d = 498;
                itemDef.yan2d = 1840;
                itemDef.yOffset2d = 0;
                itemDef.xOffset2d = 7;
                itemDef.cost = 65006;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{14387, 14395};
                itemDef.colorFind = new int[]{107, 127};
                break;
            case 3696:
                itemDef.name = "Sanguinesti staff @gre@T2";
                itemDef.modelId = 35744;
                itemDef.maleModel0 = 35372;
                itemDef.femaleModel0 = 39555;
                itemDef.zoom2d = 2258;
                itemDef.xan2d = 552;
                itemDef.yan2d = 1558;
                itemDef.yOffset2d = -5;
                itemDef.xOffset2d = 3;
                itemDef.cost = 5000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 3127, 57, 3140, 142, 156, 284, 836};
                itemDef.colorFind = new int[]{6073, 20, 6055, 28, 6073, 6055, 41, 156, 6073, 57, 6073, 142, 156, 284, 6073};
                break;
            case 5020: //perk ticket
                itemDef.name = "Perk ticket";
                itemDef.stackable = true;
                break;
            case 25527: //Stardust
                itemDef.interfaceOptions = new String[]{"Open-shop", null, null, null, null};
                break;
            case 21726:
            case 21728:
                itemDef.stackable = true;
                break;
            case 12863:
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, null};
                break;
            case 13092: //this makes crystal halberds wieldable, weird af.
            case 13093:
            case 13094:
            case 13095:
            case 13096:
            case 13097:
            case 13098:
            case 13099:
            case 13100:
            case 13101:
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, null};
                break;
            case 23933:
                itemDef.name = "Vote crystal";
                break;
            case 9698:
                itemDef.name = "Unfired burning rune";
                itemDef.createCustomSprite("Unfired_burning_rune.png");
                break;
            case 9699:
                itemDef.name = "Burning rune";
                itemDef.createCustomSprite("Burning_rune.png");
                break;
            case 23778:
                itemDef.name = "Uncut toxic gem";
                break;
            case 22374:
                itemDef.name = "Hespori key";
                break;
            case 23783:
                itemDef.name = "Toxic gem";
                break;
            case 9017:
                itemDef.name = "Hespori essence";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 19473:
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 10556:
            case 10557:
            case 10558:
            case 10559:
                itemDef.interfaceOptions = new String[]{null, "Wear", "Feature", null, "Drop"};
                break;
            case 21898:
                itemDef.interfaceOptions = new String[]{null, "Wear", "Teleports", "Features", null};
                break;
            case 12873:
            case 12875:
            case 12877:
            case 12879:
            case 12881:
            case 12883:
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                break;
            case 23804:
                itemDef.name = "Imbue Dust";
                break;
            case 22517:
                itemDef.name = "Crystal Shard";
                break;
            case 23951:
                itemDef.name = "Crystalline Key";
                break;
            case 691:
                itemDef.name = "@gre@100 Exchange Certificate";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 692:
                itemDef.name = "@red@200 Exchange Certificate";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 693:
                itemDef.name = "@cya@300 Exchange Certificate";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 696:
                itemDef.name = "@yel@400 Exchange Certificate";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 4067:
                itemDef.name = "Exchange Tickets";
                break;
            case 23877:
                itemDef.name = "Crystal Shard";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = true;
                break;
            case 23943:
                itemDef.interfaceOptions = new String[]{null, "Wear", "Uncharge", "Check", "Drop"};
                break;
            case 2996:
                itemDef.name = "@red@PKP Ticket";
                itemDef.interfaceOptions = new String[]{"Convert", null, null, null, "Drop"};
                break;
            case 23776:
                itemDef.name = "@red@Hunllef's Key";
                break;
            case 13148:
                itemDef.name = "@red@Reset Lamp";
                break;
            case 6792:
                itemDef.name = "@red@Seren's Key";
                break;
            case 4185:
                itemDef.name = "Wilderness key";
                break;
            case 21880:
                itemDef.name = "Wrath Rune";
                itemDef.cost = 1930;
                break;
            case 12885:
            case 13277:
            case 19701:
            case 13245:
            case 23525:
            case 21745:
            case 12007:
            case 22106:
            case 12936:
            case 24495:
                itemDef.interfaceOptions = new String[]{null, null, "Open", null, "Drop"};
                break;
            case 21262:
                itemDef.name = "Vote Genie Pet";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Release"};
                break;
            case 21817:
                itemDef.interfaceOptions = new String[]{null, "Wear", "Dismantle", null, null,};
                break;
            case 21347:
                itemDef.interfaceOptions = new String[]{null, null, null, "Chisel-Options", null,};
                break;
            case 21259:
                itemDef.name = "@red@Name Change Scroll";
                itemDef.interfaceOptions = new String[]{null, null, "Read", null, null,};
                break;
            case 22547:
            case 22552:
            case 22542:
                itemDef.interfaceOptions = new String[]{null, null, null, null, null,};
                break;
            case 22555:
            case 22550:
            case 22545:
                itemDef.interfaceOptions = new String[]{null, "Wield", "Check", "Uncharge", null,};
                break;
            case 732:
                itemDef.name = "@blu@Imbuedeifer";
                itemDef.cost = 1930;
                break;
            case 21881:
                itemDef.name = "Wrath Rune";
                itemDef.cost = 1930;
                break;
            case 13226:
                itemDef.name = "Herb Sack";
                break;
            case 3456:
                itemDef.name = "@whi@Common Raids Key";
                break;
            case 3464:
                itemDef.name = "@pur@Rare Raids Key";
                break;
            case 6829:
                itemDef.name = "@red@YT Video Giveaway Box";
                itemDef.interfaceOptions = new String[]{"Giveaway", null, null, null, "Drop"};
                break;
            case 6831:
                itemDef.name = "@red@YT Video Giveaway Box (t2)";
                itemDef.interfaceOptions = new String[]{"Giveaway", null, null, null, "Drop"};

                break;
            case 6832:
                itemDef.name = "@red@YT Stream Giveaway Box";
                itemDef.interfaceOptions = new String[]{"Giveaway", null, null, null, "Drop"};

                break;
            case 6833:
                itemDef.name = "@red@YT Stream Giveaway Box (t2)";
                itemDef.interfaceOptions = new String[]{"Giveaway", null, null, null, "Drop"};

                break;
            case 13190:
                itemDef.name = "@yel@100m OSRS GP";
                itemDef.interfaceOptions = new String[]{"Redeem", null, null, null, "Drop"};
                break;
            case 6121:
                itemDef.name = "Break Vials Instruction";
                break;
            case 2528:
                itemDef.name = "@red@Experience Lamp";
                break;
            case 24387:
                itemDef.name = "Experience hat";
                break;
            case 24389:
                itemDef.name = "Experience coat";
                break;
            case 24391:
                itemDef.name = "Experience trousers";
                break;
            case 24393:
                itemDef.name = "Experience boots";
                break;
            case 19837:
                itemDef.name = "50% damage boost 20 minutes";
                itemDef.interfaceOptions = new String[]{"Consume", null, null, null, null};
                break;
            case 5509:
                itemDef.name = "Small Pouch";
                itemDef.createCustomSprite("Small_pouch.png");
                itemDef.interfaceOptions = new String[]{"Fill", "Empty", "Check", null, null};
                break;
            case 5510:
                itemDef.name = "Medium Pouch";
                itemDef.createCustomSprite("Medium_pouch.png");
                itemDef.interfaceOptions = new String[]{"Fill", "Empty", "Check", null, null};
                break;
            case 5512:
                itemDef.name = "Large Pouch";
                itemDef.createCustomSprite("Large_pouch.png");
                itemDef.interfaceOptions = new String[]{"Fill", "Empty", "Check", null, null};
                break;
				/*
				Sigils
				 */
            case 25996:
                itemDef.name = "Sigil of Corruption";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26125:
                itemDef.name = "Sigil of Blood";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 25990:
                itemDef.name = "Sigil of Brutality";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26146:
                itemDef.name = "Sigil of Vanguard";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26017:
                itemDef.name = "Sigil of Wealth";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26041:
                itemDef.name = "Sigil of Piety";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26065:
                itemDef.name = "Sigil of Archery";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26128:
                itemDef.name = "Sigil of Wizardy";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26032:
                itemDef.name = "Sigil of Experience";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 26062:
                itemDef.name = "Sigil of Treasure";
                itemDef.interfaceOptions = new String[]{null, null, null, null, null};
                break;
            case 10724: //full skeleton
            case 10725:
            case 10726:
            case 10727:
            case 10728:
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, "Drop"};
                break;
            case 5514:
                itemDef.name = "Giant Pouch";
                itemDef.createCustomSprite("Giant_pouch.png");
                break;
            case 22610: //vesta spear
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, "Drop"};
                break;
            case 22613: //vesta longsword
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, "Drop"};
                break;
            case 22504: //stat warhammer
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, "Drop"};
                break;
            case 4224:
            case 4225:
            case 4226:
            case 4227:
            case 4228:
            case 4229:
            case 4230:
            case 4231:
            case 4232:
            case 4233:
            case 4234:
            case 4235://crystal sheild
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, "Drop"};
                break;
            case 4212:
            case 4214:
            case 4215:
            case 4216:
            case 4217:
            case 4218:
            case 4219:
            case 4220:
            case 4221:
            case 4222:
            case 4223:
                itemDef.interfaceOptions = new String[]{null, "Wield", null, null, "Drop"};
                break;
            case 7478:
                itemDef.name = "Donator Token";
                break;
            case 2841:
                itemDef.name = "@red@Bonus Exp Scroll";
                itemDef.interfaceOptions = new String[]{"@yel@Activate", null, null, null, "Drop"};
                break;
            case 21791:
            case 21793:
            case 21795:
                itemDef.interfaceOptions = new String[]{null, "Wear", null, null, "Drop"};
                break;
            case 19841:
                itemDef.name = "Master Casket";
                break;
            case 21034:
                itemDef.interfaceOptions = new String[]{"Read", null, null, null, "Drop"};
                break;
            case 6830:
                itemDef.name = "@yel@BETA @blu@BOX";
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                break;
            case 21079:
                itemDef.interfaceOptions = new String[]{"Read", null, null, null, "Drop"};
                break;
            case 25481:
                itemDef.name = "Infernal Cape Upgrade Scroll";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 3460:
                itemDef.name = "Corrupted Slayer Key";
                break;
            case 22093:
                itemDef.name = "@gre@Vote Key";
                break;
            case 25959:
                itemDef.name = "Serenic Shard";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 23947:
                ItemDefinition crystalDef = lookup(611);
                itemDef.setDefaults();
                itemDef.id = 23947;
                itemDef.name = "Unlimited Task Teleport Crystal";
                itemDef.modelId = crystalDef.modelId;
                itemDef.xan2d = crystalDef.xan2d;
                itemDef.zoom2d = crystalDef.zoom2d;
                itemDef.yan2d = crystalDef.yan2d;
                itemDef.yOffset2d = crystalDef.yOffset2d;
                itemDef.xOffset2d = crystalDef.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Teleport", null, null, null, "Drop"};
                break;
            case 26500:
                itemDef.name = "Task Teleport Scroll";
                itemDef.interfaceOptions = new String[]{"Teleport", null, null, null, "Drop"};
                break;
            case 25087:
                itemDef.name = "1 Hour Double Drop Chance";
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;
            case 7774:
                itemDef.name = "AFK Token";
                itemDef.interfaceOptions = new String[]{"Open Shop", null, null, null, "Drop"};
                break;
            case 23497:
                itemDef.name = "Upgrade Token";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 26706:
                itemDef.name = "1 Hour 10% Damage Boost";
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;
            case 25365:
                itemDef.name = "1 Hour CoX Boost";
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;
            case 11740:
                itemDef.name = "1 Hour 10% Drop Boost";
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;
            case 22885:
                itemDef.name = "@gre@Kronos seed";
                break;
            case 23824:
                itemDef.name = "Slaughter charge";
                break;
            case 22883:
                itemDef.name = "@gre@Iasor seed";
                break;
            case 22881:
                itemDef.name = "@gre@Attas seed";
                break;
            case 20906:
                itemDef.name = "@gre@Golpar seed";
                break;
            case 6112:
                itemDef.name = "@gre@Kelda seed";
                break;
            case 20903:
                itemDef.name = "@gre@Noxifer seed";
                break;
            case 20909:
                itemDef.name = "@gre@Buchu seed";
                break;
            case 22869:
                itemDef.name = "@gre@Celastrus seed";
                break;
            case 4205:
                itemDef.name = "@gre@Consecration seed";
                itemDef.stackable = true;
                break;
            case 11864:
            case 11865:
            case 19639:
            case 19641:
            case 19643:
            case 19645:
            case 19647:
            case 19649:
            case 24444:
            case 24370:
            case 23075:
            case 23073:
            case 21888:
            case 21890:
            case 21264:
            case 21266:
                itemDef.equipActions[2] = "Log";
                itemDef.equipActions[1] = "Check";
                break;
            case 13136:
                itemDef.equipActions[2] = "Elidinis";
                itemDef.equipActions[1] = "Kalphite Hive";
                break;
            case 2550:
                itemDef.equipActions[2] = "Check";
                break;

            case 1712:
            case 1710:
            case 1708:
            case 1706:
            case 19707:
                itemDef.equipActions[1] = "Edgeville";
                itemDef.equipActions[2] = "Karamja";
                itemDef.equipActions[3] = "Draynor";
                itemDef.equipActions[4] = "Al-Kharid";
                break;
            case 21816:
                itemDef.interfaceOptions = new String[]{null, "Wear", "Uncharge", null, "Drop"};
                itemDef.equipActions[1] = "Check";
                itemDef.equipActions[2] = "Toggle-absorption";
                break;
            case 2552:
            case 2554:
            case 2556:
            case 2558:
            case 2560:
            case 2562:
            case 2564:
            case 2566: // Ring of duelling
                itemDef.equipActions[2] = "Shantay Pass";
                itemDef.equipActions[1] = "Clan wars";
                break;
            case 11739:
                itemDef.name = "@gre@Vote Mystery Box";
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                break;
            case 6834:
                ItemDefinition petsMBOX = lookup(6199);
                itemDef.setDefaults();
                itemDef.name = "@cya@Pet Mystery Box";
                itemDef.id = 6834;
                itemDef.modelId = petsMBOX.modelId;
                itemDef.xan2d = petsMBOX.xan2d;
                itemDef.zoom2d = petsMBOX.zoom2d;
                itemDef.yan2d = petsMBOX.yan2d;
                itemDef.yOffset2d = petsMBOX.yOffset2d;
                itemDef.xOffset2d = petsMBOX.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{22410, 2999};
                itemDef.colorFind = new int[]{375, 0};
                itemDef.glowColor = 35;
                break;
            case 6828:
                itemDef.name = "Super Mystery Box";
                itemDef.interfaceOptions = new String[]{"Open", null, "View-Loots", "Quick-Open", "Drop"};
                itemDef.createCustomSprite("Mystery_Box.png");
                itemDef.createSmallCustomSprite("Mystery_Box_Small.png");
                itemDef.stackable = false;
                break;
            case 30010:
                itemDef.setDefaults();
                itemDef.name = "Postie Pete";
                itemDef.createCustomSprite("Postie_Pete.png");
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                break;
            case 30011:
                itemDef.setDefaults();
                itemDef.name = "Imp";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Imp.png");
                break;
            case 30012:
                itemDef.setDefaults();
                itemDef.name = "Toucan";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Toucan.png");
                break;
            case 30013:
                itemDef.setDefaults();
                itemDef.name = "Penguin King";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Penguin_King.png");
                break;
            case 30014:
                itemDef.setDefaults();
                itemDef.name = "K'klik";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("K'klik.png");
                break;
            case 30015:
                itemDef.setDefaults();
                itemDef.name = "Shadow warrior";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Shadow_warrior.png");
                break;
            case 30016:
                itemDef.setDefaults();
                itemDef.name = "Shadow archer";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Shadow_archer.png");
                break;
            case 30017:
                itemDef.setDefaults();
                itemDef.name = "Shadow wizard";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Shadow_wizard.png");
                break;
            case 30018:
                itemDef.setDefaults();
                itemDef.name = "Healer Death Spawn";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Healer_Death_Spawn.png");
                break;
            case 30019:
                itemDef.setDefaults();
                itemDef.name = "Holy Death Spawn";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Holy_Death_Spawn.png");
                break;
            case 30020:
                itemDef.setDefaults();
                itemDef.name = "Corrupt beast";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Corrupt_beast.png");
                break;
            case 30021:
                itemDef.setDefaults();
                itemDef.name = "Roc";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Roc.png");
                break;
            case 30022:
                itemDef.setDefaults();
                itemDef.name = "@red@Kratos";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Yama.png");
                break;
            case 30023:
                itemDef.setDefaults();
                itemDef.name = "Rain cloud";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("Rain_cloud.png");
                break;
            case 8866:
                itemDef.name = "Storage chest key (UIM)";
                itemDef.stackable = true;
                break;
            case 8868:
                itemDef.name = "Perm. storage chest key (UIM)";
                break;
            case 771:
                itemDef.name = "@cya@Ancient branch";
                break;
            case 22416:
                itemDef.name = "Tome of pets";
                itemDef.interfaceOptions = new String[]{"Read", null, null, null, "Drop"};
                break;
            case 6199:
                itemDef.name = "Mystery Box";
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                break;
            case 12789:
                itemDef.name = "@red@Youtube Mystery Box";
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                break;
            case 13346:
                itemDef.name = "Ultra Mystery Box";
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                break;
            case 25541:
                itemDef.name = "Ring of Zenith @gre@T1";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 26, 33, 3148, 1139, 64935};
                itemDef.colorFind = new int[]{1075, 0, 1075, 0, 1075, 0};
                break;
            case 2951:
                ItemDefinition ringOfZenith2 = lookup(25541);
                itemDef.zoom2d = ringOfZenith2.zoom2d;
                itemDef.xan2d = ringOfZenith2.xan2d;
                itemDef.yan2d = ringOfZenith2.yan2d;
                itemDef.yOffset2d = ringOfZenith2.yOffset2d;
                itemDef.xOffset2d = ringOfZenith2.xOffset2d;
                itemDef.name = "Ring of Zenith @gre@T2";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.modelId = 41594;
                itemDef.colorReplace = new int[]{16, 26, 33, 3148, 1139, 64935};
                itemDef.colorFind = new int[]{7883, 0, 7883, 0, 7883, 0};
                break;
            case 2952:
                ItemDefinition ringOfZenith3 = lookup(25541);
                itemDef.zoom2d = ringOfZenith3.zoom2d;
                itemDef.xan2d = ringOfZenith3.xan2d;
                itemDef.yan2d = ringOfZenith3.yan2d;
                itemDef.yOffset2d = ringOfZenith3.yOffset2d;
                itemDef.xOffset2d = ringOfZenith3.xOffset2d;
                itemDef.name = "Ring of Zenith @gre@T3";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.modelId = 41594;
                itemDef.colorReplace = new int[]{16, 26, 33, 3148, 1139, 64935};
                itemDef.colorFind = new int[]{43297, 0, 43297, 0, 43297, 0};
                break;
            case 2953:
                ItemDefinition ringOfZenith4 = lookup(25541);
                itemDef.zoom2d = ringOfZenith4.zoom2d;
                itemDef.xan2d = ringOfZenith4.xan2d;
                itemDef.yan2d = ringOfZenith4.yan2d;
                itemDef.yOffset2d = ringOfZenith4.yOffset2d;
                itemDef.xOffset2d = ringOfZenith4.xOffset2d;
                itemDef.name = "Ring of Zenith @gre@T4";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.modelId = 41594;
                itemDef.colorReplace = new int[]{16, 26, 33, 3148, 1139, 64935};
                itemDef.colorFind = new int[]{6073, 0, 6073, 0, 6073, 0};
                break;
            case 2954:
                ItemDefinition ringOfZenith5 = lookup(25541);
                itemDef.zoom2d = ringOfZenith5.zoom2d;
                itemDef.xan2d = ringOfZenith5.xan2d;
                itemDef.yan2d = ringOfZenith5.yan2d;
                itemDef.yOffset2d = ringOfZenith5.yOffset2d;
                itemDef.xOffset2d = ringOfZenith5.xOffset2d;
                itemDef.name = "Ring of Zenith @gre@T5";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.modelId = 41594;
                itemDef.colorReplace = new int[]{16, 26, 33, 3148, 1139, 64935};
                itemDef.colorFind = new int[]{9583, 0, 9583, 0, 9583, 0};
                break;
            case 8167:
                itemDef.name = "@or2@Master Mystery Chest";
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                itemDef.glowColor = 6073;
                break;
            case 13438:
                itemDef.name = "Slayer Mystery Chest";
                itemDef.interfaceOptions = new String[]{"Open", null, null, null, "Drop"};
                break;
            case 2399:
                itemDef.name = "@or2@FoE Mystery Key";
                break;
            case 10832:
                itemDef.name = "Small coin bag";
                itemDef.interfaceOptions = new String[]{"Open", null, "Open-All", null, "Drop"};
                break;
            case 10833:
                itemDef.name = "Medium coin bag";
                itemDef.interfaceOptions = new String[]{"Open", null, "Open-All", null, "Drop"};
                break;
            case 10834:
                itemDef.name = "Large coin bag";
                itemDef.interfaceOptions = new String[]{"Open", null, "Open-All", null, "Drop"};
                break;
            case 22316:
                itemDef.name = "Sword of Nexus";
                break;
            case 19942:
                itemDef.name = "Lil Mimic";
                break;
            case 30110:
                itemDef.setDefaults();
                itemDef.name = "Dark postie pete";
                itemDef.createCustomSprite("dark_Postie_Pete.png");
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                break;
            case 30111:
                itemDef.setDefaults();
                itemDef.name = "Dark imp";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Imp.png");
                break;
            case 30112:
                itemDef.setDefaults();
                itemDef.name = "Dark toucan";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Toucan.png");
                break;
            case 30113:
                itemDef.setDefaults();
                itemDef.name = "Dark penguin King";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Penguin_King.png");
                break;
            case 30114:
                itemDef.setDefaults();
                itemDef.name = "Dark k'klik";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_K'klik.png");
                break;
            case 30115:
                itemDef.setDefaults();
                itemDef.name = "Dark shadow warrior";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Shadow_warrior.png");
                break;
            case 30116:
                itemDef.setDefaults();
                itemDef.name = "Dark shadow archer";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Shadow_archer.png");
                break;
            case 30117:
                itemDef.setDefaults();
                itemDef.name = "Dark shadow wizard";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Shadow_wizard.png");
                break;
            case 30118:
                itemDef.setDefaults();
                itemDef.name = "Dark healer death spawn";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Healer_Death_Spawn.png");
                break;
            case 30119:
                itemDef.setDefaults();
                itemDef.name = "Dark holy death spawn";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Holy_Death_Spawn.png");
                break;
            case 30120:
                itemDef.setDefaults();
                itemDef.name = "Dark corrupt beast";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Corrupt_beast.png");
                break;
            case 30121:
                itemDef.setDefaults();
                itemDef.name = "Dark roc";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_Roc.png");
                break;
            case 30122:
                itemDef.setDefaults();
                itemDef.name = "@red@Dark kratos";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_yama.png");
                break;
            case 30123:
                itemDef.setDefaults();
                itemDef.name = "Dark seren";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = false;
                itemDef.createCustomSprite("dark_seren.png");

                break;
            case 23939:
                itemDef.name = "Seren";
                itemDef.createCustomSprite("seren.png");
                break;
            case 21046:
                itemDef.name = "@cya@Chest rate bonus (+15%)";
                itemDef.stackable = true;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 11666:
                itemDef.name = "Full Elite Void Token";
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                break;
            case 1004:
                itemDef.name = "@gre@20m Coins";
                itemDef.stackable = false;
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 7629:
                itemDef.name = "@or3@2x Slayer point scroll";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.stackable = true;
                break;
            case 24460:
                itemDef.name = "@or3@Faster clues (30 mins)";
                itemDef.interfaceOptions = new String[]{"Boost", null, null, null, "Drop"};
                itemDef.stackable = true;
                break;
            case 7968:
                itemDef.name = "@or3@+25% Skilling pet rate (30 mins)";
                itemDef.interfaceOptions = new String[]{"Boost", null, null, null, "Drop"};
                itemDef.stackable = true;
                break;
            case 8899:
                itemDef.name = "@gre@50m Coins";
                itemDef.stackable = false;
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 4035:
                itemDef.interfaceOptions = new String[]{"Teleport", null, null, null, null};
                break;
            case 10835:
                itemDef.name = "Buldging coin bag";
                itemDef.interfaceOptions = new String[]{"Open", null, "Open-All", null, "Drop"};
                break;
            case 15098:
                itemDef.name = "Dice (up to 100)";
                itemDef.modelId = 31223;
                itemDef.zoom2d = 1104;
                itemDef.yan2d = 215;
                itemDef.xan2d = 94;
                itemDef.xOffset2d = -5;
                itemDef.yOffset2d = -18;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Public-roll";
                itemDef.interfaceOptions[2] = null;
                itemDef.name = "Dice (up to 100)";
                itemDef.ambient = 15;
                itemDef.contrast = 25;
                itemDef.createCustomSprite("Dice_Bag.png");
                break;
            case 11773:
            case 11771:
            case 11770:
            case 11772:
                itemDef.ambient += 45;
                break;
            case 12792:
                itemDef.name = "Graceful Recolor Box";
                itemDef.interfaceOptions = new String[]{null, "Use", null, null, "Drop"};
                break;
            case 6769:
                itemDef.name = "@yel@$5 Scroll";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 2403:
                itemDef.name = "@yel@$10 Scroll";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 2396:
                itemDef.name = "@yel@$25 Scroll";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 786:
                itemDef.name = "@yel@$50 Donator";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 761:
                itemDef.name = "@yel@$100 Donator";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 607:
                itemDef.name = "@red@$250 Scroll";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 608:
                itemDef.name = "@gre@$500 Scroll";
                itemDef.interfaceOptions = new String[]{"Claim", null, null, null, "Drop"};
                break;
            case 1464:
                itemDef.name = "Vote ticket";
                break;

            case 33049:
                itemDef.setDefaults();
                itemDef.name = "Agility master cape";
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{677, 801, 43540, 43543, 43546, 43549, 43550, 43552, 43554, 43558,
                        43560, 43575};
                itemDef.modelId = 50030;
                itemDef.maleModel0 = 50031;
                itemDef.femaleModel0 = 50031;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 300:
                ItemDefinition seed = lookup(299);
                itemDef.name = "Forever seed";
                itemDef.modelId = 2381;
                itemDef.femaleModel0 = seed.femaleModel0;
                itemDef.zoom2d = seed.zoom2d;
                itemDef.yan2d = seed.yan2d;
                itemDef.xan2d = seed.xan2d;
                itemDef.yOffset2d = seed.yOffset2d;
                itemDef.xOffset2d = seed.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[0] = "Plant";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{43288};
                itemDef.colorFind = new int[]{34770};
                break;
            case 33033:
                itemDef.setDefaults();
                itemDef.name = "Attack master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{7104, 9151, 911, 914, 917, 920, 921, 923, 925, 929, 931, 946};
                itemDef.modelId = 50032;
                itemDef.maleModel0 = 50033;
                itemDef.femaleModel0 = 50033;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33055:
                itemDef.setDefaults();
                itemDef.name = "Construction master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{6061, 5945, 6327, 6330, 6333, 6336, 6337, 6339, 6341, 6345, 6347,
                        6362};
                itemDef.modelId = 50034;
                itemDef.maleModel0 = 50035;
                itemDef.femaleModel0 = 50035;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33040:
                itemDef.setDefaults();
                itemDef.name = "Cooking master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{920, 920, 51856, 51859, 51862, 51865, 51866, 51868, 51870, 51874,
                        51876, 51891};
                itemDef.modelId = 50036;
                itemDef.maleModel0 = 50037;
                itemDef.femaleModel0 = 50037;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33045:
                itemDef.setDefaults();
                itemDef.name = "Crafting master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{9142, 9152, 4511, 4514, 4517, 4520, 4521, 4523, 4525, 4529, 4531,
                        4546};
                itemDef.modelId = 50038;
                itemDef.maleModel0 = 50039;
                itemDef.femaleModel0 = 50039;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33034:
                itemDef.setDefaults();
                itemDef.name = "Defence master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{10460, 10473, 41410, 41413, 41416, 41419, 41420, 41422, 41424,
                        41428, 41430, 41445};
                itemDef.modelId = 50040;
                itemDef.maleModel0 = 50041;
                itemDef.femaleModel0 = 50041;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33052:
                itemDef.setDefaults();
                itemDef.name = "Farming master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{14775, 14792, 22026, 22029, 22032, 22035, 22036, 22038, 22040,
                        22044, 22046, 22061};
                itemDef.modelId = 50042;
                itemDef.maleModel0 = 50043;
                itemDef.femaleModel0 = 50043;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33044:
                itemDef.setDefaults();
                itemDef.name = "Firemaking master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{8125, 9152, 4015, 4018, 4021, 4024, 4025, 4027, 4029, 4033, 4035,
                        4050};
                itemDef.modelId = 50044;
                itemDef.maleModel0 = 50045;
                itemDef.femaleModel0 = 50045;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33043:
                itemDef.setDefaults();
                itemDef.name = "Fishing master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{9144, 9152, 38202, 38205, 38208, 38211, 38212, 38214, 38216,
                        38220, 38222, 38237};
                itemDef.modelId = 50046;
                itemDef.maleModel0 = 50047;
                itemDef.femaleModel0 = 50047;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33042:
                itemDef.setDefaults();
                itemDef.name = "Fletching master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{6067, 9152, 33670, 33673, 33676, 33679, 33680, 33682, 33684,
                        33688, 33690, 33705};
                itemDef.modelId = 50048;
                itemDef.maleModel0 = 50049;
                itemDef.femaleModel0 = 50049;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33048:
                itemDef.setDefaults();
                itemDef.name = "Herblore master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{9145, 9156, 22414, 22417, 22420, 22423, 22424, 22426, 22428,
                        22432, 22434, 22449};
                itemDef.modelId = 50050;
                itemDef.maleModel0 = 50051;
                itemDef.femaleModel0 = 50051;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33036:
                itemDef.setDefaults();
                itemDef.name = "Hitpoints master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{818, 951, 8291, 8294, 8297, 8300, 8301, 8303, 8305, 8309, 8311,
                        8319};
                itemDef.modelId = 50052;
                itemDef.maleModel0 = 50053;
                itemDef.femaleModel0 = 50053;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                //itemDef.femaleOffset = 4;
                break;
            case 33054:
                itemDef.setDefaults();
                itemDef.name = "Hunter master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{5262, 6020, 8472, 8475, 8478, 8481, 8482, 8484, 8486, 8490, 8492,
                        8507};
                itemDef.modelId = 50054;
                itemDef.maleModel0 = 50055;
                itemDef.femaleModel0 = 50055;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33039:
                itemDef.setDefaults();
                itemDef.name = "Magic master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{43569, 43685, 6336, 6339, 6342, 6345, 6346, 6348, 6350, 6354,
                        6356, 6371};
                itemDef.modelId = 50056;
                itemDef.maleModel0 = 50057;
                itemDef.femaleModel0 = 50057;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33047:
                itemDef.setDefaults();
                itemDef.name = "Mining master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{36296, 36279, 10386, 10389, 10392, 10395, 10396, 10398, 10400,
                        10404, 10406, 10421};
                itemDef.modelId = 50058;
                itemDef.maleModel0 = 50059;
                itemDef.femaleModel0 = 50059;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33038:
                itemDef.setDefaults();
                itemDef.name = "Prayer master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{9163, 9168, 117, 120, 123, 126, 127, 127, 127, 127, 127, 127};
                itemDef.modelId = 50060;
                itemDef.maleModel0 = 50061;
                itemDef.femaleModel0 = 50061;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33037:
                itemDef.setDefaults();
                itemDef.name = "Range master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{3755, 3998, 15122, 15125, 15128, 15131, 15132, 15134, 15136,
                        15140, 15142, 15157};
                itemDef.modelId = 50062;
                itemDef.maleModel0 = 50063;
                itemDef.femaleModel0 = 50063;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33053:
                itemDef.setDefaults();
                itemDef.name = "Runecrafting master cape";
                // 4 //7 //10 //13 //14//16//18//22 //24//39
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{9152, 8128, 10318, 10321, 10324, 10327, 10328, 10330, 10332,
                        10336, 10338, 10353};
                itemDef.modelId = 50064;
                itemDef.maleModel0 = 50065;
                itemDef.femaleModel0 = 50065;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33051:
                itemDef.setDefaults();
                itemDef.name = "Slayer master cape";
                itemDef.colorReplace = new int[]{57022, 48811};
                itemDef.colorFind = new int[]{912, 920};
                itemDef.modelId = 50066;
                itemDef.maleModel0 = 50067;
                itemDef.femaleModel0 = 50067;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33046:
                itemDef.setDefaults();
                itemDef.name = "Smithing master cape";
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{8115, 9148, 10386, 10389, 10392, 10395, 10396, 10398, 10400,
                        10404, 10406, 10421};
                itemDef.modelId = 50068;
                itemDef.maleModel0 = 50069;
                itemDef.femaleModel0 = 50069;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33035:
                itemDef.setDefaults();
                itemDef.name = "Strength master cape";
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{935, 931, 27538, 27541, 27544, 27547, 27548, 27550, 27552, 27556,
                        27558, 27573};
                itemDef.modelId = 50070;
                itemDef.maleModel0 = 50071;
                itemDef.femaleModel0 = 50071;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33050:
                itemDef.setDefaults();
                itemDef.name = "Thieving master cape";
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{11, 0, 58779, 58782, 58785, 58788, 58789, 57891, 58793, 58797,
                        58799, 58814};
                itemDef.modelId = 50072;
                itemDef.maleModel0 = 50073;
                itemDef.femaleModel0 = 50073;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                break;
            case 33041:
                itemDef.setDefaults();
                itemDef.name = "Woodcutting master cape";
                itemDef.colorReplace = new int[]{57022, 48811, 2, 1029, 1032, 11, 12, 14, 16, 20, 22, 2};
                itemDef.colorFind = new int[]{25109, 24088, 6693, 6696, 6699, 6702, 6703, 6705, 6707, 6711,
                        6713, 6728};
                itemDef.modelId = 50074;
                itemDef.maleModel0 = 50075;
                itemDef.femaleModel0 = 50075;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.yOffset2d = 3;
                itemDef.xOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = -2;
                break;
            //upgrade kits and tier items
            case 3461:
                ItemDefinition copyItemDef = lookup(24670);
                itemDef.setDefaults();
                itemDef.id = 3461;
                itemDef.name = "Ancestral Upgrade Kit";
                itemDef.modelId = copyItemDef.modelId;
                itemDef.xan2d = copyItemDef.xan2d;
                itemDef.zoom2d = copyItemDef.zoom2d;
                itemDef.yan2d = copyItemDef.yan2d;
                itemDef.yOffset2d = copyItemDef.yOffset2d;
                itemDef.xOffset2d = copyItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 21018:
                itemDef.name = "Ancestral hat @gre@T1";
                break;
            case 21021:
                itemDef.name = "Ancestral robe top @gre@T1";
                break;
            case 21024:
                itemDef.name = "Ancestral robe bottom @gre@T1";
                break;
            case 29000:
                ItemDefinition ancHatItemDef = lookup(21018);
                itemDef.setDefaults();
                itemDef.id = 29000;
                itemDef.name = "Ancestral hat @gre@T2";
                itemDef.modelId = ancHatItemDef.modelId;
                itemDef.maleModel0 = ancHatItemDef.maleModel0;
                itemDef.femaleModel0 = ancHatItemDef.femaleModel0;
                itemDef.xan2d = ancHatItemDef.xan2d;
                itemDef.zoom2d = ancHatItemDef.zoom2d;
                itemDef.yan2d = ancHatItemDef.yan2d;
                itemDef.yOffset2d = ancHatItemDef.yOffset2d;
                itemDef.xOffset2d = ancHatItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43544, 6798, 5268, 6323, 6331, 6340, 6348, 6356, 6364, 43301, 6973, 4550};
                itemDef.colorFind = new int[]{6073, 6073, 6798, 5268, 6073, 6073, 6073, 6073, 6073, 6073, 0, 0, 4550};
                //under hat, under hat, strip under buckle, strip under buckle, lowest top layer (not the trim), strip above buckle
                //next part up on hat (beginning of curve/tip), next part up, next part up, tip, trim, buckle, not sure
                break;
            case 29001:
                ItemDefinition ancTopItemDef = lookup(21021);
                itemDef.setDefaults();
                itemDef.id = 29001;
                itemDef.name = "Ancestral robe top @gre@T2";
                itemDef.modelId = ancTopItemDef.modelId;
                itemDef.maleModel0 = ancTopItemDef.maleModel0;
                itemDef.maleModel1 = ancTopItemDef.maleModel1; //male model 2
                itemDef.femaleModel0 = ancTopItemDef.femaleModel0;
                itemDef.femaleModel1 = ancTopItemDef.femaleModel1; //female model 2
                itemDef.xan2d = ancTopItemDef.xan2d;
                itemDef.zoom2d = ancTopItemDef.zoom2d;
                itemDef.yan2d = ancTopItemDef.yan2d;
                itemDef.yOffset2d = ancTopItemDef.yOffset2d;
                itemDef.xOffset2d = ancTopItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{6073, 6073, 1050, 1050, 6073, 1035, 6073, 1050, 1050, 1050, 6073, 0, 1050};
                //part where it meets the waist (only shows on floor)
                //right side wrap, maybe under left armpit as well
                //wrist cuffs
                //wrist cuffs lower
                //waist wrap
                //line going at a curve starting at the waist, over the shoulder and to the back waist
                //bottom and top of sleeves and outer collar
                //top of torso and top of sleeves
                //upper waist line going around from front to back, and part of sleeves
                //below left breast, goes around to the back around the left side
                //front and back of left breast, as well as biceps
                //outer trim of buckle
                //remaining part of arm below the bicep, and the inner trim of buckle
                break;
            case 29002:
                ItemDefinition ancBottomItemDef = lookup(21024);
                itemDef.setDefaults();
                itemDef.id = 29002;
                itemDef.name = "Ancestral robe bottom @gre@T2";
                itemDef.modelId = ancBottomItemDef.modelId;
                itemDef.maleModel0 = ancBottomItemDef.maleModel0;
                itemDef.femaleModel0 = ancBottomItemDef.femaleModel0;
                itemDef.xan2d = ancBottomItemDef.xan2d;
                itemDef.zoom2d = ancBottomItemDef.zoom2d;
                itemDef.yan2d = ancBottomItemDef.yan2d;
                itemDef.yOffset2d = ancBottomItemDef.yOffset2d;
                itemDef.xOffset2d = ancBottomItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{6073, 6073, 1050, 1050, 6073, 1035, 6073, 1050, 1050, 1050, 6073, 0, 1050};
                break;
            case 29003:
                ItemDefinition ancHat2ItemDef = lookup(21018);
                itemDef.setDefaults();
                itemDef.id = 29003;
                itemDef.name = "Ancestral hat @gre@T3";
                itemDef.modelId = ancHat2ItemDef.modelId;
                itemDef.maleModel0 = ancHat2ItemDef.maleModel0;
                itemDef.femaleModel0 = ancHat2ItemDef.femaleModel0;
                itemDef.xan2d = ancHat2ItemDef.xan2d;
                itemDef.zoom2d = ancHat2ItemDef.zoom2d;
                itemDef.yan2d = ancHat2ItemDef.yan2d;
                itemDef.yOffset2d = ancHat2ItemDef.yOffset2d;
                itemDef.xOffset2d = ancHat2ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43544, 6798, 5268, 6323, 6331, 6340, 6348, 6356, 6364, 43301, 6973, 4550};
                itemDef.colorFind = new int[]{36133, 36133, 6798, 5268, 36133, 36133, 36133, 36133, 36133, 36133, 0, 0, 4550};
                //under hat, under hat, strip under buckle, strip under buckle, lowest top layer (not the trim), strip above buckle
                //next part up on hat (beginning of curve/tip), next part up, next part up, tip, trim, buckle, not sure
                break;
            case 29004:
                ItemDefinition ancTop2ItemDef = lookup(21021);
                //itemDef.setDefaults();
                itemDef.id = 29004;
                itemDef.name = "Ancestral robe top @gre@T3";
                itemDef.modelId = ancTop2ItemDef.modelId;
                itemDef.maleModel0 = ancTop2ItemDef.maleModel0;
                itemDef.maleModel1 = ancTop2ItemDef.maleModel1; //male model 2
                itemDef.femaleModel0 = ancTop2ItemDef.femaleModel0;
                itemDef.femaleModel1 = ancTop2ItemDef.femaleModel1; //female model 2
                itemDef.xan2d = ancTop2ItemDef.xan2d;
                itemDef.zoom2d = ancTop2ItemDef.zoom2d;
                itemDef.yan2d = ancTop2ItemDef.yan2d;
                itemDef.yOffset2d = ancTop2ItemDef.yOffset2d;
                itemDef.xOffset2d = ancTop2ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{36133, 36133, 1050, 1050, 36133, 1035, 36133, 1050, 1050, 1050, 36133, 0, 1050};
                //part where it meets the waist (only shows on floor)
                //right side wrap, maybe under left armpit as well
                //wrist cuffs
                //wrist cuffs lower
                //waist wrap
                //line going at a curve starting at the waist, over the shoulder and to the back waist
                //bottom and top of sleeves and outer collar
                //top of torso and top of sleeves
                //upper waist line going around from front to back, and part of sleeves
                //below left breast, goes around to the back around the left side
                //front and back of left breast, as well as biceps
                //outer trim of buckle
                //remaining part of arm below the bicep, and the inner trim of buckle
                break;
            case 29005:
                ItemDefinition ancBottom2ItemDef = lookup(21024);
                itemDef.setDefaults();
                itemDef.id = 29005;
                itemDef.name = "Ancestral robe bottom @gre@T3";
                itemDef.modelId = ancBottom2ItemDef.modelId;
                itemDef.maleModel0 = ancBottom2ItemDef.maleModel0;
                itemDef.femaleModel0 = ancBottom2ItemDef.femaleModel0;
                itemDef.xan2d = ancBottom2ItemDef.xan2d;
                itemDef.zoom2d = ancBottom2ItemDef.zoom2d;
                itemDef.yan2d = ancBottom2ItemDef.yan2d;
                itemDef.yOffset2d = ancBottom2ItemDef.yOffset2d;
                itemDef.xOffset2d = ancBottom2ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{36133, 36133, 1050, 1050, 36133, 1035, 36133, 1050, 1050, 1050, 36133, 0, 1050};
                break;

            case 29006:
                ItemDefinition ancHat3ItemDef = lookup(21018);
                itemDef.setDefaults();
                itemDef.id = 29006;
                itemDef.name = "Ancestral hat @gre@T4";
                itemDef.modelId = ancHat3ItemDef.modelId;
                itemDef.maleModel0 = ancHat3ItemDef.maleModel0;
                itemDef.femaleModel0 = ancHat3ItemDef.femaleModel0;
                itemDef.xan2d = ancHat3ItemDef.xan2d;
                itemDef.zoom2d = ancHat3ItemDef.zoom2d;
                itemDef.yan2d = ancHat3ItemDef.yan2d;
                itemDef.yOffset2d = ancHat3ItemDef.yOffset2d;
                itemDef.xOffset2d = ancHat3ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43544, 6798, 5268, 6323, 6331, 6340, 6348, 6356, 6364, 43301, 6973, 4550};
                itemDef.colorFind = new int[]{675, 675, 6798, 5268, 675, 675, 675, 675, 675, 675, 0, 0, 4550};
                //under hat, under hat, strip under buckle, strip under buckle, lowest top layer (not the trim), strip above buckle
                //next part up on hat (beginning of curve/tip), next part up, next part up, tip, trim, buckle, not sure
                break;
            case 29007:
                ItemDefinition ancTop3ItemDef = lookup(21021);
                itemDef.setDefaults();
                itemDef.id = 29007;
                itemDef.name = "Ancestral robe top @gre@T4";
                itemDef.modelId = ancTop3ItemDef.modelId;
                itemDef.maleModel0 = ancTop3ItemDef.maleModel0;
                itemDef.maleModel1 = ancTop3ItemDef.maleModel1; //male model 2
                itemDef.femaleModel0 = ancTop3ItemDef.femaleModel0;
                itemDef.femaleModel1 = ancTop3ItemDef.femaleModel1; //female model 2
                itemDef.xan2d = ancTop3ItemDef.xan2d;
                itemDef.zoom2d = ancTop3ItemDef.zoom2d;
                itemDef.yan2d = ancTop3ItemDef.yan2d;
                itemDef.yOffset2d = ancTop3ItemDef.yOffset2d;
                itemDef.xOffset2d = ancTop3ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{675, 675, 1050, 1050, 675, 1035, 675, 1050, 1050, 1050, 675, 0, 1050};
                //part where it meets the waist (only shows on floor)
                //right side wrap, maybe under left armpit as well
                //wrist cuffs
                //wrist cuffs lower
                //waist wrap
                //line going at a curve starting at the waist, over the shoulder and to the back waist
                //bottom and top of sleeves and outer collar
                //top of torso and top of sleeves
                //upper waist line going around from front to back, and part of sleeves
                //below left breast, goes around to the back around the left side
                //front and back of left breast, as well as biceps
                //outer trim of buckle
                //remaining part of arm below the bicep, and the inner trim of buckle
                break;
            case 29008:
                ItemDefinition ancBottom3ItemDef = lookup(21024);
                itemDef.setDefaults();
                itemDef.id = 29008;
                itemDef.name = "Ancestral robe bottom @gre@T4";
                itemDef.modelId = ancBottom3ItemDef.modelId;
                itemDef.maleModel0 = ancBottom3ItemDef.maleModel0;
                itemDef.femaleModel0 = ancBottom3ItemDef.femaleModel0;
                itemDef.xan2d = ancBottom3ItemDef.xan2d;
                itemDef.zoom2d = ancBottom3ItemDef.zoom2d;
                itemDef.yan2d = ancBottom3ItemDef.yan2d;
                itemDef.yOffset2d = ancBottom3ItemDef.yOffset2d;
                itemDef.xOffset2d = ancBottom3ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{675, 675, 1050, 1050, 675, 1035, 675, 1050, 1050, 1050, 675, 0, 1050};
                break;

            case 29009:
                ItemDefinition ancHat4ItemDef = lookup(21018);
                itemDef.setDefaults();
                itemDef.id = 29009;
                itemDef.name = "Ancestral hat @gre@T5";
                itemDef.modelId = ancHat4ItemDef.modelId;
                itemDef.maleModel0 = ancHat4ItemDef.maleModel0;
                itemDef.femaleModel0 = ancHat4ItemDef.femaleModel0;
                itemDef.xan2d = ancHat4ItemDef.xan2d;
                itemDef.zoom2d = ancHat4ItemDef.zoom2d;
                itemDef.yan2d = ancHat4ItemDef.yan2d;
                itemDef.yOffset2d = ancHat4ItemDef.yOffset2d;
                itemDef.xOffset2d = ancHat4ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43544, 6798, 5268, 6323, 6331, 6340, 6348, 6356, 6364, 43301, 6973, 4550};
                itemDef.colorFind = new int[]{49863, 49863, 6798, 5268, 49863, 49863, 49863, 49863, 49863, 49863, 0, 0, 4550};
                //under hat, under hat, strip under buckle, strip under buckle, lowest top layer (not the trim), strip above buckle
                //next part up on hat (beginning of curve/tip), next part up, next part up, tip, trim, buckle, not sure
                break;
            case 29010:
                ItemDefinition ancTop4ItemDef = lookup(21021);
                itemDef.setDefaults();
                itemDef.id = 29010;
                itemDef.name = "Ancestral robe top @gre@T5";
                itemDef.modelId = ancTop4ItemDef.modelId;
                itemDef.maleModel0 = ancTop4ItemDef.maleModel0;
                itemDef.maleModel1 = ancTop4ItemDef.maleModel1;
                itemDef.femaleModel0 = ancTop4ItemDef.femaleModel0;
                itemDef.femaleModel1 = ancTop4ItemDef.femaleModel1;
                itemDef.xan2d = ancTop4ItemDef.xan2d;
                itemDef.zoom2d = ancTop4ItemDef.zoom2d;
                itemDef.yan2d = ancTop4ItemDef.yan2d;
                itemDef.yOffset2d = ancTop4ItemDef.yOffset2d;
                itemDef.xOffset2d = ancTop4ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{49863, 49863, 1050, 1050, 49863, 1035, 49863, 1050, 1050, 1050, 49863, 0, 1050};
                //part where it meets the waist (only shows on floor)
                //right side wrap, maybe under left armpit as well
                //wrist cuffs
                //wrist cuffs lower
                //waist wrap
                //line going at a curve starting at the waist, over the shoulder and to the back waist
                //bottom and top of sleeves and outer collar
                //top of torso and top of sleeves
                //upper waist line going around from front to back, and part of sleeves
                //below left breast, goes around to the back around the left side
                //front and back of left breast, as well as biceps
                //outer trim of buckle
                //remaining part of arm below the bicep, and the inner trim of buckle
                break;
            case 29011:
                ItemDefinition ancBottom4ItemDef = lookup(21024);
                itemDef.setDefaults();
                itemDef.id = 29011;
                itemDef.name = "Ancestral robe bottom @gre@T5";
                itemDef.modelId = ancBottom4ItemDef.modelId;
                itemDef.maleModel0 = ancBottom4ItemDef.maleModel0;
                itemDef.femaleModel0 = ancBottom4ItemDef.femaleModel0;
                itemDef.xan2d = ancBottom4ItemDef.xan2d;
                itemDef.zoom2d = ancBottom4ItemDef.zoom2d;
                itemDef.yan2d = ancBottom4ItemDef.yan2d;
                itemDef.yOffset2d = ancBottom4ItemDef.yOffset2d;
                itemDef.xOffset2d = ancBottom4ItemDef.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 49197, 49209, 49218, 5268, 6323, 6331, 6348, 43301, 43305, 43311, 6973, 7108};
                itemDef.colorFind = new int[]{49863, 49863, 1050, 1050, 49863, 1035, 49863, 1050, 1050, 1050, 49863, 0, 1050};
                break;
            case 29012:
                ItemDefinition copyItemDefRapier = lookup(27098);
                itemDef.setDefaults();
                itemDef.id = 29012;
                itemDef.name = "Ghrazi rapier Upgrade Kit";
                itemDef.modelId = copyItemDefRapier.modelId;
                itemDef.xan2d = copyItemDefRapier.xan2d;
                itemDef.zoom2d = copyItemDefRapier.zoom2d;
                itemDef.yan2d = copyItemDefRapier.yan2d;
                itemDef.yOffset2d = copyItemDefRapier.yOffset2d;
                itemDef.xOffset2d = copyItemDefRapier.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 29013:
                ItemDefinition rapierOne = lookup(22324);
                itemDef.modelId = 35739;
                itemDef.name = "Ghrazi rapier @gre@T3";

                itemDef.zoom2d = rapierOne.zoom2d;
                itemDef.xan2d = rapierOne.xan2d;
                itemDef.yan2d = rapierOne.yan2d;
                itemDef.zan2d = rapierOne.zan2d;
                itemDef.yOffset2d = rapierOne.yOffset2d;
                itemDef.xOffset2d = rapierOne.xOffset2d;

                itemDef.maleModel0 = 35374;
                itemDef.femaleModel0 = 35369;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null; //43113: part of blade, 43090: rest of the blade
                itemDef.interfaceOptions[4] = "Drop"; // 43034, 64414, 43047, 43059, 43090, 43113
                itemDef.colorReplace = new int[]{43113, 43090};
                itemDef.colorFind = new int[]{36133, 36133};
                break;
            case 29014:
                ItemDefinition rapierTwo = lookup(22324);
                itemDef.modelId = 35739;
                itemDef.name = "Ghrazi rapier @gre@T4";

                itemDef.zoom2d = rapierTwo.zoom2d;
                itemDef.xan2d = rapierTwo.xan2d;
                itemDef.yan2d = rapierTwo.yan2d;
                itemDef.zan2d = rapierTwo.zan2d;
                itemDef.yOffset2d = rapierTwo.yOffset2d;
                itemDef.xOffset2d = rapierTwo.xOffset2d;

                itemDef.maleModel0 = 35374;
                itemDef.femaleModel0 = 35369;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null; //43113: part of blade, 43090: rest of the blade
                itemDef.interfaceOptions[4] = "Drop"; // 43034, 64414, 43047, 43059, 43090, 43113
                itemDef.colorReplace = new int[]{43113, 43090};
                itemDef.colorFind = new int[]{49863, 49863};
                break;
            case 29015:
                ItemDefinition rapierThree = lookup(22324);
                itemDef.modelId = 35739;
                itemDef.name = "Ghrazi rapier @gre@T5";

                itemDef.zoom2d = rapierThree.zoom2d;
                itemDef.xan2d = rapierThree.xan2d;
                itemDef.yan2d = rapierThree.yan2d;
                itemDef.zan2d = rapierThree.zan2d;
                itemDef.yOffset2d = rapierThree.yOffset2d;
                itemDef.xOffset2d = rapierThree.xOffset2d;

                itemDef.maleModel0 = 35374;
                itemDef.femaleModel0 = 35369;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null; //43113: part of blade, 43090: rest of the blade
                itemDef.interfaceOptions[4] = "Drop"; // 43034, 64414, 43047, 43059, 43090, 43113
                itemDef.colorReplace = new int[]{43113, 43090};
                itemDef.colorFind = new int[]{675, 675};
                break;
            case 29016:
                ItemDefinition infernal2 = lookup(21295);
                itemDef.setDefaults();
                itemDef.id = 29016;
                itemDef.name = "Infernal Cape @gre@T2";
                itemDef.modelId = infernal2.modelId;
                itemDef.maleModel0 = infernal2.maleModel0;
                itemDef.femaleModel0 = infernal2.femaleModel0;
                itemDef.xan2d = infernal2.xan2d;
                itemDef.zoom2d = infernal2.zoom2d;
                itemDef.yan2d = infernal2.yan2d;
                itemDef.yOffset2d = infernal2.yOffset2d;
                itemDef.xOffset2d = infernal2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 28, 924, 3005, 5056, 5066};
                itemDef.colorFind = new int[]{3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990};
                break;
            case 29017:
                ItemDefinition infernal3 = lookup(21295);
                itemDef.setDefaults();
                itemDef.id = 29017;
                itemDef.name = "Infernal Cape @gre@T3";
                itemDef.modelId = infernal3.modelId;
                itemDef.maleModel0 = infernal3.maleModel0;
                itemDef.femaleModel0 = infernal3.femaleModel0;
                itemDef.xan2d = infernal3.xan2d;
                itemDef.zoom2d = infernal3.zoom2d;
                itemDef.yan2d = infernal3.yan2d;
                itemDef.yOffset2d = infernal3.yOffset2d;
                itemDef.xOffset2d = infernal3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 28, 924, 3005, 5056, 5066};
                itemDef.colorFind = new int[]{36133, 36133, 36133, 36133, 36133, 36133, 36133, 36133, 36133, 36133, 36133};
                break;
            case 29018:
                ItemDefinition infernal4 = lookup(21295);
                itemDef.setDefaults();
                itemDef.id = 29018;
                itemDef.name = "Infernal Cape @gre@T4";
                itemDef.modelId = infernal4.modelId;
                itemDef.maleModel0 = infernal4.maleModel0;
                itemDef.femaleModel0 = infernal4.femaleModel0;
                itemDef.xan2d = infernal4.xan2d;
                itemDef.zoom2d = infernal4.zoom2d;
                itemDef.yan2d = infernal4.yan2d;
                itemDef.yOffset2d = infernal4.yOffset2d;
                itemDef.xOffset2d = infernal4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 28, 924, 3005, 5056, 5066};
                itemDef.colorFind = new int[]{49863, 49863, 49863, 49863, 49863, 49863, 49863, 49863, 49863, 49863, 49863};
                break;
            case 29019:
                ItemDefinition infernal5 = lookup(21295);
                itemDef.setDefaults();
                itemDef.id = 29019;
                itemDef.name = "Infernal Cape @gre@T5";
                itemDef.modelId = infernal5.modelId;
                itemDef.maleModel0 = infernal5.maleModel0;
                itemDef.femaleModel0 = infernal5.femaleModel0;
                itemDef.xan2d = infernal5.xan2d;
                itemDef.zoom2d = infernal5.zoom2d;
                itemDef.yan2d = infernal5.yan2d;
                itemDef.yOffset2d = infernal5.yOffset2d;
                itemDef.xOffset2d = infernal5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 28, 924, 3005, 5056, 5066};
                itemDef.colorFind = new int[]{675, 675, 675, 675, 675, 675, 675, 675, 675, 675, 675};
                break;
            case 25867:
                itemDef.name = "Bow of Faerdhinen @gre@T2";
                break;
            case 25896:
                itemDef.name = "Bow of Faerdhinen @gre@T3";
                break;
            case 25888:
                itemDef.name = "Bow of Faerdhinen @gre@T4";
                break;
            case 25886:
                itemDef.name = "Bow of Faerdhinen @gre@T5";
                break;
            case 29020:
                ItemDefinition copyItemDef1 = lookup(24187);
                itemDef.setDefaults();
                itemDef.id = 29020;
                itemDef.name = "Faerdhinen Upgrade Scroll";
                itemDef.modelId = copyItemDef1.modelId;
                itemDef.xan2d = copyItemDef1.xan2d;
                itemDef.zoom2d = copyItemDef1.zoom2d;
                itemDef.yan2d = copyItemDef1.yan2d;
                itemDef.yOffset2d = copyItemDef1.yOffset2d;
                itemDef.xOffset2d = copyItemDef1.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 29021:
                ItemDefinition assembler = lookup(24222);
                itemDef.setDefaults();
                itemDef.id = 29021;
                itemDef.name = "Ava's assembler @gre@T2";
                itemDef.modelId = assembler.modelId;
                itemDef.maleModel0 = assembler.maleModel0;
                itemDef.femaleModel0 = assembler.femaleModel0;
                itemDef.xan2d = assembler.xan2d;
                itemDef.zoom2d = assembler.zoom2d;
                itemDef.yan2d = assembler.yan2d;
                itemDef.yOffset2d = assembler.yOffset2d;
                itemDef.xOffset2d = assembler.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 28, 54302, 33, 10279, 54317, 58419, 10291, 16450, 15434, 16462, 16466, 17500, 103, 58539, 34991, 35012, 37060, 35247, 35251, 35255, 35259, 35264, 35270, 40757, 6028, 929, 40871};
                itemDef.colorFind = new int[]{675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655};
                break;
            case 29022:
                ItemDefinition assembler3 = lookup(24222);
                itemDef.setDefaults();
                itemDef.id = 29022;
                itemDef.name = "Ava's assembler @gre@T3";
                itemDef.modelId = assembler3.modelId;
                itemDef.maleModel0 = assembler3.maleModel0;
                itemDef.femaleModel0 = assembler3.femaleModel0;
                itemDef.xan2d = assembler3.xan2d;
                itemDef.zoom2d = assembler3.zoom2d;
                itemDef.yan2d = assembler3.yan2d;
                itemDef.yOffset2d = assembler3.yOffset2d;
                itemDef.xOffset2d = assembler3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 28, 54302, 33, 10279, 54317, 58419, 10291, 16450, 15434, 16462, 16466, 17500, 103, 58539, 34991, 35012, 37060, 35247, 35251, 35255, 35259, 35264, 35270, 40757, 6028, 929, 40871};
                itemDef.colorFind = new int[]{36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115};
                break;
            case 29023:
                ItemDefinition assembler4 = lookup(24222);
                itemDef.setDefaults();
                itemDef.id = 29023;
                itemDef.name = "Ava's assembler @gre@T4";
                itemDef.modelId = assembler4.modelId;
                itemDef.maleModel0 = assembler4.maleModel0;
                itemDef.femaleModel0 = assembler4.femaleModel0;
                itemDef.xan2d = assembler4.xan2d;
                itemDef.zoom2d = assembler4.zoom2d;
                itemDef.yan2d = assembler4.yan2d;
                itemDef.yOffset2d = assembler4.yOffset2d;
                itemDef.xOffset2d = assembler4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 28, 54302, 33, 10279, 54317, 58419, 10291, 16450, 15434, 16462, 16466, 17500, 103, 58539, 34991, 35012, 37060, 35247, 35251, 35255, 35259, 35264, 35270, 40757, 6028, 929, 40871};
                itemDef.colorFind = new int[]{49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845};
                break;
            case 29024:
                ItemDefinition assembler5 = lookup(24222);
                itemDef.setDefaults();
                itemDef.id = 29024;
                itemDef.name = "Ava's assembler @gre@T5";
                itemDef.modelId = assembler5.modelId;
                itemDef.maleModel0 = assembler5.maleModel0;
                itemDef.femaleModel0 = assembler5.femaleModel0;
                itemDef.xan2d = assembler5.xan2d;
                itemDef.zoom2d = assembler5.zoom2d;
                itemDef.yan2d = assembler5.yan2d;
                itemDef.yOffset2d = assembler5.yOffset2d;
                itemDef.xOffset2d = assembler5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 28, 54302, 33, 10279, 54317, 58419, 10291, 16450, 15434, 16462, 16466, 17500, 103, 58539, 34991, 35012, 37060, 35247, 35251, 35255, 35259, 35264, 35270, 40757, 6028, 929, 40871};
                itemDef.colorFind = new int[]{1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400};
                break;
            case 29025:
                ItemDefinition copyItemDefScroll1 = lookup(25478);
                itemDef.setDefaults();
                itemDef.id = 29025;
                itemDef.name = "Assembler Upgrade Scroll";
                itemDef.modelId = copyItemDefScroll1.modelId;
                itemDef.xan2d = copyItemDefScroll1.xan2d;
                itemDef.zoom2d = copyItemDefScroll1.zoom2d;
                itemDef.yan2d = copyItemDefScroll1.yan2d;
                itemDef.yOffset2d = copyItemDefScroll1.yOffset2d;
                itemDef.xOffset2d = copyItemDefScroll1.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;
            case 29026:
                ItemDefinition eliteVoidBottom2 = lookup(13073);
                itemDef.setDefaults();
                itemDef.id = 29026;
                itemDef.name = "Elite void robe @gre@T2";
                itemDef.modelId = eliteVoidBottom2.modelId;
                itemDef.maleModel0 = eliteVoidBottom2.maleModel0;
                itemDef.femaleModel0 = eliteVoidBottom2.femaleModel0;
                itemDef.xan2d = eliteVoidBottom2.xan2d;
                itemDef.zoom2d = eliteVoidBottom2.zoom2d;
                itemDef.yan2d = eliteVoidBottom2.yan2d;
                itemDef.yOffset2d = eliteVoidBottom2.yOffset2d;
                itemDef.xOffset2d = eliteVoidBottom2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 82, 111, 115, 119, 123, 127};
                itemDef.colorFind = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 6073, 6065, 6073, 6065, 6073, 6065};
                break;
            case 29027:
                ItemDefinition eliteVoidTop2 = lookup(13072);
                itemDef.setDefaults();
                itemDef.id = 29027;
                itemDef.name = "Elite void top @gre@T2";
                itemDef.modelId = eliteVoidTop2.modelId;
                itemDef.maleModel0 = eliteVoidTop2.maleModel0;
                itemDef.maleModel1 = eliteVoidTop2.maleModel1; //male model 2
                itemDef.femaleModel0 = eliteVoidTop2.femaleModel0;
                itemDef.femaleModel1 = eliteVoidTop2.femaleModel1; //female model 2
                itemDef.xan2d = eliteVoidTop2.xan2d;
                itemDef.zoom2d = eliteVoidTop2.zoom2d;
                itemDef.yan2d = eliteVoidTop2.yan2d;
                itemDef.yOffset2d = eliteVoidTop2.yOffset2d;
                itemDef.xOffset2d = eliteVoidTop2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 103, 111, 115, 119, 123, 127, 7322, 7326, 7442, 7446};
                itemDef.colorFind = new int[]{0, 8, 12, 16, 20, 24, 6073, 6065, 6073, 6065, 6073, 6065, 7322, 7326, 7442, 7446};
                break;

            case 29028:
                ItemDefinition eliteVoidBottom3 = lookup(13073);
                itemDef.setDefaults();
                itemDef.id = 29028;
                itemDef.name = "Elite void robe @gre@T3";
                itemDef.modelId = eliteVoidBottom3.modelId;
                itemDef.maleModel0 = eliteVoidBottom3.maleModel0;
                itemDef.femaleModel0 = eliteVoidBottom3.femaleModel0;
                itemDef.xan2d = eliteVoidBottom3.xan2d;
                itemDef.zoom2d = eliteVoidBottom3.zoom2d;
                itemDef.yan2d = eliteVoidBottom3.yan2d;
                itemDef.yOffset2d = eliteVoidBottom3.yOffset2d;
                itemDef.xOffset2d = eliteVoidBottom3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 82, 111, 115, 119, 123, 127};
                itemDef.colorFind = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 36133, 36125, 36133, 36125, 36133, 36125};
                break;
            case 29029:
                ItemDefinition eliteVoidTop3 = lookup(13072);
                itemDef.setDefaults();
                itemDef.id = 29029;
                itemDef.name = "Elite void top @gre@T3";
                itemDef.modelId = eliteVoidTop3.modelId;
                itemDef.maleModel0 = eliteVoidTop3.maleModel0;
                itemDef.maleModel1 = eliteVoidTop3.maleModel1; //male model 2
                itemDef.femaleModel0 = eliteVoidTop3.femaleModel0;
                itemDef.femaleModel1 = eliteVoidTop3.femaleModel1; //female model 2
                itemDef.xan2d = eliteVoidTop3.xan2d;
                itemDef.zoom2d = eliteVoidTop3.zoom2d;
                itemDef.yan2d = eliteVoidTop3.yan2d;
                itemDef.yOffset2d = eliteVoidTop3.yOffset2d;
                itemDef.xOffset2d = eliteVoidTop3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 103, 111, 115, 119, 123, 127, 7322, 7326, 7442, 7446};
                itemDef.colorFind = new int[]{0, 8, 12, 16, 20, 24, 36133, 36125, 36133, 36125, 36133, 36125, 7322, 7326, 7442, 7446};
                break;

            case 29030:
                ItemDefinition eliteVoidBottom4 = lookup(13073);
                itemDef.setDefaults();
                itemDef.id = 29030;
                itemDef.name = "Elite void robe @gre@T4";
                itemDef.modelId = eliteVoidBottom4.modelId;
                itemDef.maleModel0 = eliteVoidBottom4.maleModel0;
                itemDef.femaleModel0 = eliteVoidBottom4.femaleModel0;
                itemDef.xan2d = eliteVoidBottom4.xan2d;
                itemDef.zoom2d = eliteVoidBottom4.zoom2d;
                itemDef.yan2d = eliteVoidBottom4.yan2d;
                itemDef.yOffset2d = eliteVoidBottom4.yOffset2d;
                itemDef.xOffset2d = eliteVoidBottom4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 82, 111, 115, 119, 123, 127};
                itemDef.colorFind = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 49863, 49855, 49863, 49855, 49863, 49855};
                break;
            case 29031:
                ItemDefinition eliteVoidTop4 = lookup(13072);
                itemDef.setDefaults();
                itemDef.id = 29031;
                itemDef.name = "Elite void top @gre@T4";
                itemDef.modelId = eliteVoidTop4.modelId;
                itemDef.maleModel0 = eliteVoidTop4.maleModel0;
                itemDef.maleModel1 = eliteVoidTop4.maleModel1; //male model 2
                itemDef.femaleModel0 = eliteVoidTop4.femaleModel0;
                itemDef.femaleModel1 = eliteVoidTop4.femaleModel1; //female model 2
                itemDef.xan2d = eliteVoidTop4.xan2d;
                itemDef.zoom2d = eliteVoidTop4.zoom2d;
                itemDef.yan2d = eliteVoidTop4.yan2d;
                itemDef.yOffset2d = eliteVoidTop4.yOffset2d;
                itemDef.xOffset2d = eliteVoidTop4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 103, 111, 115, 119, 123, 127, 7322, 7326, 7442, 7446};
                itemDef.colorFind = new int[]{0, 8, 12, 16, 20, 24, 49863, 49855, 49863, 49855, 49863, 49855, 7322, 7326, 7442, 7446};
                break;

            case 29032:
                ItemDefinition eliteVoidBottom5 = lookup(13073);
                itemDef.setDefaults();
                itemDef.id = 29032;
                itemDef.name = "Elite void robe @gre@T5";
                itemDef.modelId = eliteVoidBottom5.modelId;
                itemDef.maleModel0 = eliteVoidBottom5.maleModel0;
                itemDef.femaleModel0 = eliteVoidBottom5.femaleModel0;
                itemDef.xan2d = eliteVoidBottom5.xan2d;
                itemDef.zoom2d = eliteVoidBottom5.zoom2d;
                itemDef.yan2d = eliteVoidBottom5.yan2d;
                itemDef.yOffset2d = eliteVoidBottom5.yOffset2d;
                itemDef.xOffset2d = eliteVoidBottom5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 82, 111, 115, 119, 123, 127};
                itemDef.colorFind = new int[]{12, 16, 20, 24, 33, 37, 21559, 21563, 21568, 66, 21572, 21576, 21580, 675, 665, 675, 665, 675, 665};
                break;
            case 29033:
                ItemDefinition eliteVoidTop5 = lookup(13072);
                itemDef.setDefaults();
                itemDef.id = 29033;
                itemDef.name = "Elite void top @gre@T5";
                itemDef.modelId = eliteVoidTop5.modelId;
                itemDef.maleModel0 = eliteVoidTop5.maleModel0;
                itemDef.maleModel1 = eliteVoidTop5.maleModel1; //male model 2
                itemDef.femaleModel0 = eliteVoidTop5.femaleModel0;
                itemDef.femaleModel1 = eliteVoidTop5.femaleModel1; //female model 2
                itemDef.xan2d = eliteVoidTop5.xan2d;
                itemDef.zoom2d = eliteVoidTop5.zoom2d;
                itemDef.yan2d = eliteVoidTop5.yan2d;
                itemDef.yOffset2d = eliteVoidTop5.yOffset2d;
                itemDef.xOffset2d = eliteVoidTop5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 24, 103, 111, 115, 119, 123, 127, 7322, 7326, 7442, 7446};
                itemDef.colorFind = new int[]{0, 8, 12, 16, 20, 24, 675, 665, 675, 665, 675, 665, 7322, 7326, 7442, 7446};
                break;

            case 29034:
                ItemDefinition voidKit = lookup(26479);
                itemDef.setDefaults();
                itemDef.id = 29034;
                itemDef.name = "Elite Void Upgrade Kit";
                itemDef.modelId = voidKit.modelId;
                itemDef.xan2d = voidKit.xan2d;
                itemDef.zoom2d = voidKit.zoom2d;
                itemDef.yan2d = voidKit.yan2d;
                itemDef.yOffset2d = voidKit.yOffset2d;
                itemDef.xOffset2d = voidKit.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;

            case 29035:
                ItemDefinition elysian = lookup(12817);
                itemDef.setDefaults();
                itemDef.id = 29035;
                itemDef.name = "Elysian spirit shield @gre@T2";
                itemDef.modelId = elysian.modelId;
                itemDef.maleModel0 = elysian.maleModel0;
                itemDef.maleModel1 = elysian.maleModel1; //male model 2
                itemDef.femaleModel0 = elysian.femaleModel0;
                itemDef.femaleModel1 = elysian.femaleModel1; //female model 2
                itemDef.xan2d = elysian.xan2d;
                itemDef.zoom2d = elysian.zoom2d;
                itemDef.yan2d = elysian.yan2d;
                itemDef.yOffset2d = elysian.yOffset2d;
                itemDef.xOffset2d = elysian.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 36411, 36420, 36426, 105, 36517, 43926, 36820};
                itemDef.colorFind = new int[]{3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990};
                break;

            case 3711:
                ItemDefinition elysian3 = lookup(12817);
                itemDef.setDefaults();
                itemDef.id = 3711;
                itemDef.name = "Elysian spirit shield @gre@T3";
                itemDef.modelId = elysian3.modelId;
                itemDef.maleModel0 = elysian3.maleModel0;
                itemDef.maleModel1 = elysian3.maleModel1; //male model 2
                itemDef.femaleModel0 = elysian3.femaleModel0;
                itemDef.femaleModel1 = elysian3.femaleModel1; //female model 2
                itemDef.xan2d = elysian3.xan2d;
                itemDef.zoom2d = elysian3.zoom2d;
                itemDef.yan2d = elysian3.yan2d;
                itemDef.yOffset2d = elysian3.yOffset2d;
                itemDef.xOffset2d = elysian3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 36411, 36420, 36426, 105, 36517, 43926, 36820};
                itemDef.colorFind = new int[]{36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125};
                break;

            case 3712:
                ItemDefinition elysian4 = lookup(12817);
                itemDef.setDefaults();
                itemDef.id = 3712;
                itemDef.name = "Elysian spirit shield @gre@T4";
                itemDef.modelId = elysian4.modelId;
                itemDef.maleModel0 = elysian4.maleModel0;
                itemDef.maleModel1 = elysian4.maleModel1; //male model 2
                itemDef.femaleModel0 = elysian4.femaleModel0;
                itemDef.femaleModel1 = elysian4.femaleModel1; //female model 2
                itemDef.xan2d = elysian4.xan2d;
                itemDef.zoom2d = elysian4.zoom2d;
                itemDef.yan2d = elysian4.yan2d;
                itemDef.yOffset2d = elysian4.yOffset2d;
                itemDef.xOffset2d = elysian4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 36411, 36420, 36426, 105, 36517, 43926, 36820};
                itemDef.colorFind = new int[]{49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855};
                break;

            case 3713:
                ItemDefinition elysian5 = lookup(12817);
                itemDef.setDefaults();
                itemDef.id = 3713;
                itemDef.name = "Elysian spirit shield @gre@T5";
                itemDef.modelId = elysian5.modelId;
                itemDef.maleModel0 = elysian5.maleModel0;
                itemDef.maleModel1 = elysian5.maleModel1; //male model 2
                itemDef.femaleModel0 = elysian5.femaleModel0;
                itemDef.femaleModel1 = elysian5.femaleModel1; //female model 2
                itemDef.xan2d = elysian5.xan2d;
                itemDef.zoom2d = elysian5.zoom2d;
                itemDef.yan2d = elysian5.yan2d;
                itemDef.yOffset2d = elysian5.yOffset2d;
                itemDef.xOffset2d = elysian5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 36411, 36420, 36426, 105, 36517, 43926, 36820};
                itemDef.colorFind = new int[]{675, 660, 645, 675, 660, 645, 675, 660};
                break;

            case 3869:
                ItemDefinition armadylHelmet2 = lookup(11826);
                itemDef.setDefaults();
                itemDef.id = 3869;
                itemDef.name = "Armadyl helmet @gre@T2";
                itemDef.modelId = armadylHelmet2.modelId;
                itemDef.maleModel0 = armadylHelmet2.maleModel0;
                itemDef.maleModel1 = armadylHelmet2.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylHelmet2.femaleModel0;
                itemDef.femaleModel1 = armadylHelmet2.femaleModel1; //female model 2
                itemDef.xan2d = armadylHelmet2.xan2d;
                itemDef.zoom2d = armadylHelmet2.zoom2d;
                itemDef.yan2d = armadylHelmet2.yan2d;
                itemDef.yOffset2d = armadylHelmet2.yOffset2d;
                itemDef.xOffset2d = armadylHelmet2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43030, 4661, 43076, 43080, 43084, 43088, 127, 43303, 1944, 4550, 8650};
                itemDef.colorFind = new int[]{675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655};
                break;

            case 3870:
                ItemDefinition armadylChestplate2 = lookup(11828);
                itemDef.setDefaults();
                itemDef.id = 3870;
                itemDef.name = "Armadyl chestplate @gre@T2";
                itemDef.modelId = armadylChestplate2.modelId;
                itemDef.maleModel0 = armadylChestplate2.maleModel0;
                itemDef.maleModel1 = armadylChestplate2.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChestplate2.femaleModel0;
                itemDef.femaleModel1 = armadylChestplate2.femaleModel1; //female model 2
                itemDef.xan2d = armadylChestplate2.xan2d;
                itemDef.zoom2d = armadylChestplate2.zoom2d;
                itemDef.yan2d = armadylChestplate2.yan2d;
                itemDef.yOffset2d = armadylChestplate2.yOffset2d;
                itemDef.xOffset2d = armadylChestplate2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{43047, 43088, 43096, 4550, 8650, 8658, 43072, 43076, 43084, 4550, 8650, 8658};
                itemDef.colorFind = new int[]{675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655};
                break;

            case 3871:
                ItemDefinition armadylChainskirt2 = lookup(11830);
                itemDef.setDefaults();
                itemDef.id = 3871;
                itemDef.name = "Armadyl chainskirt @gre@T2";
                itemDef.modelId = armadylChainskirt2.modelId;
                itemDef.maleModel0 = armadylChainskirt2.maleModel0;
                itemDef.maleModel1 = armadylChainskirt2.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChainskirt2.femaleModel0;
                itemDef.femaleModel1 = armadylChainskirt2.femaleModel1; //female model 2
                itemDef.xan2d = armadylChainskirt2.xan2d;
                itemDef.zoom2d = armadylChainskirt2.zoom2d;
                itemDef.yan2d = armadylChainskirt2.yan2d;
                itemDef.yOffset2d = armadylChainskirt2.yOffset2d;
                itemDef.xOffset2d = armadylChainskirt2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43047, 43063, 43072, 43080, 43088, 43096, 8650, 43047, 43051, 43063, 43072, 43080, 43088, 43096, 8650};
                itemDef.colorFind = new int[]{675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655, 675, 655};
                break;

            //
            case 3872:
                ItemDefinition armadylHelmet3 = lookup(11826);
                itemDef.setDefaults();
                itemDef.id = 3872;
                itemDef.name = "Armadyl helmet @gre@T3";
                itemDef.modelId = armadylHelmet3.modelId;
                itemDef.maleModel0 = armadylHelmet3.maleModel0;
                itemDef.maleModel1 = armadylHelmet3.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylHelmet3.femaleModel0;
                itemDef.femaleModel1 = armadylHelmet3.femaleModel1; //female model 2
                itemDef.xan2d = armadylHelmet3.xan2d;
                itemDef.zoom2d = armadylHelmet3.zoom2d;
                itemDef.yan2d = armadylHelmet3.yan2d;
                itemDef.yOffset2d = armadylHelmet3.yOffset2d;
                itemDef.xOffset2d = armadylHelmet3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43030, 4661, 43076, 43080, 43084, 43088, 127, 43303, 1944, 4550, 8650};
                itemDef.colorFind = new int[]{36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115};
                break;

            case 3873:
                ItemDefinition armadylChestplate3 = lookup(11828);
                itemDef.setDefaults();
                itemDef.id = 3873;
                itemDef.name = "Armadyl chestplate @gre@T3";
                itemDef.modelId = armadylChestplate3.modelId;
                itemDef.maleModel0 = armadylChestplate3.maleModel0;
                itemDef.maleModel1 = armadylChestplate3.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChestplate3.femaleModel0;
                itemDef.femaleModel1 = armadylChestplate3.femaleModel1; //female model 2
                itemDef.xan2d = armadylChestplate3.xan2d;
                itemDef.zoom2d = armadylChestplate3.zoom2d;
                itemDef.yan2d = armadylChestplate3.yan2d;
                itemDef.yOffset2d = armadylChestplate3.yOffset2d;
                itemDef.xOffset2d = armadylChestplate3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{43047, 43088, 43096, 4550, 8650, 8658, 43072, 43076, 43084, 4550, 8650, 8658};
                itemDef.colorFind = new int[]{36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115};
                break;

            case 3874:
                ItemDefinition armadylChainskirt3 = lookup(11830);
                itemDef.setDefaults();
                itemDef.id = 3874;
                itemDef.name = "Armadyl chainskirt @gre@T3";
                itemDef.modelId = armadylChainskirt3.modelId;
                itemDef.maleModel0 = armadylChainskirt3.maleModel0;
                itemDef.maleModel1 = armadylChainskirt3.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChainskirt3.femaleModel0;
                itemDef.femaleModel1 = armadylChainskirt3.femaleModel1; //female model 2
                itemDef.xan2d = armadylChainskirt3.xan2d;
                itemDef.zoom2d = armadylChainskirt3.zoom2d;
                itemDef.yan2d = armadylChainskirt3.yan2d;
                itemDef.yOffset2d = armadylChainskirt3.yOffset2d;
                itemDef.xOffset2d = armadylChainskirt3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43047, 43063, 43072, 43080, 43088, 43096, 8650, 43047, 43051, 43063, 43072, 43080, 43088, 43096, 8650};
                itemDef.colorFind = new int[]{36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115, 36133, 36115};
                break;

            //

            case 3875:
                ItemDefinition armadylHelmet4 = lookup(11826);
                itemDef.setDefaults();
                itemDef.id = 3875;
                itemDef.name = "Armadyl helmet @gre@T4";
                itemDef.modelId = armadylHelmet4.modelId;
                itemDef.maleModel0 = armadylHelmet4.maleModel0;
                itemDef.maleModel1 = armadylHelmet4.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylHelmet4.femaleModel0;
                itemDef.femaleModel1 = armadylHelmet4.femaleModel1; //female model 2
                itemDef.xan2d = armadylHelmet4.xan2d;
                itemDef.zoom2d = armadylHelmet4.zoom2d;
                itemDef.yan2d = armadylHelmet4.yan2d;
                itemDef.yOffset2d = armadylHelmet4.yOffset2d;
                itemDef.xOffset2d = armadylHelmet4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43030, 4661, 43076, 43080, 43084, 43088, 127, 43303, 1944, 4550, 8650};
                itemDef.colorFind = new int[]{49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845};
                break;

            case 3876:
                ItemDefinition armadylChestplate4 = lookup(11828);
                itemDef.setDefaults();
                itemDef.id = 3876;
                itemDef.name = "Armadyl chestplate @gre@T4";
                itemDef.modelId = armadylChestplate4.modelId;
                itemDef.maleModel0 = armadylChestplate4.maleModel0;
                itemDef.maleModel1 = armadylChestplate4.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChestplate4.femaleModel0;
                itemDef.femaleModel1 = armadylChestplate4.femaleModel1; //female model 2
                itemDef.xan2d = armadylChestplate4.xan2d;
                itemDef.zoom2d = armadylChestplate4.zoom2d;
                itemDef.yan2d = armadylChestplate4.yan2d;
                itemDef.yOffset2d = armadylChestplate4.yOffset2d;
                itemDef.xOffset2d = armadylChestplate4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{43047, 43088, 43096, 4550, 8650, 8658, 43072, 43076, 43084, 4550, 8650, 8658};
                itemDef.colorFind = new int[]{49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845};
                break;

            case 3877:
                ItemDefinition armadylChainskirt4 = lookup(11830);
                itemDef.setDefaults();
                itemDef.id = 3877;
                itemDef.name = "Armadyl chainskirt @gre@T4";
                itemDef.modelId = armadylChainskirt4.modelId;
                itemDef.maleModel0 = armadylChainskirt4.maleModel0;
                itemDef.maleModel1 = armadylChainskirt4.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChainskirt4.femaleModel0;
                itemDef.femaleModel1 = armadylChainskirt4.femaleModel1; //female model 2
                itemDef.xan2d = armadylChainskirt4.xan2d;
                itemDef.zoom2d = armadylChainskirt4.zoom2d;
                itemDef.yan2d = armadylChainskirt4.yan2d;
                itemDef.yOffset2d = armadylChainskirt4.yOffset2d;
                itemDef.xOffset2d = armadylChainskirt4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43047, 43063, 43072, 43080, 43088, 43096, 8650, 43047, 43051, 43063, 43072, 43080, 43088, 43096, 8650};
                itemDef.colorFind = new int[]{49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845, 49863, 49845};
                break;

            //

            case 3878:
                ItemDefinition armadylHelmet5 = lookup(11826);
                itemDef.setDefaults();
                itemDef.id = 3878;
                itemDef.name = "Armadyl helmet @gre@T5";
                itemDef.modelId = armadylHelmet5.modelId;
                itemDef.maleModel0 = armadylHelmet5.maleModel0;
                itemDef.maleModel1 = armadylHelmet5.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylHelmet5.femaleModel0;
                itemDef.femaleModel1 = armadylHelmet5.femaleModel1; //female model 2
                itemDef.xan2d = armadylHelmet5.xan2d;
                itemDef.zoom2d = armadylHelmet5.zoom2d;
                itemDef.yan2d = armadylHelmet5.yan2d;
                itemDef.yOffset2d = armadylHelmet5.yOffset2d;
                itemDef.xOffset2d = armadylHelmet5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43030, 4661, 43076, 43080, 43084, 43088, 127, 43303, 1944, 4550, 8650};
                itemDef.colorFind = new int[]{1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400};
                break;

            case 3879:
                ItemDefinition armadylChestplate5 = lookup(11828);
                itemDef.setDefaults();
                itemDef.id = 3879;
                itemDef.name = "Armadyl chestplate @gre@T5";
                itemDef.modelId = armadylChestplate5.modelId;
                itemDef.maleModel0 = armadylChestplate5.maleModel0;
                itemDef.maleModel1 = armadylChestplate5.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChestplate5.femaleModel0;
                itemDef.femaleModel1 = armadylChestplate5.femaleModel1; //female model 2
                itemDef.xan2d = armadylChestplate5.xan2d;
                itemDef.zoom2d = armadylChestplate5.zoom2d;
                itemDef.yan2d = armadylChestplate5.yan2d;
                itemDef.yOffset2d = armadylChestplate5.yOffset2d;
                itemDef.xOffset2d = armadylChestplate5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{43047, 43088, 43096, 4550, 8650, 8658, 43072, 43076, 43084, 4550, 8650, 8658};
                itemDef.colorFind = new int[]{1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400};
                break;

            case 3880:
                ItemDefinition armadylChainskirt5 = lookup(11830);
                itemDef.setDefaults();
                itemDef.id = 3880;
                itemDef.name = "Armadyl chainskirt @gre@T5";
                itemDef.modelId = armadylChainskirt5.modelId;
                itemDef.maleModel0 = armadylChainskirt5.maleModel0;
                itemDef.maleModel1 = armadylChainskirt5.maleModel1; //male model 2
                itemDef.femaleModel0 = armadylChainskirt5.femaleModel0;
                itemDef.femaleModel1 = armadylChainskirt5.femaleModel1; //female model 2
                itemDef.xan2d = armadylChainskirt5.xan2d;
                itemDef.zoom2d = armadylChainskirt5.zoom2d;
                itemDef.yan2d = armadylChainskirt5.yan2d;
                itemDef.yOffset2d = armadylChainskirt5.yOffset2d;
                itemDef.xOffset2d = armadylChainskirt5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 43047, 43063, 43072, 43080, 43088, 43096, 8650, 43047, 43051, 43063, 43072, 43080, 43088, 43096, 8650};
                itemDef.colorFind = new int[]{1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400, 1075, 6400};
                break;

            case 3881:
                ItemDefinition copyItemDefSanta1 = lookup(1050);
                itemDef.setDefaults();
                itemDef.name = "Lime santa hat";
                itemDef.modelId = copyItemDefSanta1.modelId;
                itemDef.maleModel0 = copyItemDefSanta1.maleModel0;
                itemDef.femaleModel0 = copyItemDefSanta1.femaleModel0;
                itemDef.zoom2d = copyItemDefSanta1.zoom2d;
                itemDef.xan2d = copyItemDefSanta1.xan2d;
                itemDef.yan2d = copyItemDefSanta1.yan2d;
                itemDef.yOffset2d = copyItemDefSanta1.yOffset2d;
                itemDef.xOffset2d = copyItemDefSanta1.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{933};
                itemDef.colorFind = new int[]{17350};
                break;

            case 3882:
                ItemDefinition copyItemDefSanta2 = lookup(1050);
                itemDef.setDefaults();
                itemDef.name = "Cyan santa hat";
                itemDef.modelId = copyItemDefSanta2.modelId;
                itemDef.maleModel0 = copyItemDefSanta2.maleModel0;
                itemDef.femaleModel0 = copyItemDefSanta2.femaleModel0;
                itemDef.zoom2d = copyItemDefSanta2.zoom2d;
                itemDef.xan2d = copyItemDefSanta2.xan2d;
                itemDef.yan2d = copyItemDefSanta2.yan2d;
                itemDef.yOffset2d = copyItemDefSanta2.yOffset2d;
                itemDef.xOffset2d = copyItemDefSanta2.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{933};
                itemDef.colorFind = new int[]{689484};
                break;

            case 3883:
                ItemDefinition copyItemDefSanta3 = lookup(1050);
                itemDef.setDefaults();
                itemDef.name = "Lava santa hat";
                itemDef.modelId = copyItemDefSanta3.modelId;
                itemDef.maleModel0 = copyItemDefSanta3.maleModel0;
                itemDef.femaleModel0 = copyItemDefSanta3.femaleModel0;
                itemDef.zoom2d = copyItemDefSanta3.zoom2d;
                itemDef.xan2d = copyItemDefSanta3.xan2d;
                itemDef.yan2d = copyItemDefSanta3.yan2d;
                itemDef.yOffset2d = copyItemDefSanta3.yOffset2d;
                itemDef.xOffset2d = copyItemDefSanta3.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{933};
                itemDef.colorFind = new int[]{6075};
                break;

            case 3884:
                ItemDefinition copyItemDefSanta4 = lookup(1050);
                itemDef.setDefaults();
                itemDef.name = "Granite santa hat";
                itemDef.modelId = copyItemDefSanta4.modelId;
                itemDef.maleModel0 = copyItemDefSanta4.maleModel0;
                itemDef.femaleModel0 = copyItemDefSanta4.femaleModel0;
                itemDef.zoom2d = copyItemDefSanta4.zoom2d;
                itemDef.xan2d = copyItemDefSanta4.xan2d;
                itemDef.yan2d = copyItemDefSanta4.yan2d;
                itemDef.yOffset2d = copyItemDefSanta4.yOffset2d;
                itemDef.xOffset2d = copyItemDefSanta4.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{933};
                itemDef.colorFind = new int[]{2219};
                break;

            case 23240:
                itemDef.name = "Necklace of Zenith @gre@T1";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                break;

            case 29036:
                ItemDefinition zenithNeck = lookup(23240);
                itemDef.setDefaults();
                itemDef.id = 29036;
                itemDef.name = "Necklace of Zenith @gre@T2";
                itemDef.modelId = zenithNeck.modelId;
                itemDef.maleModel0 = zenithNeck.maleModel0;
                itemDef.femaleModel0 = zenithNeck.femaleModel0;
                itemDef.xan2d = zenithNeck.xan2d;
                itemDef.zoom2d = zenithNeck.zoom2d;
                itemDef.yan2d = zenithNeck.yan2d;
                itemDef.yOffset2d = zenithNeck.yOffset2d;
                itemDef.xOffset2d = zenithNeck.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 43026, 43034, 43053, 920, 935, 712};
                itemDef.colorFind = new int[]{8776, 8776, 43026, 43034, 43053, 920, 935, 712};
                break;

            case 29037:
                ItemDefinition zenithNeck2 = lookup(23240);
                itemDef.setDefaults();
                itemDef.id = 29037;
                itemDef.name = "Necklace of Zenith @gre@T3";
                itemDef.modelId = zenithNeck2.modelId;
                itemDef.maleModel0 = zenithNeck2.maleModel0;
                itemDef.femaleModel0 = zenithNeck2.femaleModel0;
                itemDef.xan2d = zenithNeck2.xan2d;
                itemDef.zoom2d = zenithNeck2.zoom2d;
                itemDef.yan2d = zenithNeck2.yan2d;
                itemDef.yOffset2d = zenithNeck2.yOffset2d;
                itemDef.xOffset2d = zenithNeck2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 43026, 43034, 43053, 920, 935, 712};
                itemDef.colorFind = new int[]{43297, 43297, 43026, 43034, 43053, 920, 935, 712};
                break;

            case 6200:
                ItemDefinition zenithNeck4 = lookup(23240);
                itemDef.setDefaults();
                itemDef.id = 6200;
                itemDef.name = "Necklace of Zenith @gre@T4";
                itemDef.modelId = zenithNeck4.modelId;
                itemDef.maleModel0 = zenithNeck4.maleModel0;
                itemDef.femaleModel0 = zenithNeck4.femaleModel0;
                itemDef.xan2d = zenithNeck4.xan2d;
                itemDef.zoom2d = zenithNeck4.zoom2d;
                itemDef.yan2d = zenithNeck4.yan2d;
                itemDef.yOffset2d = zenithNeck4.yOffset2d;
                itemDef.xOffset2d = zenithNeck4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 43026, 43034, 43053, 920, 935, 712};
                itemDef.colorFind = new int[]{6073, 6073, 43026, 43034, 43053, 920, 935, 712};
                break;

            case 6201:
                ItemDefinition zenithNeck5 = lookup(23240);
                itemDef.setDefaults();
                itemDef.id = 6201;
                itemDef.name = "Necklace of Zenith @gre@T5";
                itemDef.modelId = zenithNeck5.modelId;
                itemDef.maleModel0 = zenithNeck5.maleModel0;
                itemDef.femaleModel0 = zenithNeck5.femaleModel0;
                itemDef.xan2d = zenithNeck5.xan2d;
                itemDef.zoom2d = zenithNeck5.zoom2d;
                itemDef.yan2d = zenithNeck5.yan2d;
                itemDef.yOffset2d = zenithNeck5.yOffset2d;
                itemDef.xOffset2d = zenithNeck5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 43026, 43034, 43053, 920, 935, 712};
                itemDef.colorFind = new int[]{9583, 9583, 43026, 43034, 43053, 920, 935, 712};
                break;

            case 29038:
                ItemDefinition avernic2 = lookup(22322);
                itemDef.setDefaults();
                itemDef.id = 29038;
                itemDef.name = "Avernic defender @gre@T2";
                itemDef.modelId = avernic2.modelId;
                itemDef.maleModel0 = avernic2.maleModel0;
                itemDef.femaleModel0 = avernic2.femaleModel0;
                itemDef.xan2d = avernic2.xan2d;
                itemDef.zoom2d = avernic2.zoom2d;
                itemDef.yan2d = avernic2.yan2d;
                itemDef.yOffset2d = avernic2.yOffset2d;
                itemDef.xOffset2d = avernic2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 10283, 7333, 8377, 8390};
                itemDef.colorFind = new int[]{6073, 6073, 6055, 24, 10283, 7333, 8377, 8390};
                break;

            case 29039:
                ItemDefinition avernic3 = lookup(22322);
                itemDef.setDefaults();
                itemDef.id = 29039;
                itemDef.name = "Avernic defender @gre@T3";
                itemDef.modelId = avernic3.modelId;
                itemDef.maleModel0 = avernic3.maleModel0;
                itemDef.femaleModel0 = avernic3.femaleModel0;
                itemDef.xan2d = avernic3.xan2d;
                itemDef.zoom2d = avernic3.zoom2d;
                itemDef.yan2d = avernic3.yan2d;
                itemDef.yOffset2d = avernic3.yOffset2d;
                itemDef.xOffset2d = avernic3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 10283, 7333, 8377, 8390};
                itemDef.colorFind = new int[]{36133, 36133, 36125, 24, 10283, 7333, 8377, 8390};
                break;

            case 29040:
                ItemDefinition avernic4 = lookup(22322);
                itemDef.setDefaults();
                itemDef.id = 29040;
                itemDef.name = "Avernic defender @gre@T4";
                itemDef.modelId = avernic4.modelId;
                itemDef.maleModel0 = avernic4.maleModel0;
                itemDef.femaleModel0 = avernic4.femaleModel0;
                itemDef.xan2d = avernic4.xan2d;
                itemDef.zoom2d = avernic4.zoom2d;
                itemDef.yan2d = avernic4.yan2d;
                itemDef.yOffset2d = avernic4.yOffset2d;
                itemDef.xOffset2d = avernic4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 10283, 7333, 8377, 8390};
                itemDef.colorFind = new int[]{49863, 49863, 49855, 24, 10283, 7333, 8377, 8390};
                break;

            case 29041:
                ItemDefinition avernic5 = lookup(22322);
                itemDef.setDefaults();
                itemDef.id = 29041;
                itemDef.name = "Avernic defender @gre@T5";
                itemDef.modelId = avernic5.modelId;
                itemDef.maleModel0 = avernic5.maleModel0;
                itemDef.femaleModel0 = avernic5.femaleModel0;
                itemDef.xan2d = avernic5.xan2d;
                itemDef.zoom2d = avernic5.zoom2d;
                itemDef.yan2d = avernic5.yan2d;
                itemDef.yOffset2d = avernic5.yOffset2d;
                itemDef.xOffset2d = avernic5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 20, 24, 10283, 7333, 8377, 8390};
                itemDef.colorFind = new int[]{675, 675, 665, 24, 10283, 7333, 8377, 8390};
                break;

            case 29042:
                ItemDefinition defenderKit = lookup(23227);
                itemDef.setDefaults();
                itemDef.id = 29042;
                itemDef.name = "Avernic Defender Upgrade Kit";
                itemDef.modelId = defenderKit.modelId;
                itemDef.xan2d = defenderKit.xan2d;
                itemDef.zoom2d = defenderKit.zoom2d;
                itemDef.yan2d = defenderKit.yan2d;
                itemDef.yOffset2d = defenderKit.yOffset2d;
                itemDef.xOffset2d = defenderKit.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;

            case 29043:
                itemDef.name = "Sanguinesti staff @gre@T3";
                itemDef.modelId = 35744;
                itemDef.maleModel0 = 35372;
                itemDef.femaleModel0 = 39555;
                itemDef.zoom2d = 2258;
                itemDef.xan2d = 552;
                itemDef.yan2d = 1558;
                itemDef.yOffset2d = -5;
                itemDef.xOffset2d = 3;
                itemDef.cost = 5000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 3127, 57, 3140, 142, 156, 284, 836};
                itemDef.colorFind = new int[]{36133, 20, 36125, 28, 36133, 35125, 41, 156, 36133, 57, 36133, 142, 156, 284, 36133};
                break;

            case 29044:
                itemDef.name = "Sanguinesti staff @gre@T4";
                itemDef.modelId = 35744;
                itemDef.maleModel0 = 35372;
                itemDef.femaleModel0 = 39555;
                itemDef.zoom2d = 2258;
                itemDef.xan2d = 552;
                itemDef.yan2d = 1558;
                itemDef.yOffset2d = -5;
                itemDef.xOffset2d = 3;
                itemDef.cost = 5000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 3127, 57, 3140, 142, 156, 284, 836};
                itemDef.colorFind = new int[]{675, 20, 665, 28, 675, 665, 41, 156, 675, 57, 675, 142, 156, 284, 675};
                break;

            case 29045:
                itemDef.name = "Sanguinesti staff @gre@T5";
                itemDef.modelId = 35744;
                itemDef.maleModel0 = 35372;
                itemDef.femaleModel0 = 39555;
                itemDef.zoom2d = 2258;
                itemDef.xan2d = 552;
                itemDef.yan2d = 1558;
                itemDef.yOffset2d = -5;
                itemDef.xOffset2d = 3;
                itemDef.cost = 5000000;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 3127, 57, 3140, 142, 156, 284, 836};
                itemDef.colorFind = new int[]{49863, 20, 49855, 28, 49863, 49855, 41, 156, 49863, 57, 49863, 142, 156, 284, 49863};
                break;

            case 29046:
                ItemDefinition sangKit = lookup(10512);
                itemDef.setDefaults();
                itemDef.id = 29046;
                itemDef.name = "Sanguinesti Upgrade Scroll";
                itemDef.modelId = sangKit.modelId;
                itemDef.xan2d = sangKit.xan2d;
                itemDef.zoom2d = sangKit.zoom2d;
                itemDef.yan2d = sangKit.yan2d;
                itemDef.yOffset2d = sangKit.yOffset2d;
                itemDef.xOffset2d = sangKit.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;

            case 12019:
                itemDef.name = "Unlimited coal bag";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;

            case 29047:
                ItemDefinition crystalBody2 = lookup(23842);
                itemDef.setDefaults();
                itemDef.id = 29047;
                itemDef.name = "Crystal helm @gre@T3";
                itemDef.modelId = crystalBody2.modelId;
                itemDef.maleModel0 = crystalBody2.maleModel0;
                itemDef.femaleModel0 = crystalBody2.femaleModel0;
                itemDef.xan2d = crystalBody2.xan2d;
                itemDef.zoom2d = crystalBody2.zoom2d;
                itemDef.yan2d = crystalBody2.yan2d;
                itemDef.yOffset2d = crystalBody2.yOffset2d;
                itemDef.xOffset2d = crystalBody2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 10283, 123, 6798, 274, 43303, 815, 827, 4550};
                itemDef.colorFind = new int[]{0, 10283, 36133, 36115, 36133, 36115, 36133, 36115, 36133};
                break;

            case 29048:
                ItemDefinition crystalBody3 = lookup(23845);
                itemDef.setDefaults();
                itemDef.id = 29048;
                itemDef.name = "Crystal body @gre@T3";
                itemDef.modelId = crystalBody3.modelId;
                itemDef.maleModel0 = crystalBody3.maleModel0;
                itemDef.maleModel1 = crystalBody3.maleModel1; //male model 2
                itemDef.femaleModel0 = crystalBody3.femaleModel0;
                itemDef.femaleModel1 = crystalBody3.femaleModel1; //female model 2
                itemDef.xan2d = crystalBody3.xan2d;
                itemDef.zoom2d = crystalBody3.zoom2d;
                itemDef.yan2d = crystalBody3.yan2d;
                itemDef.yOffset2d = crystalBody3.yOffset2d;
                itemDef.xOffset2d = crystalBody3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{32943, 274, 815, 827, 398};
                itemDef.colorFind = new int[]{36133, 36115, 36133, 36115, 36133};
                break;

            case 29049:
                ItemDefinition crystalLegs3 = lookup(23848);
                itemDef.setDefaults();
                itemDef.id = 29049;
                itemDef.name = "Crystal legs @gre@T3";
                itemDef.modelId = crystalLegs3.modelId;
                itemDef.maleModel0 = crystalLegs3.maleModel0;
                itemDef.femaleModel0 = crystalLegs3.femaleModel0;
                itemDef.xan2d = crystalLegs3.xan2d;
                itemDef.zoom2d = crystalLegs3.zoom2d;
                itemDef.yan2d = crystalLegs3.yan2d;
                itemDef.yOffset2d = crystalLegs3.yOffset2d;
                itemDef.xOffset2d = crystalLegs3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{274, 278, 398, 4550, 815, 827};
                itemDef.colorFind = new int[]{36133, 36115, 36133, 36115, 36133, 36115};
                break;

            case 29050:
                ItemDefinition crystalHelm4 = lookup(23842);
                itemDef.setDefaults();
                itemDef.id = 29050;
                itemDef.name = "Crystal helm @gre@T4";
                itemDef.modelId = crystalHelm4.modelId;
                itemDef.maleModel0 = crystalHelm4.maleModel0;
                itemDef.femaleModel0 = crystalHelm4.femaleModel0;
                itemDef.xan2d = crystalHelm4.xan2d;
                itemDef.zoom2d = crystalHelm4.zoom2d;
                itemDef.yan2d = crystalHelm4.yan2d;
                itemDef.yOffset2d = crystalHelm4.yOffset2d;
                itemDef.xOffset2d = crystalHelm4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 10283, 123, 6798, 274, 43303, 815, 827, 4550};
                itemDef.colorFind = new int[]{0, 10283, 49863, 49845, 49863, 49845, 49863, 49845, 49863};
                break;

            case 29051:
                ItemDefinition crystalBody4 = lookup(23845);
                itemDef.setDefaults();
                itemDef.id = 29051;
                itemDef.name = "Crystal body @gre@T4";
                itemDef.modelId = crystalBody4.modelId;
                itemDef.maleModel0 = crystalBody4.maleModel0;
                itemDef.maleModel1 = crystalBody4.maleModel1; //male model 2
                itemDef.femaleModel0 = crystalBody4.femaleModel0;
                itemDef.femaleModel1 = crystalBody4.femaleModel1; //female model 2
                itemDef.xan2d = crystalBody4.xan2d;
                itemDef.zoom2d = crystalBody4.zoom2d;
                itemDef.yan2d = crystalBody4.yan2d;
                itemDef.yOffset2d = crystalBody4.yOffset2d;
                itemDef.xOffset2d = crystalBody4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{32943, 274, 815, 827, 398};
                itemDef.colorFind = new int[]{49863, 49845, 49863, 49845, 49863};
                break;

            case 29052:
                ItemDefinition crystalLegs4 = lookup(23848);
                itemDef.setDefaults();
                itemDef.id = 29052;
                itemDef.name = "Crystal legs @gre@T4";
                itemDef.modelId = crystalLegs4.modelId;
                itemDef.maleModel0 = crystalLegs4.maleModel0;
                itemDef.femaleModel0 = crystalLegs4.femaleModel0;
                itemDef.xan2d = crystalLegs4.xan2d;
                itemDef.zoom2d = crystalLegs4.zoom2d;
                itemDef.yan2d = crystalLegs4.yan2d;
                itemDef.yOffset2d = crystalLegs4.yOffset2d;
                itemDef.xOffset2d = crystalLegs4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{274, 278, 398, 4550, 815, 827};
                itemDef.colorFind = new int[]{49863, 49845, 49863, 49845, 49863, 49845};
                break;

            case 29053:
                ItemDefinition crystalHelm5 = lookup(23842);
                itemDef.setDefaults();
                itemDef.id = 29053;
                itemDef.name = "Crystal helm @gre@T5";
                itemDef.modelId = crystalHelm5.modelId;
                itemDef.maleModel0 = crystalHelm5.maleModel0;
                itemDef.femaleModel0 = crystalHelm5.femaleModel0;
                itemDef.xan2d = crystalHelm5.xan2d;
                itemDef.zoom2d = crystalHelm5.zoom2d;
                itemDef.yan2d = crystalHelm5.yan2d;
                itemDef.yOffset2d = crystalHelm5.yOffset2d;
                itemDef.xOffset2d = crystalHelm5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 10283, 123, 6798, 274, 43303, 815, 827, 4550};
                itemDef.colorFind = new int[]{0, 10283, 6400, 1075, 6400, 1075, 6400, 1075, 6400};
                break;

            case 29054:
                ItemDefinition crystalBody5 = lookup(23845);
                itemDef.setDefaults();
                itemDef.id = 29054;
                itemDef.name = "Crystal body @gre@T5";
                itemDef.modelId = crystalBody5.modelId;
                itemDef.maleModel0 = crystalBody5.maleModel0;
                itemDef.maleModel1 = crystalBody5.maleModel1; //male model 2
                itemDef.femaleModel0 = crystalBody5.femaleModel0;
                itemDef.femaleModel1 = crystalBody5.femaleModel1; //female model 2
                itemDef.xan2d = crystalBody5.xan2d;
                itemDef.zoom2d = crystalBody5.zoom2d;
                itemDef.yan2d = crystalBody5.yan2d;
                itemDef.yOffset2d = crystalBody5.yOffset2d;
                itemDef.xOffset2d = crystalBody5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{32943, 274, 815, 827, 398};
                itemDef.colorFind = new int[]{6400, 1075, 6400, 1075, 6400};
                break;

            case 29055:
                ItemDefinition crystalLegs5 = lookup(23848);
                itemDef.setDefaults();
                itemDef.id = 29055;
                itemDef.name = "Crystal legs @gre@T5";
                itemDef.modelId = crystalLegs5.modelId;
                itemDef.maleModel0 = crystalLegs5.maleModel0;
                itemDef.femaleModel0 = crystalLegs5.femaleModel0;
                itemDef.xan2d = crystalLegs5.xan2d;
                itemDef.zoom2d = crystalLegs5.zoom2d;
                itemDef.yan2d = crystalLegs5.yan2d;
                itemDef.yOffset2d = crystalLegs5.yOffset2d;
                itemDef.xOffset2d = crystalLegs5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{274, 278, 398, 4550, 815, 827};
                itemDef.colorFind = new int[]{1075, 6400, 1075, 6400, 1075, 6400};
                break;

            case 29056:
                ItemDefinition copyItemDefScroll2 = lookup(24187);
                itemDef.setDefaults();
                itemDef.id = 29056;
                itemDef.name = "1 hour double seasonal tickets";
                itemDef.modelId = copyItemDefScroll2.modelId;
                itemDef.xan2d = copyItemDefScroll2.xan2d;
                itemDef.zoom2d = copyItemDefScroll2.zoom2d;
                itemDef.yan2d = copyItemDefScroll2.yan2d;
                itemDef.yOffset2d = copyItemDefScroll2.yOffset2d;
                itemDef.xOffset2d = copyItemDefScroll2.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{13051, 7070, 960};
                itemDef.colorFind = new int[]{6400, 6400, 6400};
                break;

            case 29057:
                ItemDefinition torvaHelm2 = lookup(26382);
                itemDef.setDefaults();
                itemDef.id = 29057;
                itemDef.name = "Torva Full Helm @gre@T2";
                itemDef.modelId = torvaHelm2.modelId;
                itemDef.maleModel0 = torvaHelm2.maleModel0;
                itemDef.femaleModel0 = torvaHelm2.femaleModel0;
                itemDef.xan2d = torvaHelm2.xan2d;
                itemDef.zoom2d = torvaHelm2.zoom2d;
                itemDef.yan2d = torvaHelm2.yan2d;
                itemDef.yOffset2d = torvaHelm2.yOffset2d;
                itemDef.xOffset2d = torvaHelm2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 18, 20, 24, 26, 28, 30, 33, 35, 37, 39, 41, 43, 47, 53, 55, 61, 68, 76, 78, 86, 88};
                itemDef.colorFind = new int[]{3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990};
                break;

            case 29058:
                ItemDefinition torvaPlate2 = lookup(26384);
                itemDef.setDefaults();
                itemDef.id = 29058;
                itemDef.name = "Torva platebody @gre@T2";
                itemDef.modelId = torvaPlate2.modelId;
                itemDef.maleModel0 = torvaPlate2.maleModel0;
                itemDef.maleModel1 = torvaPlate2.maleModel1; //male model 2
                itemDef.femaleModel0 = torvaPlate2.femaleModel0;
                itemDef.femaleModel1 = torvaPlate2.femaleModel1; //female model 2
                itemDef.xan2d = torvaPlate2.xan2d;
                itemDef.zoom2d = torvaPlate2.zoom2d;
                itemDef.yan2d = torvaPlate2.yan2d;
                itemDef.yOffset2d = torvaPlate2.yOffset2d;
                itemDef.xOffset2d = torvaPlate2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 22, 32790, 24, 26, 30, 33, 35, 37, 39, 41, 45, 47, 51, 59, 61, 68, 72, 76, 80, 86, 101, 545, 549, 555, 48670, 48681, 48687, 48722, 0, 8, 16, 20, 22, 32790, 24, 26, 30, 35, 41, 51, 76, 80, 48722, 0, 4, 12, 16, 20, 24, 26, 48670, 545, 33, 547, 35, 37, 39, 48679, 553, 43, 45, 48685, 57, 59, 66, 70, 74, 78, 84, 97};
                itemDef.colorFind = new int[]{3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975};
                break;

            case 29059:
                ItemDefinition torvaLegs2 = lookup(26386);
                itemDef.setDefaults();
                itemDef.id = 29059;
                itemDef.name = "Torva platelegs @gre@T2";
                itemDef.modelId = torvaLegs2.modelId;
                itemDef.maleModel0 = torvaLegs2.maleModel0;
                itemDef.femaleModel0 = torvaLegs2.femaleModel0;
                itemDef.xan2d = torvaLegs2.xan2d;
                itemDef.zoom2d = torvaLegs2.zoom2d;
                itemDef.yan2d = torvaLegs2.yan2d;
                itemDef.yOffset2d = torvaLegs2.yOffset2d;
                itemDef.xOffset2d = torvaLegs2.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{20, 22, 24, 33, 45, 51, 57, 68, 72, 78, 82, 86, 49420, 49424, 20, 22, 24, 33, 45, 49, 55, 66, 70, 76, 80, 84, 49420, 49424};
                itemDef.colorFind = new int[]{3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008};
                break;

            case 29060:
                ItemDefinition torvaHelm3 = lookup(26382);
                itemDef.setDefaults();
                itemDef.id = 29060;
                itemDef.name = "Torva Full Helm @gre@T3";
                itemDef.modelId = torvaHelm3.modelId;
                itemDef.maleModel0 = torvaHelm3.maleModel0;
                itemDef.femaleModel0 = torvaHelm3.femaleModel0;
                itemDef.xan2d = torvaHelm3.xan2d;
                itemDef.zoom2d = torvaHelm3.zoom2d;
                itemDef.yan2d = torvaHelm3.yan2d;
                itemDef.yOffset2d = torvaHelm3.yOffset2d;
                itemDef.xOffset2d = torvaHelm3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 18, 20, 24, 26, 28, 30, 33, 35, 37, 39, 41, 43, 47, 53, 55, 61, 68, 76, 78, 86, 88};
                itemDef.colorFind = new int[]{36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125};
                break;

            case 29061:
                ItemDefinition torvaPlate3 = lookup(26384);
                itemDef.setDefaults();
                itemDef.id = 29061;
                itemDef.name = "Torva platebody @gre@T3";
                itemDef.modelId = torvaPlate3.modelId;
                itemDef.maleModel0 = torvaPlate3.maleModel0;
                itemDef.maleModel1 = torvaPlate3.maleModel1; //male model 2
                itemDef.femaleModel0 = torvaPlate3.femaleModel0;
                itemDef.femaleModel1 = torvaPlate3.femaleModel1; //female model 2
                itemDef.xan2d = torvaPlate3.xan2d;
                itemDef.zoom2d = torvaPlate3.zoom2d;
                itemDef.yan2d = torvaPlate3.yan2d;
                itemDef.yOffset2d = torvaPlate3.yOffset2d;
                itemDef.xOffset2d = torvaPlate3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 22, 32790, 24, 26, 30, 33, 35, 37, 39, 41, 45, 47, 51, 59, 61, 68, 72, 76, 80, 86, 101, 545, 549, 555, 48670, 48681, 48687, 48722, 0, 8, 16, 20, 22, 32790, 24, 26, 30, 35, 41, 51, 76, 80, 48722, 0, 4, 12, 16, 20, 24, 26, 48670, 545, 33, 547, 35, 37, 39, 48679, 553, 43, 45, 48685, 57, 59, 66, 70, 74, 78, 84, 97};
                itemDef.colorFind = new int[]{36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115};
                break;

            case 29062:
                ItemDefinition torvaLegs3 = lookup(26386);
                itemDef.setDefaults();
                itemDef.id = 29062;
                itemDef.name = "Torva platelegs @gre@T3";
                itemDef.modelId = torvaLegs3.modelId;
                itemDef.maleModel0 = torvaLegs3.maleModel0;
                itemDef.femaleModel0 = torvaLegs3.femaleModel0;
                itemDef.xan2d = torvaLegs3.xan2d;
                itemDef.zoom2d = torvaLegs3.zoom2d;
                itemDef.yan2d = torvaLegs3.yan2d;
                itemDef.yOffset2d = torvaLegs3.yOffset2d;
                itemDef.xOffset2d = torvaLegs3.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{20, 22, 24, 33, 45, 51, 57, 68, 72, 78, 82, 86, 49420, 49424, 20, 22, 24, 33, 45, 49, 55, 66, 70, 76, 80, 84, 49420, 49424};
                itemDef.colorFind = new int[]{36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133};
                break;

            case 29063:
                ItemDefinition torvaHelm4 = lookup(26382);
                itemDef.setDefaults();
                itemDef.id = 29063;
                itemDef.name = "Torva Full Helm @gre@T4";
                itemDef.modelId = torvaHelm4.modelId;
                itemDef.maleModel0 = torvaHelm4.maleModel0;
                itemDef.femaleModel0 = torvaHelm4.femaleModel0;
                itemDef.xan2d = torvaHelm4.xan2d;
                itemDef.zoom2d = torvaHelm4.zoom2d;
                itemDef.yan2d = torvaHelm4.yan2d;
                itemDef.yOffset2d = torvaHelm4.yOffset2d;
                itemDef.xOffset2d = torvaHelm4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 18, 20, 24, 26, 28, 30, 33, 35, 37, 39, 41, 43, 47, 53, 55, 61, 68, 76, 78, 86, 88};
                itemDef.colorFind = new int[]{49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855};
                break;

            case 29064:
                ItemDefinition torvaPlate4 = lookup(26384);
                itemDef.setDefaults();
                itemDef.id = 29064;
                itemDef.name = "Torva platebody @gre@T4";
                itemDef.modelId = torvaPlate4.modelId;
                itemDef.maleModel0 = torvaPlate4.maleModel0;
                itemDef.maleModel1 = torvaPlate4.maleModel1; //male model 2
                itemDef.femaleModel0 = torvaPlate4.femaleModel0;
                itemDef.femaleModel1 = torvaPlate4.femaleModel1; //female model 2
                itemDef.xan2d = torvaPlate4.xan2d;
                itemDef.zoom2d = torvaPlate4.zoom2d;
                itemDef.yan2d = torvaPlate4.yan2d;
                itemDef.yOffset2d = torvaPlate4.yOffset2d;
                itemDef.xOffset2d = torvaPlate4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 22, 32790, 24, 26, 30, 33, 35, 37, 39, 41, 45, 47, 51, 59, 61, 68, 72, 76, 80, 86, 101, 545, 549, 555, 48670, 48681, 48687, 48722, 0, 8, 16, 20, 22, 32790, 24, 26, 30, 35, 41, 51, 76, 80, 48722, 0, 4, 12, 16, 20, 24, 26, 48670, 545, 33, 547, 35, 37, 39, 48679, 553, 43, 45, 48685, 57, 59, 66, 70, 74, 78, 84, 97};
                itemDef.colorFind = new int[]{49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845};
                break;

            case 29065:
                ItemDefinition torvaLegs4 = lookup(26386);
                itemDef.setDefaults();
                itemDef.id = 29065;
                itemDef.name = "Torva platelegs @gre@T4";
                itemDef.modelId = torvaLegs4.modelId;
                itemDef.maleModel0 = torvaLegs4.maleModel0;
                itemDef.femaleModel0 = torvaLegs4.femaleModel0;
                itemDef.xan2d = torvaLegs4.xan2d;
                itemDef.zoom2d = torvaLegs4.zoom2d;
                itemDef.yan2d = torvaLegs4.yan2d;
                itemDef.yOffset2d = torvaLegs4.yOffset2d;
                itemDef.xOffset2d = torvaLegs4.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{20, 22, 24, 33, 45, 51, 57, 68, 72, 78, 82, 86, 49420, 49424, 20, 22, 24, 33, 45, 49, 55, 66, 70, 76, 80, 84, 49420, 49424};
                itemDef.colorFind = new int[]{49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863};
                break;

            case 29066:
                ItemDefinition torvaHelm5 = lookup(26382);
                itemDef.setDefaults();
                itemDef.id = 29066;
                itemDef.name = "Torva Full Helm @gre@T5";
                itemDef.modelId = torvaHelm5.modelId;
                itemDef.maleModel0 = torvaHelm5.maleModel0;
                itemDef.femaleModel0 = torvaHelm5.femaleModel0;
                itemDef.xan2d = torvaHelm5.xan2d;
                itemDef.zoom2d = torvaHelm5.zoom2d;
                itemDef.yan2d = torvaHelm5.yan2d;
                itemDef.yOffset2d = torvaHelm5.yOffset2d;
                itemDef.xOffset2d = torvaHelm5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{12, 16, 18, 20, 24, 26, 28, 30, 33, 35, 37, 39, 41, 43, 47, 53, 55, 61, 68, 76, 78, 86, 88};
                itemDef.colorFind = new int[]{675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660};
                break;

            case 29067:
                ItemDefinition torvaPlate5 = lookup(26384);
                itemDef.setDefaults();
                itemDef.id = 29067;
                itemDef.name = "Torva platebody @gre@T5";
                itemDef.modelId = torvaPlate5.modelId;
                itemDef.maleModel0 = torvaPlate5.maleModel0;
                itemDef.maleModel1 = torvaPlate5.maleModel1; //male model 2
                itemDef.femaleModel0 = torvaPlate5.femaleModel0;
                itemDef.femaleModel1 = torvaPlate5.femaleModel1; //female model 2
                itemDef.xan2d = torvaPlate5.xan2d;
                itemDef.zoom2d = torvaPlate5.zoom2d;
                itemDef.yan2d = torvaPlate5.yan2d;
                itemDef.yOffset2d = torvaPlate5.yOffset2d;
                itemDef.xOffset2d = torvaPlate5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{0, 8, 12, 16, 20, 22, 32790, 24, 26, 30, 33, 35, 37, 39, 41, 45, 47, 51, 59, 61, 68, 72, 76, 80, 86, 101, 545, 549, 555, 48670, 48681, 48687, 48722, 0, 8, 16, 20, 22, 32790, 24, 26, 30, 35, 41, 51, 76, 80, 48722, 0, 4, 12, 16, 20, 24, 26, 48670, 545, 33, 547, 35, 37, 39, 48679, 553, 43, 45, 48685, 57, 59, 66, 70, 74, 78, 84, 97};
                itemDef.colorFind = new int[]{675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645,
                        675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645,
                        675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645,
                        675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645,
                        675, 660, 645, 675, 660, 645, 675, 660, 645};
                break;

            case 29068:
                ItemDefinition torvaLegs5 = lookup(26386);
                itemDef.setDefaults();
                itemDef.id = 29068;
                itemDef.name = "Torva platelegs @gre@T5";
                itemDef.modelId = torvaLegs5.modelId;
                itemDef.maleModel0 = torvaLegs5.maleModel0;
                itemDef.femaleModel0 = torvaLegs5.femaleModel0;
                itemDef.xan2d = torvaLegs5.xan2d;
                itemDef.zoom2d = torvaLegs5.zoom2d;
                itemDef.yan2d = torvaLegs5.yan2d;
                itemDef.yOffset2d = torvaLegs5.yOffset2d;
                itemDef.xOffset2d = torvaLegs5.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{20, 22, 24, 33, 45, 51, 57, 68, 72, 78, 82, 86, 49420, 49424, 20, 22, 24, 33, 45, 49, 55, 66, 70, 76, 80, 84, 49420, 49424};
                itemDef.colorFind = new int[]{675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675};
                break;

            case 29069:
                ItemDefinition copyItemDefScrollTorva = lookup(25481);
                itemDef.setDefaults();
                itemDef.id = 29069;
                itemDef.name = "Torva Upgrade Scroll";
                itemDef.modelId = copyItemDefScrollTorva.modelId;
                itemDef.xan2d = copyItemDefScrollTorva.xan2d;
                itemDef.zoom2d = copyItemDefScrollTorva.zoom2d;
                itemDef.yan2d = copyItemDefScrollTorva.yan2d;
                itemDef.yOffset2d = copyItemDefScrollTorva.yOffset2d;
                itemDef.xOffset2d = copyItemDefScrollTorva.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{0, 801, 902, 908, 918, 5035, 7091, 8121};
                itemDef.colorFind = new int[]{0, 0, 0, 0, 0, 5035, 7091, 8121};
                break;

            case 29070:
                ItemDefinition scytheTwo = lookup(22325);
                itemDef.modelId = scytheTwo.modelId;
                itemDef.name = "Scythe of vitur @gre@T2";

                itemDef.zoom2d = scytheTwo.zoom2d;
                itemDef.xan2d = scytheTwo.xan2d;
                itemDef.yan2d = scytheTwo.yan2d;
                itemDef.zan2d = scytheTwo.zan2d;
                itemDef.yOffset2d = scytheTwo.yOffset2d;
                itemDef.xOffset2d = scytheTwo.xOffset2d;

                itemDef.maleModel0 = scytheTwo.maleModel0;
                itemDef.femaleModel0 = scytheTwo.femaleModel0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 61, 78, 536, 784, 790, 796};
                itemDef.colorFind = new int[]{3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990, 2975, 3008, 2990};
                break;

            case 29071:
                ItemDefinition scytheThree = lookup(22325);
                itemDef.modelId = scytheThree.modelId;
                itemDef.name = "Scythe of vitur @gre@T3";

                itemDef.zoom2d = scytheThree.zoom2d;
                itemDef.xan2d = scytheThree.xan2d;
                itemDef.yan2d = scytheThree.yan2d;
                itemDef.zan2d = scytheThree.zan2d;
                itemDef.yOffset2d = scytheThree.yOffset2d;
                itemDef.xOffset2d = scytheThree.xOffset2d;

                itemDef.maleModel0 = scytheThree.maleModel0;
                itemDef.femaleModel0 = scytheThree.femaleModel0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 61, 78, 536, 784, 790, 796};
                itemDef.colorFind = new int[]{36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125, 36115, 36133, 36125};
                break;

            case 29072:
                ItemDefinition scytheFour = lookup(22325);
                itemDef.modelId = scytheFour.modelId;
                itemDef.name = "Scythe of vitur @gre@T4";

                itemDef.zoom2d = scytheFour.zoom2d;
                itemDef.xan2d = scytheFour.xan2d;
                itemDef.yan2d = scytheFour.yan2d;
                itemDef.zan2d = scytheFour.zan2d;
                itemDef.yOffset2d = scytheFour.yOffset2d;
                itemDef.xOffset2d = scytheFour.xOffset2d;

                itemDef.maleModel0 = scytheFour.maleModel0;
                itemDef.femaleModel0 = scytheFour.femaleModel0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 61, 78, 536, 784, 790, 796};
                itemDef.colorFind = new int[]{49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855, 49845, 49863, 49855};
                break;

            case 29073:
                ItemDefinition scytheFive = lookup(22325);
                itemDef.modelId = scytheFive.modelId;
                itemDef.name = "Scythe of vitur @gre@T5";

                itemDef.zoom2d = scytheFive.zoom2d;
                itemDef.xan2d = scytheFive.xan2d;
                itemDef.yan2d = scytheFive.yan2d;
                itemDef.zan2d = scytheFive.zan2d;
                itemDef.yOffset2d = scytheFive.yOffset2d;
                itemDef.xOffset2d = scytheFive.xOffset2d;

                itemDef.maleModel0 = scytheFive.maleModel0;
                itemDef.femaleModel0 = scytheFive.femaleModel0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{16, 20, 24, 28, 33, 37, 41, 49, 61, 78, 536, 784, 790, 796};
                itemDef.colorFind = new int[]{675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660, 645, 675, 660};
                break;

            case 29074:
                ItemDefinition copyItemDefViturKit = lookup(26421);
                itemDef.setDefaults();
                itemDef.id = 29074;
                itemDef.name = "Scythe of Vitur Upgrade Kit";
                itemDef.modelId = copyItemDefViturKit.modelId;
                itemDef.xan2d = copyItemDefViturKit.xan2d;
                itemDef.zoom2d = copyItemDefViturKit.zoom2d;
                itemDef.yan2d = copyItemDefViturKit.yan2d;
                itemDef.yOffset2d = copyItemDefViturKit.yOffset2d;
                itemDef.xOffset2d = copyItemDefViturKit.xOffset2d;
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;

            case 29075:
                ItemDefinition zammySpearOne = lookup(11824);
                itemDef.modelId = zammySpearOne.modelId;
                itemDef.name = "Zamorakian Spear @gre@(e)";

                itemDef.zoom2d = zammySpearOne.zoom2d;
                itemDef.xan2d = zammySpearOne.xan2d;
                itemDef.yan2d = zammySpearOne.yan2d;
                itemDef.zan2d = zammySpearOne.zan2d;
                itemDef.yOffset2d = zammySpearOne.yOffset2d;
                itemDef.xOffset2d = zammySpearOne.xOffset2d;

                itemDef.maleModel0 = zammySpearOne.maleModel0;
                itemDef.femaleModel0 = zammySpearOne.femaleModel0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{3379, 78, 86, 3491};
                itemDef.colorFind = new int[]{78, 0, 0, 86};
                break;

            case 22941:
                itemDef.name = "Blessing of Luck";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Equip";
                itemDef.interfaceOptions[2] = null;
                break;

            case 22943:
                itemDef.name = "Blessing of Defence";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Equip";
                itemDef.interfaceOptions[2] = null;
                break;

            case 22945:
                itemDef.name = "Blessing of Arcane";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Equip";
                itemDef.interfaceOptions[2] = null;
                break;

            case 22947:
                itemDef.name = "Blessing of Destruction";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Equip";
                itemDef.interfaceOptions[2] = null;
                break;

            case 22948:
                ItemDefinition blessingThree = lookup(22947);
                itemDef.modelId = blessingThree.modelId;
                itemDef.name = "Blessing of Experience";
                itemDef.zoom2d = blessingThree.zoom2d;
                itemDef.xan2d = blessingThree.xan2d;
                itemDef.yan2d = blessingThree.yan2d;
                itemDef.zan2d = blessingThree.zan2d;
                itemDef.yOffset2d = blessingThree.yOffset2d;
                itemDef.xOffset2d = blessingThree.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{43026, 43051, 43063, 43076, 5450, 48559};
                itemDef.colorFind = new int[]{17350, 17370, 17350, 17370, 0, 15};
                itemDef.stackable = false;
                break;

            case 22946:
                ItemDefinition blessingFour = lookup(22947);
                itemDef.modelId = blessingFour.modelId;
                itemDef.name = "Blessing of the Loyal";
                itemDef.zoom2d = blessingFour.zoom2d;
                itemDef.xan2d = blessingFour.xan2d;
                itemDef.yan2d = blessingFour.yan2d;
                itemDef.zan2d = blessingFour.zan2d;
                itemDef.yOffset2d = blessingFour.yOffset2d;
                itemDef.xOffset2d = blessingFour.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{43026, 43051, 43063, 43076, 5450, 48559};
                itemDef.colorFind = new int[]{34770, 34750, 34770, 34750, 0, 15};
                itemDef.stackable = false;
                break;

            case 22944:
                ItemDefinition copyItemDefScrollBoost = lookup(24187);
                itemDef.setDefaults();
                itemDef.id = 22944;
                itemDef.name = "1 hour server double drops";
                itemDef.modelId = copyItemDefScrollBoost.modelId;
                itemDef.xan2d = copyItemDefScrollBoost.xan2d;
                itemDef.zoom2d = copyItemDefScrollBoost.zoom2d;
                itemDef.yan2d = copyItemDefScrollBoost.yan2d;
                itemDef.yOffset2d = copyItemDefScrollBoost.yOffset2d;
                itemDef.xOffset2d = copyItemDefScrollBoost.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Activate", null, null, null, "Drop"};
                itemDef.colorReplace = new int[]{13051, 7070, 960};
                itemDef.colorFind = new int[]{36133, 36133, 36133};
                break;

            case 22949:
                ItemDefinition blessingOne = lookup(22947);
                itemDef.modelId = blessingOne.modelId;
                itemDef.name = "Blessing of the Seasons";
                itemDef.zoom2d = blessingOne.zoom2d;
                itemDef.xan2d = blessingOne.xan2d;
                itemDef.yan2d = blessingOne.yan2d;
                itemDef.zan2d = blessingOne.zan2d;
                itemDef.yOffset2d = blessingOne.yOffset2d;
                itemDef.xOffset2d = blessingOne.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{43026, 43051, 43063, 43076, 5450, 48559};
                itemDef.colorFind = new int[]{30025, 675, 675, 10245, 19324, 30025};
                itemDef.stackable = false;
                break;

            case 9107:
                ItemDefinition virtusSet1 = lookup(12875);
                itemDef.modelId = virtusSet1.modelId;
                itemDef.name = "Virtus Set (T1)";
                itemDef.zoom2d = virtusSet1.zoom2d;
                itemDef.xan2d = virtusSet1.xan2d;
                itemDef.yan2d = virtusSet1.yan2d;
                itemDef.zan2d = virtusSet1.zan2d;
                itemDef.yOffset2d = virtusSet1.yOffset2d;
                itemDef.xOffset2d = virtusSet1.xOffset2d;
                itemDef.interfaceOptions = new String[6];
                itemDef.interfaceOptions[0] = "Open";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{6682, 127, 6439, 6443, 6558, 6563, 53184};
                itemDef.colorFind = new int[]{0, 10, 107, 115, 107, 115, 107};
                itemDef.stackable = false;
                break;

            case 9108:
                ItemDefinition virtusSet2 = lookup(12875);
                itemDef.modelId = virtusSet2.modelId;
                itemDef.name = "Virtus Set (T2)";
                itemDef.zoom2d = virtusSet2.zoom2d;
                itemDef.xan2d = virtusSet2.xan2d;
                itemDef.yan2d = virtusSet2.yan2d;
                itemDef.zan2d = virtusSet2.zan2d;
                itemDef.yOffset2d = virtusSet2.yOffset2d;
                itemDef.xOffset2d = virtusSet2.xOffset2d;
                itemDef.interfaceOptions = new String[6];
                itemDef.interfaceOptions[0] = "Open";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{6682, 127, 6439, 6443, 6558, 6563, 53184};
                itemDef.colorFind = new int[]{0, 10, 6073, 6093, 6073, 6093, 6073};
                itemDef.stackable = false;
                break;

            case 9109:
                ItemDefinition virtusSet3 = lookup(12875);
                itemDef.modelId = virtusSet3.modelId;
                itemDef.name = "Virtus Set (T3)";
                itemDef.zoom2d = virtusSet3.zoom2d;
                itemDef.xan2d = virtusSet3.xan2d;
                itemDef.yan2d = virtusSet3.yan2d;
                itemDef.zan2d = virtusSet3.zan2d;
                itemDef.yOffset2d = virtusSet3.yOffset2d;
                itemDef.xOffset2d = virtusSet3.xOffset2d;
                itemDef.interfaceOptions = new String[6];
                itemDef.interfaceOptions[0] = "Open";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{6682, 127, 6439, 6443, 6558, 6563, 53184};
                itemDef.colorFind = new int[]{0, 10, 36133, 36153, 36133, 36153, 36133};
                itemDef.stackable = false;
                break;

            case 9110:
                ItemDefinition virtusSet4 = lookup(12875);
                itemDef.modelId = virtusSet4.modelId;
                itemDef.name = "Virtus Set (T4)";
                itemDef.zoom2d = virtusSet4.zoom2d;
                itemDef.xan2d = virtusSet4.xan2d;
                itemDef.yan2d = virtusSet4.yan2d;
                itemDef.zan2d = virtusSet4.zan2d;
                itemDef.yOffset2d = virtusSet4.yOffset2d;
                itemDef.xOffset2d = virtusSet4.xOffset2d;
                itemDef.interfaceOptions = new String[6];
                itemDef.interfaceOptions[0] = "Open";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{6682, 127, 6439, 6443, 6558, 6563, 53184};
                itemDef.colorFind = new int[]{0, 10, 675, 695, 675, 695, 675};
                itemDef.stackable = false;
                break;

            case 9111:
                ItemDefinition virtusSet5 = lookup(12875);
                itemDef.modelId = virtusSet5.modelId;
                itemDef.name = "Virtus Set (T5)";
                itemDef.zoom2d = virtusSet5.zoom2d;
                itemDef.xan2d = virtusSet5.xan2d;
                itemDef.yan2d = virtusSet5.yan2d;
                itemDef.zan2d = virtusSet5.zan2d;
                itemDef.yOffset2d = virtusSet5.yOffset2d;
                itemDef.xOffset2d = virtusSet5.xOffset2d;
                itemDef.interfaceOptions = new String[6];
                itemDef.interfaceOptions[0] = "Open";
                itemDef.interfaceOptions[1] = null;
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{6682, 127, 6439, 6443, 6558, 6563, 53184};
                itemDef.colorFind = new int[]{0, 10, 49863, 49883, 49863, 49883, 49863};
                itemDef.stackable = false;
                break;

            case 25837:
                itemDef.name = "Free Boss Challenge Stone";
                itemDef.interfaceOptions = new String[]{null, null, null, null, "Drop"};
                break;

           // case 20633:
             //   itemDef.name = "boop";
               // break;

            case 22950:
                ItemDefinition blessingTwo = lookup(22947);
                itemDef.modelId = blessingTwo.modelId;
                itemDef.name = "Blessing of Divinity";
                itemDef.zoom2d = blessingTwo.zoom2d;
                itemDef.xan2d = blessingTwo.xan2d;
                itemDef.yan2d = blessingTwo.yan2d;
                itemDef.zan2d = blessingTwo.zan2d;
                itemDef.yOffset2d = blessingTwo.yOffset2d;
                itemDef.xOffset2d = blessingTwo.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{43026, 43051, 43063, 43076, 5450, 48559};
                itemDef.colorFind = new int[]{9583, 9563, 9583, 9563, 0, 15};
                itemDef.stackable = false;
                break;

            case 3723:
                ItemDefinition arcaneTwo = lookup(12825);
                itemDef.setDefaults();
                itemDef.id = 3723;
                itemDef.name = "Arcane spirit shield @gre@T2";
                itemDef.modelId = arcaneTwo.modelId;
                itemDef.maleModel0 = arcaneTwo.maleModel0;
                itemDef.maleModel1 = arcaneTwo.maleModel1; //male model 2
                itemDef.femaleModel0 = arcaneTwo.femaleModel0;
                itemDef.femaleModel1 = arcaneTwo.femaleModel1; //female model 2
                itemDef.xan2d = arcaneTwo.xan2d;
                itemDef.zoom2d = arcaneTwo.zoom2d;
                itemDef.yan2d = arcaneTwo.yan2d;
                itemDef.yOffset2d = arcaneTwo.yOffset2d;
                itemDef.xOffset2d = arcaneTwo.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{127, 7056, 7089, 7101, 7079, 7104, 5594, 43930};
                itemDef.colorFind = new int[]{6073, 0, 6073, 0, 6073, 6073, 6073, 6073};
                break;

            case 3724:
                ItemDefinition arcaneThree = lookup(12825);
                itemDef.setDefaults();
                itemDef.id = 3724;
                itemDef.name = "Arcane spirit shield @gre@T3";
                itemDef.modelId = arcaneThree.modelId;
                itemDef.maleModel0 = arcaneThree.maleModel0;
                itemDef.maleModel1 = arcaneThree.maleModel1; //male model 2
                itemDef.femaleModel0 = arcaneThree.femaleModel0;
                itemDef.femaleModel1 = arcaneThree.femaleModel1; //female model 2
                itemDef.xan2d = arcaneThree.xan2d;
                itemDef.zoom2d = arcaneThree.zoom2d;
                itemDef.yan2d = arcaneThree.yan2d;
                itemDef.yOffset2d = arcaneThree.yOffset2d;
                itemDef.xOffset2d = arcaneThree.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{127, 7056, 7089, 7101, 7079, 7104, 5594, 43930};
                itemDef.colorFind = new int[]{36133, 0, 36133, 0, 36133, 36133, 36133, 36133};
                break;

            case 3725:
                ItemDefinition arcaneFour = lookup(12825);
                itemDef.setDefaults();
                itemDef.id = 3725;
                itemDef.name = "Arcane spirit shield @gre@T4";
                itemDef.modelId = arcaneFour.modelId;
                itemDef.maleModel0 = arcaneFour.maleModel0;
                itemDef.maleModel1 = arcaneFour.maleModel1; //male model 2
                itemDef.femaleModel0 = arcaneFour.femaleModel0;
                itemDef.femaleModel1 = arcaneFour.femaleModel1; //female model 2
                itemDef.xan2d = arcaneFour.xan2d;
                itemDef.zoom2d = arcaneFour.zoom2d;
                itemDef.yan2d = arcaneFour.yan2d;
                itemDef.yOffset2d = arcaneFour.yOffset2d;
                itemDef.xOffset2d = arcaneFour.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{127, 7056, 7089, 7101, 7079, 7104, 5594, 43930};
                itemDef.colorFind = new int[]{675, 0, 675, 0, 675, 675, 675, 675};
                break;

            case 3726:
                ItemDefinition arcaneFive = lookup(12825);
                itemDef.setDefaults();
                itemDef.id = 3726;
                itemDef.name = "Arcane spirit shield @gre@T5";
                itemDef.modelId = arcaneFive.modelId;
                itemDef.maleModel0 = arcaneFive.maleModel0;
                itemDef.maleModel1 = arcaneFive.maleModel1; //male model 2
                itemDef.femaleModel0 = arcaneFive.femaleModel0;
                itemDef.femaleModel1 = arcaneFive.femaleModel1; //female model 2
                itemDef.xan2d = arcaneFive.xan2d;
                itemDef.zoom2d = arcaneFive.zoom2d;
                itemDef.yan2d = arcaneFive.yan2d;
                itemDef.yOffset2d = arcaneFive.yOffset2d;
                itemDef.xOffset2d = arcaneFive.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{127, 7056, 7089, 7101, 7079, 7104, 5594, 43930};
                itemDef.colorFind = new int[]{49863, 0, 49863, 0, 49863, 49863, 49863, 49863};
                break;

            case 10560:
                ItemDefinition pvpMBOX = lookup(6199);
                itemDef.setDefaults();
                itemDef.id = 10560;
                itemDef.name = "PVP Mystery Box";
                itemDef.modelId = pvpMBOX.modelId;
                itemDef.xan2d = pvpMBOX.xan2d;
                itemDef.zoom2d = pvpMBOX.zoom2d;
                itemDef.yan2d = pvpMBOX.yan2d;
                itemDef.yOffset2d = pvpMBOX.yOffset2d;
                itemDef.xOffset2d = pvpMBOX.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                itemDef.colorReplace = new int[]{22410, 2999};
                itemDef.colorFind = new int[]{0, 35};
                itemDef.glowColor = 35;
                break;

            case 10561:
                ItemDefinition raresMBOX = lookup(6199);
                itemDef.setDefaults();
                itemDef.id = 10561;
                itemDef.name = "Rares Mystery Box";
                itemDef.modelId = raresMBOX.modelId;
                itemDef.xan2d = raresMBOX.xan2d;
                itemDef.zoom2d = raresMBOX.zoom2d;
                itemDef.yan2d = raresMBOX.yan2d;
                itemDef.yOffset2d = raresMBOX.yOffset2d;
                itemDef.xOffset2d = raresMBOX.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                itemDef.colorReplace = new int[]{22410, 2999};
                itemDef.colorFind = new int[]{49863, 0};
                itemDef.glowColor = 35;
                break;

            case 10562:
                ItemDefinition icon1 = lookup(10556);
                itemDef.setDefaults();
                itemDef.id = 10562;
                itemDef.name = "Corrupted Icon";
                itemDef.modelId = icon1.modelId;
                itemDef.maleModel0 = icon1.maleModel0;
                itemDef.femaleModel0 = icon1.femaleModel0;
                itemDef.xan2d = icon1.xan2d;
                itemDef.zoom2d = icon1.zoom2d;
                itemDef.yan2d = icon1.yan2d;
                itemDef.yOffset2d = icon1.yOffset2d;
                itemDef.xOffset2d = icon1.xOffset2d;
                itemDef.wearPos1 = icon1.wearPos1;
                itemDef.wearPos2 = icon1.wearPos2;
                itemDef.wearPos3 = icon1.wearPos3;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.colorReplace = new int[]{22439, 11200, 947, 43955, 22451};
                itemDef.colorFind = new int[]{0, 35, 0, 35, 0};
                break;

            case 10563:
                ItemDefinition immortalMBOX = lookup(6199);
                itemDef.setDefaults();
                itemDef.id = 10563;
                itemDef.name = "Godwars Mystery Box";
                itemDef.modelId = immortalMBOX.modelId;
                itemDef.xan2d = immortalMBOX.xan2d;
                itemDef.zoom2d = immortalMBOX.zoom2d;
                itemDef.yan2d = immortalMBOX.yan2d;
                itemDef.yOffset2d = immortalMBOX.yOffset2d;
                itemDef.xOffset2d = immortalMBOX.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                itemDef.colorReplace = new int[]{22410, 2999};
                itemDef.colorFind = new int[]{675, 0};
                itemDef.glowColor = 35;
                break;

            case 7500:
                ItemDefinition bcalMBOX = lookup(6199);
                itemDef.setDefaults();
                itemDef.id = 7500;
                itemDef.name = "Boss Challenge Mystery Box";
                itemDef.modelId = bcalMBOX.modelId;
                itemDef.xan2d = bcalMBOX.xan2d;
                itemDef.zoom2d = bcalMBOX.zoom2d;
                itemDef.yan2d = bcalMBOX.yan2d;
                itemDef.yOffset2d = bcalMBOX.yOffset2d;
                itemDef.xOffset2d = bcalMBOX.xOffset2d;
                itemDef.interfaceOptions = new String[]{"Open", null, null, "Quick-Open", "Drop"};
                itemDef.colorReplace = new int[]{22410, 2999};
                itemDef.colorFind = new int[]{36133, 0};
                itemDef.glowColor = 35;
                break;

            case 455:
                itemDef.name = "Custom Recolor Certificate";
                itemDef.glowColor = 2500;
                break;

            case 25975:
                itemDef.setDefaults();
                itemDef.name = "Lightbearer";
                itemDef.modelId = 46473;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 830;
                itemDef.xan2d = 322;
                itemDef.zan2d = 135;
                itemDef.yan2d = 2024;
                itemDef.xOffset2d = 2;
                itemDef.yOffset2d = -3;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 26241:
                itemDef.setDefaults();
                itemDef.name = "Virtus mask";
                itemDef.modelId = 47656;
                itemDef.maleModel0 = 47642;
                itemDef.femaleModel0 = 47647;
                itemDef.maleHeadModel = 47651;
                itemDef.femaleHeadModel = 47652;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 987;
                itemDef.xan2d = 2047;
                itemDef.zan2d = 2020;
                itemDef.yan2d = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 26243:
                itemDef.setDefaults();
                itemDef.name = "Virtus robe top";
                itemDef.modelId = 47655;
                itemDef.maleModel0 = 47645;
                itemDef.femaleModel0 = 47649;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 1414;
                itemDef.xOffset2d = 0;
                itemDef.yOffset2d = -6;
                itemDef.xan2d = 518;
                itemDef.zan2d = 0;
                itemDef.yan2d = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 26245:
                itemDef.setDefaults();
                itemDef.name = "Virtus robe bottom";
                itemDef.modelId = 47653;
                itemDef.maleModel0 = 47643;
                itemDef.femaleModel0 = 47648;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 1842;
                itemDef.xOffset2d = 2;
                itemDef.yOffset2d = -11;
                itemDef.xan2d = 435;
                itemDef.zan2d = 0;
                itemDef.yan2d = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 26219:
                itemDef.setDefaults();
                itemDef.name = "Osmumten's fang";
                itemDef.modelId = 46468;
                itemDef.maleModel0 = 45278;
                itemDef.femaleModel0 = 45285;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 2150;
                itemDef.xOffset2d = 5;
                itemDef.yOffset2d = -18;
                itemDef.xan2d = 0;
                itemDef.zan2d = 1603;
                itemDef.yan2d = 552;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                break;

            case 27226:
                itemDef.setDefaults();
                itemDef.name = "Masori mask";
                itemDef.modelId = 46485;
                itemDef.maleModel0 = 45248;
                itemDef.femaleModel0 = 45262;
                itemDef.maleHeadModel = 46454;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 1033;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 27229:
                itemDef.setDefaults();
                itemDef.name = "Masori body";
                itemDef.modelId = 46476;
                itemDef.maleModel0 = 45257;
                itemDef.femaleModel0 = 45270;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 1240;
                itemDef.xOffset2d = 0;
                itemDef.yOffset2d = 11;
                itemDef.xan2d = 453;
                itemDef.zan2d = 0;
                itemDef.yan2d = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 27232:
                itemDef.setDefaults();
                itemDef.name = "Masori chaps";
                itemDef.modelId = 46482;
                itemDef.maleModel0 = 45256;
                itemDef.femaleModel0 = 45269;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 2000;
                itemDef.xOffset2d = 0;
                itemDef.yOffset2d = 4;
                itemDef.xan2d = 555;
                itemDef.zan2d = 2036;
                itemDef.yan2d = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 27275:
                itemDef.setDefaults();
                itemDef.name = "Tumeken's shadow";
                itemDef.modelId = 46465;
                itemDef.maleModel0 = 45281;
                itemDef.femaleModel0 = 45282;
                itemDef.resizeX = 128;
                itemDef.resizeY = 128;
                itemDef.resizeZ = 128;
                itemDef.zoom2d = 1600;
                itemDef.xOffset2d = 10;
                itemDef.yOffset2d = -2;
                itemDef.xan2d = 465;
                itemDef.zan2d = 1481;
                itemDef.yan2d = 1200;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                break;

            case 10570:
                itemDef.setDefaults();
                itemDef.name = "Death cape";
                itemDef.modelId = 50205;
                itemDef.maleModel0 = 50205;
                itemDef.femaleModel0 = 50205;
                itemDef.zoom2d = 2300;
                itemDef.xan2d = 400;
                itemDef.yan2d = 1020;
                itemDef.xOffset2d = 3;
                itemDef.yOffset2d = 30;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.maleOffset = 5;
                itemDef.maleOffset = 5;
                break;

            case 619:
                itemDef.name = "Fall 2023 Ticket";
                itemDef.colorReplace = new int[]{16714, 7403, 3532};
                itemDef.colorFind = new int[]{6073, 0, 6073};
                itemDef.stackable = true;
                break;

            case 7806:
                itemDef.name = "Seasonal sword";
                break;

            case 7807:
                itemDef.name = "Seasonal battleaxe";
                break;

            case 7808:
                itemDef.name = "Seasonal mace";
                break;

            case 7809:
                itemDef.name = "Seasonal spear";
                break;

            case 7810:
                ItemDefinition seasonalMaceUpgraded = lookup(7808);
                itemDef.modelId = seasonalMaceUpgraded.modelId;
                itemDef.name = "Enhanced Seasonal mace (fall)";

                itemDef.zoom2d = seasonalMaceUpgraded.zoom2d;
                itemDef.xan2d = seasonalMaceUpgraded.xan2d;
                itemDef.yan2d = seasonalMaceUpgraded.yan2d;
                itemDef.zan2d = seasonalMaceUpgraded.zan2d;
                itemDef.yOffset2d = seasonalMaceUpgraded.yOffset2d;
                itemDef.xOffset2d = seasonalMaceUpgraded.xOffset2d;

                itemDef.maleModel0 = seasonalMaceUpgraded.maleModel0;
                itemDef.femaleModel0 = seasonalMaceUpgraded.femaleModel0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wield";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 78, 103, 920};
                itemDef.colorFind = new int[]{0, 6173, 6073, 920};
                break;

            case 7811:
                ItemDefinition copyItemDefHween7 = lookup(1053);
                itemDef.setDefaults();
                itemDef.name = "Orange H'ween mask";
                itemDef.modelId = copyItemDefHween7.modelId;
                itemDef.maleModel0 = copyItemDefHween7.maleModel0;
                itemDef.femaleModel0 = copyItemDefHween7.femaleModel0;
                itemDef.zoom2d = copyItemDefHween7.zoom2d;
                itemDef.xan2d = copyItemDefHween7.xan2d;
                itemDef.yan2d = copyItemDefHween7.yan2d;
                itemDef.yOffset2d = copyItemDefHween7.yOffset2d;
                itemDef.xOffset2d = copyItemDefHween7.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{926};
                itemDef.colorFind = new int[]{6073};
                break;

            case 13400:
                ItemDefinition dfullhelm = lookup(12417);
                itemDef.setDefaults();
                itemDef.name = "Dragon full helm (up)";
                itemDef.modelId = dfullhelm.modelId;
                itemDef.maleModel0 = dfullhelm.maleModel0;
                itemDef.femaleModel0 = dfullhelm.femaleModel0;
                itemDef.zoom2d = dfullhelm.zoom2d;
                itemDef.xan2d = dfullhelm.xan2d;
                itemDef.yan2d = dfullhelm.yan2d;
                itemDef.yOffset2d = dfullhelm.yOffset2d;
                itemDef.xOffset2d = dfullhelm.xOffset2d;
                itemDef.cost = 1;
                itemDef.team = 0;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                itemDef.interfaceOptions[3] = null;
                itemDef.interfaceOptions[4] = "Drop";
                itemDef.colorReplace = new int[]{0, 10306, 70, 10314, 2700, 902, 3974, 1934, 914, 1940, 916, 918, 920, 1944, 922, 924, 4550};
                itemDef.colorFind = new int[]{0, 10306, 70, 10314, 2700, 902, 107, 1934, 914, 1940, 916, 918, 920, 1944, 922, 924, 4550};
                break;

        }
    }

    public static ItemDefinition lookup(int itemId) {
        for (int count = 0; count < 10; count++)
            if (cache[count].id == itemId)
                return cache[count];

        if (itemId > streamIndices.length)
            itemId = 0;
        if (newCustomItems(itemId) != null) {
            return newCustomItems(itemId);
        }
        if (itemId == -1)
            itemId = 0;
        cacheIndex = (cacheIndex + 1) % 10;
        ItemDefinition itemDef = cache[cacheIndex];
        if (itemId > 0)
            item_data.currentPosition = streamIndices[itemId];
        itemDef.id = itemId;
        itemDef.setDefaults();
        itemDef.decode(item_data);

        if (itemDef.noted_item_id != -1) {
            itemDef.toNote();
        }

        customItems(itemId);


        return itemDef;
    }

    private static ItemDefinition newCustomItems(int itemId) {
        ItemDefinition itemDef = new ItemDefinition();
        itemDef.setDefaults();
        switch (itemId) {
            case 30000:
                return copy(itemDef, 30_000, 11738, "Resource box(small)", "Open");
            case 30001:
                return copy(itemDef, 30_001, 11738, "Resource box(medium)", "Open");
            case 30002:
                return copy(itemDef, 30_002, 11738, "Resource box(large)", "Open");
            case 22375:
                return copy(itemDef, 22375, 22374, "Mossy key");

            case 33056:
				/*itemDef.setDefaults();
				itemDef.id = 33056;
				itemDef.modelId = 65270;
				itemDef.name = "Completionist cape";

				itemDef.zoom2d = 1385;
				itemDef.xan2d = 279;
				itemDef.yan2d = 948;
				itemDef.zan2d = 0;
				itemDef.xOffset2d = 0;
				itemDef.yOffset2d = 24;

				itemDef.maleModel0 = 65297;
				itemDef.femaleModel0 = 65316;*/
                ItemDefinition champ = lookup(21439);
                itemDef.setDefaults();
                itemDef.id = 33056;
                itemDef.name = "Completionist Cape";
                itemDef.modelId = champ.modelId;
                itemDef.maleModel0 = champ.maleModel0;
                itemDef.femaleModel0 = champ.femaleModel0;
                itemDef.xan2d = champ.xan2d;
                itemDef.zoom2d = champ.zoom2d;
                itemDef.yan2d = champ.yan2d;
                itemDef.yOffset2d = champ.yOffset2d;
                itemDef.xOffset2d = champ.xOffset2d;
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = null;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                itemDef.interfaceOptions[2] = "Teleports";
                itemDef.interfaceOptions[3] = "Features";
                itemDef.interfaceOptions[4] = "Drop";
                return itemDef;
            case 33057:
                itemDef.setDefaults();
                itemDef.id = 33057;
                itemDef.modelId = 65273;
                itemDef.name = "Completionist hood";

                itemDef.zoom2d = 760;
                itemDef.xan2d = 11;
                itemDef.yan2d = 0;
                itemDef.zan2d = 0;
                itemDef.xOffset2d = 0;
                itemDef.yOffset2d = 0;

                itemDef.maleModel0 = 65292;
                itemDef.femaleModel0 = 65310;
                //itemDef.groundActions = new String[5];
                //itemDef.groundActions[2] = "Take";
                itemDef.interfaceOptions = new String[5];
                itemDef.interfaceOptions[1] = "Wear";
                return itemDef;
        }

        return null;
    }


    void method2790(ItemDefinition var1, ItemDefinition var2) {
        modelId = var1.modelId * 1;
        zoom2d = 1 * var1.zoom2d;
        xan2d = var1.xan2d * 1;
        yan2d = var1.yan2d * 1;
        zan2d = var1.zan2d * 1;
        xOffset2d = 1 * var1.xOffset2d;
        yOffset2d = var1.yOffset2d * 1;
        colorReplace = var1.colorReplace;
        colorFind = var1.colorFind;
        textureFind = var1.textureFind;
        textureReplace = var1.textureReplace;
        stackable = var1.stackable;
        name = var2.name;
        cost = 0;
    }

    void method2789(ItemDefinition var1, ItemDefinition var2) {
        modelId = var1.modelId * 1;
        zoom2d = var1.zoom2d * 1;
        xan2d = 1 * var1.xan2d;
        yan2d = 1 * var1.yan2d;
        zan2d = 1 * var1.zan2d;
        xOffset2d = 1 * var1.xOffset2d;
        yOffset2d = var1.yOffset2d * 1;
        colorReplace = var2.colorReplace;
        colorFind = var2.colorFind;
        // originalTextureColors = var2.originalTextureColors;
        // modifiedTextureColors = var2.modifiedTextureColors;
        name = var2.name;
        members = var2.members;
        stackable = var2.stackable;
        maleModel0 = 1 * var2.maleModel0;
        maleModel1 = 1 * var2.maleModel1;
        maleModel2 = 1 * var2.maleModel2;
        femaleModel0 = var2.femaleModel0 * 1;
        femaleModel1 = var2.femaleModel1 * 1;
        femaleModel2 = 1 * var2.femaleModel2;
        maleHeadModel = 1 * var2.maleHeadModel;
        maleHeadModel2 = var2.maleHeadModel2 * 1;
        femaleHeadModel = var2.femaleHeadModel * 1;
        femaleHeadModel2 = var2.femaleHeadModel2 * 1;
        team = var2.team * 1;
        options = var2.options;
        interfaceOptions = new String[5];
        equipActions = new String[5];
        if (null != var2.interfaceOptions) {
            for (int var4 = 0; var4 < 4; ++var4) {
                interfaceOptions[var4] = var2.interfaceOptions[var4];
            }
        }

        interfaceOptions[4] = "Discard";
        cost = 0;
    }

    void toPlaceholder(ItemDefinition var1, ItemDefinition var2) {
        modelId = var1.modelId * 1;
        zoom2d = 1 * var1.zoom2d;
        xan2d = var1.xan2d * 1;
        yan2d = var1.yan2d * 1;
        zan2d = var1.zan2d * 1;
        xOffset2d = 1 * var1.xOffset2d;
        yOffset2d = var1.yOffset2d * 1;
        colorReplace = var1.colorReplace;
        colorFind = var1.colorFind;
        textureFind = var1.textureFind;
        textureReplace = var1.textureReplace;
        stackable = var1.stackable;
        name = var2.name;
        cost = 0;
    }

    public static Sprite getSprite(int itemId, int stackSize, int outlineColor, boolean noted, int border, int shadow) {
        if (outlineColor == 0) {
            Sprite sprite = (Sprite) sprites.get(itemId);

            if (sprite != null && sprite.maxHeight != stackSize && sprite.maxHeight != -1) {
                sprite.unlink();
                sprite = null;
            }

            if (sprite != null) {
                return sprite;
            }
        }

        ItemDefinition definition = lookup(itemId);

        if (definition.countObj == null) {
            stackSize = -1;
        }

        if (stackSize > 1) {
            int stack_item_id = -1;

            for (int j1 = 0; j1 < 10; j1++) {
                if (stackSize >= definition.countCo[j1] && definition.countCo[j1] != 0) {
                    stack_item_id = definition.countObj[j1];
                }
            }

            if (stack_item_id != -1) {
                definition = lookup(stack_item_id);
            }
        }

        Model model = definition.getModel(1);

        if (model == null) {
            return null;
        }

        Sprite sprite = null;


        Sprite enabledSprite = new Sprite(32, 32);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 32, 32, 0);
        Rasterizer3D.useViewport();
        int k3 = definition.zoom2d;

        if (outlineColor == -1) {
            k3 = (int) (k3 * 1.5D);
        }

        if (outlineColor > 0) {
            k3 = (int) (k3 * 1.04D);
        }

        int l3 = Rasterizer3D.SINE[definition.xan2d] * k3 >> 16;
        int i4 = Rasterizer3D.COSINE[definition.xan2d] * k3 >> 16;
        Rasterizer3D.renderOnGpu = true;
        model.renderModel(definition.yan2d, definition.zan2d, definition.xan2d, definition.xOffset2d,
                l3 + model.modelBaseY / 2 + definition.yOffset2d, i4 + definition.yOffset2d);
        Rasterizer3D.renderOnGpu = false;

        enabledSprite.highlight(1);

        if (outlineColor == 0) {
            enabledSprite.shadow(3153952);
        }

        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);

        if (noted) {
            int old_w = sprite.maxWidth;
            int old_h = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = old_w;
            sprite.maxHeight = old_h;
        }

        if (outlineColor == 0) {
            sprites.put(enabledSprite, itemId);
        }

        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        enabledSprite.maxWidth = definition.stackable ? 33 : 32;
        enabledSprite.maxHeight = stackSize;
        return enabledSprite;
    }

    public static Sprite getSmallSprite(int itemId) {
        return getSmallSprite(itemId, 1);
    }

    public static Sprite getSmallSprite(int itemId, int stackSize) {

        ItemDefinition itemDef = lookup(itemId);
        if (itemDef.countObj == null)
            stackSize = -1;
        if (stackSize > 1) {
            int stack_item_id = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (stackSize >= itemDef.countCo[j1] && itemDef.countCo[j1] != 0)
                    stack_item_id = itemDef.countObj[j1];

            if (stack_item_id != -1)
                itemDef = lookup(stack_item_id);
        }
        Model model = itemDef.getModel(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.noted_item_id != -1) {
            sprite = getSprite(itemDef.unnoted_item_id, 10, -1);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(18, 18);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(18, 18, enabledSprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 18, 18, 0);
        Rasterizer3D.useViewport();
        int k3 = itemDef.zoom2d;

        int l3 = Rasterizer3D.SINE[itemDef.xan2d] * k3 >> 16;
        int i4 = Rasterizer3D.COSINE[itemDef.xan2d] * k3 >> 16;
        Rasterizer3D.renderOnGpu = true;
        model.renderModel(itemDef.yan2d, itemDef.zan2d, itemDef.xan2d, itemDef.xOffset2d,
                l3 + model.modelBaseY / 2 + itemDef.yOffset2d, i4 + itemDef.yOffset2d);
        Rasterizer3D.renderOnGpu = false;
        enabledSprite.outline(1);

        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);

        if (itemDef.noted_item_id != -1) {
            int old_w = sprite.maxWidth;
            int old_h = sprite.maxHeight;
            sprite.maxWidth = 18;
            sprite.maxHeight = 18;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = old_w;
            sprite.maxHeight = old_h;
        }

        sprites.put(enabledSprite, itemId);
        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        if (itemDef.stackable)
            enabledSprite.maxWidth = 18;
        else
            enabledSprite.maxWidth = 18;
        enabledSprite.maxHeight = stackSize;
        return enabledSprite;
    }


    public static Sprite getSprite(int itemId, int stackSize, int outlineColor) {
        if (outlineColor == 0) {
            Sprite sprite = (Sprite) sprites.get(itemId);
            if (sprite != null && sprite.maxHeight != stackSize && sprite.maxHeight != -1) {

                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition itemDef = lookup(itemId);
        if (itemDef.countObj == null)
            stackSize = -1;
        if (stackSize > 1) {
            int stack_item_id = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (stackSize >= itemDef.countCo[j1] && itemDef.countCo[j1] != 0)
                    stack_item_id = itemDef.countObj[j1];

            if (stack_item_id != -1)
                itemDef = lookup(stack_item_id);
        }
        Model model = itemDef.getModel(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.noted_item_id != -1) {
            sprite = getSprite(itemDef.unnoted_item_id, 10, -1);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(32, 32);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 32, 32, 0);
        Rasterizer3D.useViewport();
        int k3 = itemDef.zoom2d;
        if (outlineColor == -1)
            k3 = (int) ((double) k3 * 1.5D);
        if (outlineColor > 0)
            k3 = (int) ((double) k3 * 1.04D);
        int l3 = Rasterizer3D.SINE[itemDef.xan2d] * k3 >> 16;
        int i4 = Rasterizer3D.COSINE[itemDef.xan2d] * k3 >> 16;
        Rasterizer3D.renderOnGpu = true;
        model.renderModel(itemDef.yan2d, itemDef.zan2d, itemDef.xan2d, itemDef.xOffset2d,
                l3 + model.modelBaseY / 2 + itemDef.yOffset2d, i4 + itemDef.yOffset2d);
        Rasterizer3D.renderOnGpu = false;
        enabledSprite.outline(1);
        if (outlineColor > 0) {
            enabledSprite.outline(16777215);
        }
        if (outlineColor == 0) {
            enabledSprite.shadow(3153952);
        }

        Rasterizer2D.initDrawingArea(32, 32, enabledSprite.myPixels);

        if (itemDef.noted_item_id != -1) {
            int old_w = sprite.maxWidth;
            int old_h = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = old_w;
            sprite.maxHeight = old_h;
        }
        if (outlineColor == 0)
            sprites.put(enabledSprite, itemId);
        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        if (itemDef.stackable)
            enabledSprite.maxWidth = 33;
        else
            enabledSprite.maxWidth = 32;
        enabledSprite.maxHeight = stackSize;
        return enabledSprite;
    }

    public static Sprite getSprite(int itemId, int stackSize, int zoom, int outlineColor) {
        ItemDefinition itemDef = lookup(itemId);
        if (itemDef.countObj == null)
            stackSize = -1;
        if (stackSize > 1) {
            int stack_item_id = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (stackSize >= itemDef.countCo[j1] && itemDef.countCo[j1] != 0)
                    stack_item_id = itemDef.countObj[j1];

            if (stack_item_id != -1)
                itemDef = lookup(stack_item_id);
        }
        Model model = itemDef.getModel(1);
        if (model == null)
            return null;
        Sprite sprite = new Sprite(90, 90);
        int centerX = Rasterizer3D.originViewX;
        int centerY = Rasterizer3D.originViewY;
        int[] lineOffsets = Rasterizer3D.scanOffsets;
        int[] pixels = Rasterizer2D.pixels;
        int width = Rasterizer2D.width;
        int height = Rasterizer2D.height;
        int vp_left = Rasterizer2D.leftX;
        int vp_right = Rasterizer2D.bottomX;
        int vp_top = Rasterizer2D.topY;
        int vp_bottom = Rasterizer2D.bottomY;
        Rasterizer3D.world = false;
        Rasterizer3D.aBoolean1464 = false;
        Rasterizer2D.initDrawingArea(90, 90, sprite.myPixels);
        Rasterizer2D.drawItemBox(0, 0, 90, 90, 0);
        Rasterizer3D.useViewport();
        int l3 = Rasterizer3D.SINE[itemDef.xan2d] * zoom >> 15;
        int i4 = Rasterizer3D.COSINE[itemDef.xan2d] * zoom >> 15;
        Rasterizer3D.renderOnGpu = true;

        model.renderModel(itemDef.yan2d, itemDef.zan2d, itemDef.xan2d, itemDef.xOffset2d,
                l3 + model.modelBaseY / 2 + itemDef.yOffset2d, i4 + itemDef.yOffset2d);

        Rasterizer3D.renderOnGpu = false;
        sprite.outline(1);
        if (outlineColor > 0) {
            sprite.outline(16777215);
        }
        if (outlineColor == 0) {
            sprite.shadow(3153952);
        }
        Rasterizer2D.initDrawingArea(90, 90, sprite.myPixels);
        Rasterizer2D.initDrawingArea(height, width, pixels);
        Rasterizer2D.setDrawingArea(vp_bottom, vp_left, vp_right, vp_top);
        Rasterizer3D.originViewX = centerX;
        Rasterizer3D.originViewY = centerY;
        Rasterizer3D.scanOffsets = lineOffsets;
        Rasterizer3D.aBoolean1464 = true;
        Rasterizer3D.world = true;
        if (itemDef.stackable)
            sprite.maxWidth = 33;
        else
            sprite.maxWidth = 32;
        sprite.maxHeight = stackSize;
        return sprite;
    }

    public boolean isDialogueModelCached(int gender) {
        int model_1 = maleHeadModel;
        int model_2 = maleHeadModel2;
        if (gender == 1) {
            model_1 = femaleHeadModel;
            model_2 = femaleHeadModel2;
        }
        if (model_1 == -1)
            return true;
        boolean cached = Model.isCached(model_1);
        if (model_2 != -1 && !Model.isCached(model_2))
            cached = false;
        return cached;
    }

    public Model getChatEquipModel(int gender) {
        int dialogueModel = maleHeadModel;
        int dialogueHatModel = maleHeadModel2;
        if (gender == 1) {
            dialogueModel = femaleHeadModel;
            dialogueHatModel = femaleHeadModel2;
        }
        if (dialogueModel == -1)
            return null;
        Model dialogueModel_ = Model.getModel(dialogueModel);
        if (dialogueHatModel != -1) {
            Model hatModel_ = Model.getModel(dialogueHatModel);
            Model[] models = {dialogueModel_, hatModel_};
            dialogueModel_ = new Model(2, models);
        }
        if (colorReplace != null) {
            for (int i1 = 0; i1 < colorReplace.length; i1++)
                dialogueModel_.recolor(colorReplace[i1], colorFind[i1]);

        }
        if (textureReplace != null) {
            for (int i1 = 0; i1 < textureReplace.length; i1++)
                dialogueModel_.retexture(textureReplace[i1], textureFind[i1]);
        }
        return dialogueModel_;
    }

    public boolean isEquippedModelCached(int gender) {
        int primaryModel = maleModel0;
        int secondaryModel = maleModel1;
        int emblem = maleModel2;
        if (gender == 1) {
            primaryModel = femaleModel0;
            secondaryModel = femaleModel1;
            emblem = femaleModel2;
        }
        if (primaryModel == -1)
            return true;
        boolean cached = Model.isCached(primaryModel);
        if (secondaryModel != -1 && !Model.isCached(secondaryModel))
            cached = false;
        if (emblem != -1 && !Model.isCached(emblem))
            cached = false;
        return cached;
    }

    public Model getEquippedModel(int gender) {
        int primaryModel = maleModel0;
        int secondaryModel = maleModel1;
        int emblem = maleModel2;

        if (gender == 1) {
            primaryModel = femaleModel0;
            secondaryModel = femaleModel1;
            emblem = femaleModel2;
        }

        if (primaryModel == -1)
            return null;
        Model primaryModel_ = Model.getModel(primaryModel);
        if (secondaryModel != -1)
            if (emblem != -1) {
                Model secondaryModel_ = Model.getModel(secondaryModel);
                Model emblemModel = Model.getModel(emblem);
                Model[] models = {primaryModel_, secondaryModel_, emblemModel};
                primaryModel_ = new Model(3, models);
            } else {
                Model model_2 = Model.getModel(secondaryModel);
                Model[] models = {primaryModel_, model_2};
                primaryModel_ = new Model(2, models);
            }
        if (gender == 0 && maleOffset != 0)
            primaryModel_.offsetBy(0, maleOffset, 0);
        if (gender == 1 && femaleOffset != 0)
            primaryModel_.offsetBy(0, femaleOffset, 0);

        if (colorReplace != null) {
            for (int i1 = 0; i1 < colorReplace.length; i1++)
                primaryModel_.recolor(colorReplace[i1], colorFind[i1]);

        }
        if (textureReplace != null) {
            for (int i1 = 0; i1 < textureReplace.length; i1++)
                primaryModel_.retexture(textureReplace[i1], textureFind[i1]);
        }
        return primaryModel_;
    }

    private void setDefaults() {
        customSpriteLocation = null;
        customSmallSpriteLocation = null;
        equipActions = new String[]{"Remove", null, "Operate", null, null};
        modelId = 0;
        name = null;
        colorReplace = null;
        colorFind = null;
        textureReplace = null;
        textureFind = null;

        zoom2d = 2000;
        xan2d = 0;
        yan2d = 0;
        zan2d = 0;
        xOffset2d = 0;
        yOffset2d = 0;
        stackable = false;
        cost = 1;
        members = false;
        options = null;
        interfaceOptions = null;
        maleModel0 = -1;
        maleModel1 = -1;
        maleOffset = 0;
        femaleModel0 = -1;
        femaleModel1 = -1;
        femaleOffset = 0;
        maleModel2 = -1;
        femaleModel2 = -1;
        maleHeadModel = -1;
        maleHeadModel2 = -1;
        femaleHeadModel = -1;
        femaleHeadModel2 = -1;
        countObj = null;
        countCo = null;
        unnoted_item_id = -1;
        noted_item_id = -1;
        resizeX = 128;
        resizeY = 128;
        resizeZ = 128;
        ambient = 0;
        contrast = 0;
        team = 0;
        glowColor = -1;
    }

    private void copy(ItemDefinition copy) {
        yan2d = copy.yan2d;
        xan2d = copy.xan2d;
        zan2d = copy.zan2d;
        resizeX = copy.resizeX;
        resizeY = copy.resizeY;
        resizeZ = copy.resizeZ;
        zoom2d = copy.zoom2d;
        xOffset2d = copy.xOffset2d;
        yOffset2d = copy.yOffset2d;
        modelId = copy.modelId;
        stackable = copy.stackable;

    }

    private void toNote() {
        ItemDefinition itemDef = lookup(noted_item_id);
        modelId = itemDef.modelId;
        zoom2d = itemDef.zoom2d;
        xan2d = itemDef.xan2d;
        yan2d = itemDef.yan2d;

        zan2d = itemDef.zan2d;
        xOffset2d = itemDef.xOffset2d;
        yOffset2d = itemDef.yOffset2d;

        ItemDefinition itemDef_1 = lookup(unnoted_item_id);
        name = itemDef_1.name;
        members = itemDef_1.members;
        cost = itemDef_1.cost;
        stackable = true;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getNote() {
        return 0;
    }

    @Override
    public int getLinkedNoteId() {
        return 0;
    }

    @Override
    public int getPlaceholderId() {
        return 0;
    }

    @Override
    public int getPlaceholderTemplateId() {
        return 0;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public boolean isMembers() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public void setTradeable(boolean yes) {

    }

    @Override
    public int getIsStackable() {
        return 0;
    }

    @Override
    public int getMaleModel() {
        return 0;
    }

    @Override
    public String[] getInventoryActions() {
        return new String[0];
    }

    @Override
    public String[] getGroundActions() {
        return new String[0];
    }

    @Override
    public int getShiftClickActionIndex() {
        return 0;
    }

    @Override
    public void setShiftClickActionIndex(int shiftClickActionIndex) {

    }

    public Model getModel(int stack_size) {
        if (countObj != null && stack_size > 1) {
            int stack_item_id = -1;
            for (int k = 0; k < 10; k++)
                if (stack_size >= countCo[k] && countCo[k] != 0)
                    stack_item_id = countObj[k];

            if (stack_item_id != -1)
                return lookup(stack_item_id).getModel(1);
        }
        Model model = (Model) models.get(id);
        if (model != null)
            return model;
        model = Model.getModel(modelId);
        if (model == null)
            return null;
        if (resizeX != 128 || resizeY != 128 || resizeZ != 128)
            model.scale(resizeX, resizeZ, resizeY);
        if (colorReplace != null) {
            for (int l = 0; l < colorReplace.length; l++)
                model.recolor(colorReplace[l], colorFind[l]);

        }
        if (textureReplace != null) {
            for (int i1 = 0; i1 < textureReplace.length; i1++)
                model.retexture(textureReplace[i1], textureFind[i1]);
        }
        int lightInt = 64 + ambient;
        int lightMag = 768 + contrast;
        model.light(lightInt, lightMag, -50, -10, -50, true);
        model.singleTile = true;
        models.put(model, id);
        return model;
    }

    @Override
    public int getInventoryModel() {
        return 0;
    }

    @Override
    public short[] getColorToReplaceWith() {
        return new short[0];
    }

    @Override
    public short[] getTextureToReplaceWith() {
        return new short[0];
    }

    @Override
    public RSIterableNodeHashTable getParams() {
        return null;
    }

    @Override
    public void setParams(IterableHashTable params) {

    }

    @Override
    public void setParams(RSIterableNodeHashTable params) {

    }

    public Model getUnshadedModel(int stack_size) {
        if (countObj != null && stack_size > 1) {
            int stack_item_id = -1;
            for (int count = 0; count < 10; count++)
                if (stack_size >= countCo[count] && countCo[count] != 0)
                    stack_item_id = countObj[count];

            if (stack_item_id != -1)
                return lookup(stack_item_id).getUnshadedModel(1);
        }
        Model model = Model.getModel(modelId);
        if (model == null)
            return null;
        if (colorReplace != null) {
            for (int colorPtr = 0; colorPtr < colorReplace.length; colorPtr++)
                model.recolor(colorReplace[colorPtr], colorFind[colorPtr]);

        }
        return model;
    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.readUnsignedByte();
            if (opcode == 0)
                return;
            if (opcode == 1)
                modelId = buffer.readUShort();
            else if (opcode == 2)
                name = buffer.readString();
            else if (opcode == 3)
                buffer.readString();
            else if (opcode == 4)
                zoom2d = buffer.readUShort();
            else if (opcode == 5)
                xan2d = buffer.readUShort();
            else if (opcode == 6)
                yan2d = buffer.readUShort();
            else if (opcode == 7) {
                xOffset2d = buffer.readUShort();
                if (xOffset2d > 32767)
                    xOffset2d -= 0x10000;
            } else if (opcode == 8) {
                yOffset2d = buffer.readUShort();
                if (yOffset2d > 32767)
                    yOffset2d -= 0x10000;
            } else if (opcode == 9) {
                buffer.readString();
            } else if (opcode == 11)
                stackable = true;
            else if (opcode == 12)
                cost = buffer.readInt();
            else if (opcode == 13)
                this.wearPos1 = buffer.readSignedByte();
            else if (opcode == 14)
                this.wearPos2 = buffer.readSignedByte();
            else if (opcode == 16)
                members = true;
            else if (opcode == 23) {
                maleModel0 = buffer.readUShort();
                maleOffset = buffer.readSignedByte();
            } else if (opcode == 24)
                maleModel1 = buffer.readUShort();
            else if (opcode == 25) {
                femaleModel0 = buffer.readUShort();
                femaleOffset = buffer.readSignedByte();
            } else if (opcode == 26)
                femaleModel1 = buffer.readUShort();
            else if (opcode == 27)
                this.wearPos3 = buffer.readSignedByte();
            else if (opcode >= 30 && opcode < 35) {
                if (options == null)
                    options = new String[5];
                options[opcode - 30] = buffer.readString();
                if (options[opcode - 30].equalsIgnoreCase("hidden"))
                    options[opcode - 30] = null;
            } else if (opcode >= 35 && opcode < 40) {
                if (interfaceOptions == null)
                    interfaceOptions = new String[5];
                interfaceOptions[opcode - 35] = buffer.readString();

            } else if (opcode == 40) {
                int length = buffer.readUnsignedByte();
                colorReplace = new int[length];
                colorFind = new int[length];
                for (int index = 0; index < length; index++) {
                    colorFind[index] = buffer.readUShort();
                    colorReplace[index] = buffer.readUShort();
                }
            } else if (opcode == 41) {
                int length = buffer.readUnsignedByte();
                textureFind = new short[length];
                textureReplace = new short[length];
                for (int index = 0; index < length; index++) {
                    textureFind[index] = (short) buffer.readUShort();
                    textureReplace[index] = (short) buffer.readUShort();
                }
            } else if (opcode == 42) {
                shiftClickIndex = buffer.readUnsignedByte();
            } else if (opcode == 65) {
                tradeable = true;
            } else if (opcode == 75) {
                weight = buffer.readUShort();
            } else if (opcode == 78)
                femaleModel2 = buffer.readUShort();
            else if (opcode == 79)
                femaleModel2 = buffer.readUShort();
            else if (opcode == 90)
                maleHeadModel = buffer.readUShort();
            else if (opcode == 91)
                femaleHeadModel = buffer.readUShort();
            else if (opcode == 92)
                maleHeadModel2 = buffer.readUShort();
            else if (opcode == 93)
                femaleHeadModel2 = buffer.readUShort();
            else if (opcode == 94)
                category = buffer.readUShort();
            else if (opcode == 95)
                zan2d = buffer.readUShort();
            else if (opcode == 97)
                unnoted_item_id = buffer.readUShort();
            else if (opcode == 98)
                noted_item_id = buffer.readUShort();
            else if (opcode >= 100 && opcode < 110) {
                if (countObj == null) {
                    countObj = new int[10];
                    countCo = new int[10];
                }
                countObj[opcode - 100] = buffer.readUShort();
                countCo[opcode - 100] = buffer.readUShort();
            } else if (opcode == 110)
                resizeX = buffer.readUShort();
            else if (opcode == 111)
                resizeY = buffer.readUShort();
            else if (opcode == 112)
                resizeZ = buffer.readUShort();
            else if (opcode == 113)
                ambient = buffer.readSignedByte();
            else if (opcode == 114)
                contrast = buffer.readSignedByte();
            else if (opcode == 115)
                team = buffer.readUnsignedByte();
            else if (opcode == 139)
                bought_id = buffer.readUShort();
            else if (opcode == 140)
                placeholder_template_id = buffer.readUShort();
            else if (opcode == 148)
                buffer.readUShort(); // placeholder id
            else if (opcode == 149) {
                buffer.readUShort(); // placeholder template
            }
        }
    }

    @Override
    public int getHaPrice() {
        return 0;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public void resetShiftClickActionIndex() {

    }

    @Override
    public int getIntValue(int paramID) {
        return 0;
    }

    @Override
    public void setValue(int paramID, int value) {

    }

    @Override
    public String getStringValue(int paramID) {
        return null;
    }

    @Override
    public void setValue(int paramID, String value) {

    }
}