package HomeWork.homeWork01;

import java.util.Scanner;

public class CaNoBu {
    public static void main(String[] args) {
        System.out.println("2 4 6 8");

        Scanner sc = new Scanner(System.in);
        String playAgain;


        do {
            System.out.println("Выберите фигуру - 0 - камень, 1 - ножницы, 2 - бумага.");
            int Vasya = sc.nextInt();
            System.out.println("выбор Васи: " + Vasya);
            int Petya = sc.nextInt();
            System.out.println("выбор Пети: " + Petya);

            if ((Vasya == 0 && Petya == 1) || (Vasya == 1 && Petya == 2) || (Vasya == 2 && Petya == 0)) {
                System.out.println("Выиграл Вася!");
            } else if (Vasya == Petya) {
                System.out.println("Ничья!");
            } else {
                System.out.println("Выиграл Петя!");
            }


            System.out.println("Сыграем снова? (Y/N)");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Спасибо за игру!");
    }
}

























