package com.client;

import java.time.LocalDateTime;

public class Configuration {

    public static boolean LOCAL_HOST = false;

    public static String serverConnection = LOCAL_HOST ? "localhost" : "51.68.213.221";
    /**
     * Client version is a number that will tell the server whether
     * the player has the most up-to-date client, otherwise they
     * will receive an error on login to update their client.
     */
    public static final int CLIENT_VERSION = 35;

    public static String SERVER_NAME = "Pyron"; //will let it download updated cache then ill readd sprites

    /**
     * Cache version is written to the cache folder inside a version file.
     * This is read on startup to tell if the cache is out of date or not.
     */
    public static final int CACHE_VERSION = 7; // Set this to the same value, v0.030 = 30, v1.120 = 1120

    public static final String CACHE_LINK = "https://pyron.b-cdn.net/cache.zip";

    /**
     * The server version. The cache path is append with a _v1/2/3 etc for the version number
     * to prevent overwriting older version caches.
     * This should only be changed when a new server is launched, otherwise change {@link Configuration#CLIENT_VERSION}.
     */

    public static final int SERVER_VERSION = 1;
//I mean on uhhh login screen above input box? or do you want that?

    public static final String CLIENT_TITLE = "Pyron";
    public static final String WEBSITE = "https://discord.gg/EwAG2DjWP7";
    public static final String DEDICATED_SERVER_ADDRESS = Configuration.serverConnection;//15.204.209.182
    public static final String TEST_SERVER_ADDRESS = "51.68.213.221";//51.79.50.152
    public static final int PORT = 52777;
    public static final int TEST_PORT = 43595;
    public static final int CACHE_FOLDER_VERSION = 0;
    public static final String CACHE_NAME = "." + CLIENT_TITLE.toLowerCase() + (CACHE_FOLDER_VERSION != 0 ? "_" + CACHE_FOLDER_VERSION : "") + "_v" + SERVER_VERSION;
    public static final String DEV_CACHE_NAME = "local_cache";
    public static final String CACHE_NAME_DEV = CACHE_NAME + "_dev";

    public static final String CUSTOM_ITEM_SPRITES_DIRECTORY = "item_sprites/";
    public static String CUSTOM_MAP_DIRECTORY = "./data/custom_maps/";
    public static String CUSTOM_MODEL_DIRECTORY = "./data/custom_models/";
    public static String CUSTOM_ANIMATION_DIRECTORY = "./data/custom_animations/";
    public static String EXTERNAL_CACHE_ARCHIVE = "/archive_data/";
    public static String INDEX_DATA_DIRECTORY = "/index_data/";

    public static boolean developerMode;
    public static boolean loadExternalCacheArchives = true; // Always true because I can't seem to pack them correctly
    public static boolean packIndexData = false;
    public static boolean dumpMaps;
    public static boolean dumpAnimationData;
    public static boolean dumpDataLists;
    public static boolean newFonts; // TODO text offsets (i.e. spacing between characters) are incorrect, needs automatic fix from kourend
    public static String cacheName = CACHE_NAME;
    public static String clientTitle = "";

    public static final LocalDateTime LAUNCH_TIME = LocalDateTime.now();
    public static final String ERROR_LOG_DIRECTORY = "error_logs/";
    public static String ERROR_LOG_FILE = ("error_log_"
            + LAUNCH_TIME.getYear() + "_"
            + LAUNCH_TIME.getMonth() + "_"
            + LAUNCH_TIME.getDayOfMonth()
            + ".txt").toLowerCase();

    /**
     * Attack option priorities 0 -> Depends on combat level 1 -> Always right-click
     * 2 -> Left-click where available 3 -> Hidden
     */
    public static int playerAttackOptionPriority;
    public static int npcAttackOptionPriority = 2;

    public static final boolean DUMP_SPRITES = false;
    public static final boolean PRINT_EMPTY_INTERFACE_SECTIONS = false;

    public static boolean playerNames;

    /**
     * Seasonal Events
     */
    public static boolean HALLOWEEN;
    public static boolean CHRISTMAS;
    public static boolean CHRISTMAS_EVENT;
    public static boolean EASTER;

    public static boolean osbuddyGameframe;

    public static int xpPosition;
    public static boolean escapeCloseInterface;
    public static boolean alwaysLeftClickAttack;
    public static boolean hideCombatOverlay;
    public static boolean statusBars;
}
