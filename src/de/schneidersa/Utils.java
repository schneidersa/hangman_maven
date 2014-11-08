package de.schneidersa;

import java.util.Scanner;

/**
 *
 * @author Sandra Schneider
 */
public class Utils {

    private Utils() {
        super();
    }

    /**
     * 
     * @return 
     */
    public static String readUserInput() {
        Scanner in = new Scanner(System.in, "iso-8859-1");
        return in.nextLine().toUpperCase();
    }
}
