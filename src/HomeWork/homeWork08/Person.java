package HomeWork.homeWork08;

import HomeWork.homeWork06.Product; // Импортируем класс Product из другого пакета
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int amountOfMoney;
    private List<Product> groceryBag;

    // Конструктор
    public Person(String name, int amountOfMoney) {
        setName(name);
        setAmountOfMoney(amountOfMoney);
        this.groceryBag = new ArrayList<>();
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        this.name = name;
    }

    // Геттер для суммы денег
    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    // Сеттер для суммы денег
    public void setAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными!");
        }
        this.amountOfMoney = amountOfMoney;
    }

    // Геттер для пакета с продуктами
    public List<Product> getGroceryBag() {
        return groceryBag;
    }

    // Метод для добавления продукта в пакет
    public boolean addGroceryBag(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null.");
        }
        if (amountOfMoney >= product.getPrice()) {
            groceryBag.add(product);
            amountOfMoney -= product.getPrice();
            return true;
        }
        return false;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        if (groceryBag.isEmpty()) {
            return name + " - Ничего не куплено.";
        }
        StringBuilder result = new StringBuilder(name + " - ");
        for (Product product : groceryBag) {
            result.append(product.getProdName()).append(", ");
        }
        result.setLength(result.length() - 2);
        result.append(".");
        return result.toString();
    }
}