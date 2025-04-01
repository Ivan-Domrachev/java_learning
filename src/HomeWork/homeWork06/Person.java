package HomeWork.homeWork06;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int amountOfMoney;
    private List<Product> groceryBag = new ArrayList<>();

    public Person(String name, int amountOfMoney) {
        setName(name);
        setAmountOfMoney(amountOfMoney);
    }

    public String getName() {
        return name;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public List<Product> getGroceryBag() {
        return groceryBag;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Имя не может быть пустым!");
        }
        this.name = name;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney < 0) {
            throw new RuntimeException("Деньги не могут быть отрицательными!");
        }
        this.amountOfMoney = amountOfMoney;
    }

    public boolean addGroceryBag(Product product) {
        if (amountOfMoney >= product.getPrice()) {
            groceryBag.add(product);
            amountOfMoney -= product.getPrice();
            System.out.println(this.name + " Купил: " + product.getProdName());
        } else {
            System.out.println(this.name + " не может позволить себе " + product.getProdName());
        }
        return false;
    }

    @Override
    public String toString() {
        if (groceryBag.isEmpty()) {
            return name + " - Ничего не куплено";
        } else {
            StringBuilder result = new StringBuilder(name + " Баланс: " + amountOfMoney + " Корзина: ");
            for (Product product : groceryBag) {
                result.append(product.getProdName()).append(" ");
            }
            return result.toString().trim();
        }
    }
}