package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Input string:");
        // String userInput = scanner.nextLine();
        //
        // for (int i = 0; i < userInput.length(); i++) {
        //     System.out.println(userInput.charAt(i) + " = " + Integer.toBinaryString(userInput.charAt(i)));
        //
        // }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String str = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + " = " + String.format("%7s", Integer.toBinaryString(str.charAt(i))).replace(" ", "0"));
        }

    }
}