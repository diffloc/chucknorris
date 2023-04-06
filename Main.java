package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String str = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");

        String binary = "";
        StringBuilder chuckNorris = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            binary = String.format("%7s", Integer.toBinaryString(str.charAt(i))).replace(" ", "0");
            chuckNorris.append(binary);
            // System.out.println(str.charAt(i) + " = " + binary);
        }

        String newBinary = chuckNorris.toString().replaceAll("([01])(?!\\1)", "$1 ");
        String[] parts = newBinary.split(" ");

        for (int i = 0; i < parts.length; i++) {
            StringBuilder series = new StringBuilder();
            for (int j = 0; j < parts[i].length(); j++) {
                series.append("0");
            }
            if (parts[i].charAt(0) == '0') {
                parts[i] = "00 " + series;
            } else {
                parts[i] = "0 " + series;
            }
        }
        for (int i = 0; i < parts.length; i++) {
            System.out.print(parts[i] + " ");
        }



    }
}