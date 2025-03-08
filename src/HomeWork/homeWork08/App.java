package HomeWork.homeWork08;

import HomeWork.homeWork06.Product;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Создание файла input.txt, если он не существует
        createInputFileIfNotExists();

        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        Map<String, Person> personMap = new HashMap<>();
        Map<String, Product> productMap = new HashMap<>();

        System.out.println("Начало чтения файла input.txt...");
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                System.out.println("Обработка строки: " + line);

                // Обработка покупателей и товаров
                if (line.contains("=")) {
                    String[] parts = line.split("=");
                    String name = parts[0].trim();
                    int value = Integer.parseInt(parts[1].replace(";", "").trim());

                    if (line.endsWith(";")) {
                        // Это товар
                        Product product = new Product(value, name);
                        productMap.put(name, product);
                        productList.add(product);
                        System.out.println("Добавлен товар: " + product);
                    } else {
                        // Это покупатель
                        Person person = new Person(name, value);
                        personMap.put(name, person);
                        personList.add(person);
                        System.out.println("Добавлен покупатель: " + person);
                    }
                } else if (line.contains("END")) {
                    break;
                } else {
                    // Обработка списка покупок
                    System.out.println("Обработка списка покупок...");
                    String[] purchases = line.split(",");
                    for (String purchase : purchases) {
                        System.out.println("Обработка покупки: " + purchase);
                        String[] parts = purchase.trim().split(" ");
                        if (parts.length >= 3) { // Проверяем, что массив содержит достаточно элементов
                            String personName = parts[0] + " " + parts[1];
                            String productName = parts[2];

                            Person person = personMap.get(personName);
                            Product product = productMap.get(productName);

                            if (person != null && product != null) {
                                if (person.addGroceryBag(product)) {
                                    writer.write(person.getName() + " купил(а) " + product.getProdName() + ",\n");
                                    System.out.println(person.getName() + " купил(а) " + product.getProdName());
                                } else {
                                    writer.write(person.getName() + " не может позволить себе " + product.getProdName() + ",\n");
                                    System.out.println(person.getName() + " не может позволить себе " + product.getProdName());
                                }
                            }
                        } else {
                            System.out.println("Ошибка: некорректный формат строки: " + purchase);
                        }
                    }
                }
            }

            // Записываем итоговый список покупок для каждого покупателя
            writer.write("\nИтоговый список покупок:\n");
            for (Person person : personList) {
                writer.write(person.toString() + "\n");
                System.out.println("Итоговый список: " + person);
            }

            System.out.println("Данные успешно записаны в output.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createInputFileIfNotExists() {
        File inputFile = new File("input.txt");
        if (!inputFile.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
                // Записываем данные по умолчанию
                writer.write("Павел Андреевич = 10000\n");
                writer.write("Анна Петровна = 2000\n");
                writer.write("Борис = 10\n");
                writer.write("Хлеб = 40;\n");
                writer.write("Молоко = 60;\n");
                writer.write("Торт = 1000;\n");
                writer.write("Кофе растворимый = 879;\n");
                writer.write("Масло = 150;\n");
                writer.write("Павел Андреевич Хлеб, Павел Андреевич Масло,\n");
                writer.write("Анна Петровна Кофе растворимый, Анна Петровна Молоко, Анна Петровна Молоко, Анна Петровна Молоко, Анна Петровна Торт,\n");
                writer.write("Борис Торт, Павел Андреевич Торт\n");
                System.out.println("Файл input.txt создан и заполнен данными по умолчанию.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл input.txt уже существует.");
        }
    }
}