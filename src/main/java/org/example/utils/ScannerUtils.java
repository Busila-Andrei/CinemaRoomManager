package org.example.utils;

import java.util.Scanner;

public class ScannerUtils {

    static final Scanner SCANNER = new Scanner(System.in);

    public static int nextIntAndMoveToNextLine() {
        int integer = SCANNER.nextInt();
        SCANNER.nextLine();
        return integer;
    }

}
