package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        System.out.println(scanner.nextLine().replaceAll("", " ").replaceFirst(" ", ""));

    }
}