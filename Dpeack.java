// Dpeack.java
// Version 1 — Enhanced mathematical password generator (no loops, no arrays)
// Author: Chisom
// Description: Generates platform-based passwords using random numbers + math formulas

import java.util.Scanner;
import java.util.Random;

public class Dpeack {
    public static void main(String[] args) {
        // Create scanner and random objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("====== Welcome to Dpeack Encryption Tool ======");
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter platform name (e.g., google, github, facebook): ");
        String platform = scanner.nextLine();

        // Random base numbers
        int n1 = random.nextInt(1000) + 1;  // 1–1000
        int n2 = random.nextInt(5000) + 100; // 100–5099
        int n3 = random.nextInt(9000) + 1000; // 1000–9999

        // Mathematical operations to generate unique segments
        double sqrtPart = Math.sqrt(n1 * n2); // square root pattern
        double powerPart = Math.pow(n1 % 10, 3); // small cube power
        double mixValue = (n3 / 3.14) + (sqrtPart / 2); // floating-point mix

        // Convert mathematical results into short strings
        int mathA = (int) (sqrtPart + powerPart) % 10000;
        int mathB = (int) (mixValue) % 9999;
        int mathC = (int) ((mathA + mathB) / 2.7);

        String password = "";

        // Platform-based unique style
        if (platform.equalsIgnoreCase("github")) {
            password = "GH@" + userName.charAt(0) + mathA + "#" + (int)powerPart + "Z";
        } else if (platform.equalsIgnoreCase("google")) {
            password = "GO$" + (char)(65 + n1 % 26) + mathB + "&" + userName.length() + "X";
        } else if (platform.equalsIgnoreCase("facebook")) {
            password = "FB_" + (char)(97 + n2 % 26) + mathC + "_" + userName.toUpperCase().charAt(0);
        } else {
            password = userName + "-" + mathA + "-" + mathB + "-" + (char)(65 + n3 % 26);
        }

        // Output the result
        System.out.println("--------------------------------");
        System.out.println("Generated password for " + platform + ":");
        System.out.println(password);
        System.out.println("--------------------------------");

        scanner.close();
    }
}