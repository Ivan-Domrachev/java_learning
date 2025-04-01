package HomeWork.homeWork02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TempConvert {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.0");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Температуру в фаренгейт: ");
        double fahrenheit = sc.nextDouble();
        double fahrenheitTemp = (fahrenheit - 32) * 5 / 9;
        System.out.println(fahrenheit + " Градусов по Фаренгейту равна " + df.format(fahrenheitTemp) + " градусов По Цельсию.");

    }
}
