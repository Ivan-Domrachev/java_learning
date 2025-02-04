package HomeWork.homeWork07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*      1 Павел Андреевич = 10000;
        2 Анна Петровна = 2000;
        3 Борис = 10;
        4 Женя = 0;

        1 Хлеб = 40;
        2 Молоко = 60;
        3 Торт = 1000; 15%
        4 Кофе растворимый = 879; 50%
        5 Масло = 150;
        6 Мороженое = 200;

        Павел Андреевич Хлеб
        Павел Андреевич  Масло
        Анна Петровна  Кофе растворимый
        Анна Петровна   Молоко
        Анна Петровна   Молоко
        Анна Петровна   Молоко
        Анна Петровна  Торт
        Борис Торт
        Павел Андреевич  Торт
        Женя Мороженое*/
public class App {
    public static void main(String[] args) {
        List<Product> productListDiscountOn = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите кол-во покупателей: ");
        int countPerson = scanner.nextInt();
        scanner.nextLine(); // переходим на новую строку после числа

        for (int i = 0; i < countPerson; i++) {
            System.out.print("Введите имя покупателя: ");
            String name = scanner.nextLine();

            System.out.print("Укажите баланс покупателя " + name + ": ");
            int balance = scanner.nextInt();
            scanner.nextLine(); // переходим на новую строку после числа

            Person person = new Person(name, balance);
            personList.add(person);
        }

        // Добавляем товары
        System.out.println("укажите кол-во товаров: ");
        int countProduct = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < countProduct; i++) {
            System.out.print("Введите название для товара: ");
            String nameProd = scanner.nextLine();
            System.out.print("Введите цену товара для " + nameProd + ": ");
            int price = scanner.nextInt();
            System.out.print("У товара " + nameProd + " есть скидка? true/false ");
            boolean check = scanner.nextBoolean();
            scanner.nextLine(); // переходим на новую строку

            Product product;
            if (check) {
                System.out.print("Введите скидку для товара " + nameProd + ": ");
                int discount = scanner.nextInt();
                scanner.nextLine(); // переходим на новую строку
                System.out.print("Введите дату окончания скидки (год-месяц-число): " + nameProd + ": ");
                String dateDiscount = scanner.nextLine();
                LocalDate discountDate = LocalDate.parse(dateDiscount);
                product = new DiscountProduct(nameProd, price, discount, discountDate);
            } else {
                product = new Product(nameProd, price);
            }
            productList.add(product);
        }

        // Вывод списка покупателей
        System.out.println("Список покупателей: ");
        for (Person person : personList) {
            System.out.println(person.getName());
        }

        // Вывод списка товаров
        System.out.println("Список товаров: ");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i).getProdName());
        }


        while (true) {
            System.out.println("Для завершения операции введите число 0");
            System.out.println("Выберите человека и товар, который хотите ему добавить (Выбирать по индексам): ");
            int personIndex = scanner.nextInt();
            int productIndex = scanner.nextInt();
            if (personIndex == 0 || productIndex == 0) {
                break;
            }
            personList.get(personIndex - 1).addGroceryBag(productList.get(productIndex - 1));
        }

        // Вывод информации о каждом покупателе
        System.out.println("Информация о покупателях:");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
// написать метод по принципу класса персон public void addGroceryBag
// разобраться в арр с добавлением скидочных продуктов
// разобраться почему не вычитает сумму товаров (акция и обычный)
//изменить метод указания даты с консоли