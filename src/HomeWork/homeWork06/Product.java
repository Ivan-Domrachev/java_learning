package HomeWork.homeWork06;

import java.util.Objects;

public class Product {
    private int price;
    private String prodName;

    // Конструктор
    public Product(int price, String prodName) {
        setPrice(price); // Используем сеттер для проверки цены
        setProdName(prodName); // Используем сеттер для проверки имени
    }

    // Геттер для цены
    public int getPrice() {
        return price;
    }

    // Сеттер для цены
    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной!");
        }
        this.price = price;
    }

    // Геттер для названия товара
    public String getProdName() {
        return prodName;
    }

    // Сеттер для названия товара
    public void setProdName(String prodName) {
        if (prodName == null || prodName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя товара не может быть пустым!");
        }
        this.prodName = prodName;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return price == product.price && Objects.equals(prodName, product.prodName);
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(price, prodName);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Product{prodName='" + prodName + "', price=" + price + "}";
    }
}