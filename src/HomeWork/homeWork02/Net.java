package HomeWork.homeWork02;

import java.util.Scanner;

public class Net {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите число столбцов сетки: ");
        int columns = scanner.nextInt();

        System.out.print("Введите повторяемый элемент сетки: ");
        String element = scanner.next();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}