package HomeWork.homeWork07;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discount; // Процент скидки
    private LocalDate expirationDate; // Дата окончания действия скидки

    public DiscountProduct(String prodName, double price, int discount, LocalDate expirationDate) {
        super(prodName, price);
        setDiscount(discount); // Используем метод для установки скидки
        this.expirationDate = expirationDate;
    }
    public void setDiscount(int discount) {
        if (discount < 0 || discount > 50) { // Проверка на максимум 50%
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 50!");
        }
        this.discount = discount;
    }



    @Override
    public double getPrice() {
        return super.getPrice() * (1 - discount / 100); // Применение скидки
    }

    public int getDiscount() {
        return discount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return String.format("Акционный продукт: %s, скидка = %d%%, дата истечения срока действия: %s",
                getProdName(), (int) discount, expirationDate);
    }
}