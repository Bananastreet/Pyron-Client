package com.client.util;

import com.client.graphics.interfaces.RSInterface;

public class Utils {

    public static void printFreeIdRange(int minimumFreeSlotsAvailable) {
        int start = 0;
        int free = 0;

        for(int i = 0; i < RSInterface.interfaceCache.length; i++) {

            if(RSInterface.interfaceCache[i] == null) {
                if(start == 0) {
                    start = i;
                }

                free++;
            } else {
                if(start > 0) {
                    if(free >= minimumFreeSlotsAvailable) {
                        System.out.println("Range ["+start+", "+ (i-1) + "] has " + free + " free slots.");
                    }

                    free = 0;
                    start = 0;
                }
            }

        }


    }

}
