package HomeWork.homeWork07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double amountOfMoney;
    private List<Product> groceryBag;
    private List<DiscountProduct> discountProductBag;

    public Person(String name, int initialAmountOfMoney) {
        validateName(name);
        validateAmount(initialAmountOfMoney);
        this.name = name;
        this.amountOfMoney = initialAmountOfMoney;
        this.groceryBag = new ArrayList<>();
        this.discountProductBag = new ArrayList<>();
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Имя не может быть пустым");
        }
    }

    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new RuntimeException("Баланс не может быть отрицательным");
        }
    }

    public void setAmountOfMoney(double amountOfMoney) {
        validateAmount(amountOfMoney);
        this.amountOfMoney = amountOfMoney;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public boolean canAfford(double price) {
        return amountOfMoney >= price;
    }

    public String getName() {
        return name;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public List<Product> getGroceryBag() {
        return new ArrayList<>(groceryBag);
    }

    public List<DiscountProduct> getDiscountProductBag() {
        return new ArrayList<>(discountProductBag);
    }

    public void subtractFromBalance(double amount) {
        if (amount < 0) {
            throw new RuntimeException("Сумма для вычета не может быть отрицательной");
        }
        this.amountOfMoney -= amount;
    }

    public void addGroceryBag(Product product) {
        double priceToPay = product.getPrice(); // Начальная цена продукта

        // Если продукт акционный, рассчитываем цену с учетом скидки
        if (product instanceof DiscountProduct) {
            DiscountProduct discountProduct = (DiscountProduct) product;
            double discountAmount = discountProduct.getDiscount(); // Получаем скидку
            priceToPay = priceToPay - (priceToPay * (discountAmount / 100)); // Рассчитываем итоговую цену с учетом скидки
        }

        // Проверяем достаточно ли средств для покупки
        if (amountOfMoney >= priceToPay) {
            groceryBag.add(product); // Добавляем продукт в корзину
            amountOfMoney -= priceToPay; // Уменьшаем баланс на итоговую цену

            // Если продукт акционный, добавляем его в discountProductBag
            if (product instanceof DiscountProduct) {
                discountProductBag.add((DiscountProduct) product);
            }

            System.out.println(name + " купил " + product.getProdName() + " по цене: " + priceToPay);
            System.out.println("Баланс: " + amountOfMoney);
        } else {
            System.out.println(name + " не может позволить " + product.getProdName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Покупатель: " + name + "\nБаланс: " + amountOfMoney + "\nОбычные продукты:\n");

        for (Product product : groceryBag) {
            if (!(product instanceof DiscountProduct)) {
                sb.append(product.getProdName()).append("\n");
            }
        }

        sb.append("Акционные продукты:\n");
        for (DiscountProduct discountProduct : discountProductBag) {
            sb.append(discountProduct.toString()).append("\n");
        }

        return sb.toString();
    }
}