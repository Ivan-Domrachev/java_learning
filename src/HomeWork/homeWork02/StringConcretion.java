package HomeWork.homeWork02;

import java.util.Scanner;

public class StringConcretion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Укажите исходную строку: ");
        String srcString = sc.nextLine();
        System.out.println("Исходная строка: " + srcString);
        System.out.print("Укажите количество вывода: ");
        int repeat = sc.nextInt();
        System.out.println("количество вывода: " + repeat);
        String repeatString = srcString.repeat(repeat);
        System.out.println(repeatString);


    }
}

