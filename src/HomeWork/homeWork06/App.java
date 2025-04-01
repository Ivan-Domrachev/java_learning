package HomeWork.homeWork06;

import java.util.*;

/*      1 Павел Андреевич = 10000;
        2 Анна Петровна = 2000;
        3 Борис = 10;
        4 Женя = 0;

        1 Хлеб = 40;
        2 Молоко = 60;
        3 Торт = 1000;
        4 Кофе растворимый = 879;
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
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();


        System.out.print("Укажите кол-во покупателей: ");
        Scanner scanner = new Scanner(System.in);
        int buyerCount = scanner.nextInt();
        while (buyerCount <= 0) {
            System.out.print("Количество покупателей должно быть больше 0. Попробуйте снова: ");
            buyerCount = scanner.nextInt();
        }

        for (int i = 0; i < buyerCount; i++) {
            System.out.print("Введите имя покупателя: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.print("Укажите баланс покупателя " + name + ": " );
            int balance = scanner.nextInt();
            while (balance < 0) {
                System.out.print("Баланс не может быть отрицательным! Укажите баланс покупателя: ");
                balance = scanner.nextInt();
            }

            Person person = new Person(name, balance);
            personList.add(person);
        }

        System.out.print("Укажите кол-во товаров: ");
        int prod = scanner.nextInt();
        while (prod <= 0) {
            System.out.print("Количество товаров должно быть больше 0. Попробуйте снова: ");
            prod = scanner.nextInt();
        }

        for (int i = 0; i < prod; i++) {
            System.out.print("Введите название товара: ");
            String prodName = scanner.next();

            System.out.print("Укажите стоимость товара " + prodName + ": ");
            int prodPrice = scanner.nextInt();

            Product product = new Product(prodPrice, prodName);
            productList.add(product);
        }

        System.out.println("Список покупателей:");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println((i + 1) + " - " + personList.get(i).getName());
        }

        System.out.println("Список товаров:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + " - " + productList.get(i));
        }
        while (true) {
            System.out.println("Для завершения операции введите число 0");
            System.out.println("ВЫберите человека и товар который хотите ему добавить (Выбирать по индексам) : ");
            int personIndex = scanner.nextInt();
            int productIndex = scanner.nextInt();
            if (personIndex < 1 || productIndex < 1) {
                break;
            }
            personList.get(personIndex - 1).addGroceryBag(productList.get(productIndex - 1));
            System.out.println(personList.get(personIndex - 1));


        }

        System.out.println(personList);
    }

}