package HomeWork.homeWork10;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] intArray = Sequence.filter(new int[]{1, 5, 7, 4, 2, 6}, num -> {
            System.out.println(num);
            return num % 2 == 0;
        });
        System.out.println(Arrays.toString(intArray));


    }
}
// сделать вывод в консоль что бы было отсортированны числа
