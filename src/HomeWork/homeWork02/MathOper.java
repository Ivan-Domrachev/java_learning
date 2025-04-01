package HomeWork.homeWork02;

import java.util.Scanner;

public class MathOper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое целое число: ");
        int num1 = sc.nextInt();
        System.out.println("Введите второе целое число: ");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.println("Сумма 2ух целых чисел равна: " + sum);
        int diff = num1 - num2;
        System.out.println("Разница между числами равна: " + diff);
        int prodOfNum = num1 * num2;
        System.out.println("Произведение из двух целых чисел: " + prodOfNum);
        int average = (num1 + num2) / 2;
        System.out.println("Среднее из двух целых чисел: " + average);
        int distance = Math.abs(num1 - num2);
        System.out.println("Расстояние двух целых чисел: " + distance);
        int max = Math.max(num1, num2);
        System.out.println("Максимальное целое число: " + max);
        int min = Math.min(num1, num2);
        System.out.println("Минимальное целое число: " + min);
    }
}
