package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation;
        do {
            System.out.println("\nPlease input operation (encode/decode/exit):");
            operation = scanner.nextLine();
            switch (operation) {
                case "encode" -> encode(scanner);
                case "decode" -> decode(scanner);
                case "exit" -> System.out.println("Bye!");
                default -> System.out.println("There is no '" + operation + "' operation");
            }
        } while (!operation.equals("exit"));

    }

    public static void decode(Scanner scanner) {

        System.out.println("Input encoded string:");
        String str = scanner.nextLine();

        if (!str.matches("^[ 0]*$")) {
            System.out.println("Encoded string is not valid.");
            return;
        }



        String[] substrings = str.split(" ");

        if (substrings.length % 2 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substrings.length; i +=2) {
            String leftPart = substrings[i];
            String rightPart = substrings[i + 1];

            if (!leftPart.equals("0") && !leftPart.equals("00")) {
                System.out.println("Encoded string is not valid.");
                return;
            }

            String decodeLeftPart = leftPart.equals("00") ? "0" : "1";
            String buildRightPart = new String(new char[rightPart.length()]).replace("\0", decodeLeftPart);
            sb.append(buildRightPart);
        }

        if (sb.length() % 7 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        StringBuilder ascii = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 7) {
            String byteStr = sb.substring(i, Math.min(i + 7, sb.length()));
            char asciiChar = (char) Integer.parseInt(byteStr, 2);
            ascii.append(asciiChar);
        }

        System.out.println("Decoded string:");
        System.out.println(ascii.toString());

    }

    public static void encode(Scanner scanner) {
        System.out.println("Input string:");
        String str = scanner.nextLine();



        String binary = "";
        StringBuilder chuckNorris = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            binary = String.format("%7s", Integer.toBinaryString(str.charAt(i))).replace(" ", "0");
            chuckNorris.append(binary);
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
        System.out.println("Encoded string::");
        for (int i = 0; i < parts.length; i++) {
            System.out.print(parts[i] + " ");
        }
        System.out.println();
    }
}