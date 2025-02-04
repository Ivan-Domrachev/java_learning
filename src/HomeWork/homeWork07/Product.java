package HomeWork.homeWork07;

import java.util.Objects;

public class Product {
    private String prodName;
    private double price;

    public Product(String prodName, double price) {
        if ((isNumeric(prodName)) || (prodName.equals(null)) || prodName.length() <=3){
            throw new IllegalArgumentException("Недопустимое имя продукта!");
        }
        if (price < 0) {
            throw new RuntimeException("Цена не может быть отрицательной");
        }
        this.prodName = prodName;
        this.price = price;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProdName() {
        return prodName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isNumeric(String prodName) {
        try {
            Double.parseDouble(prodName);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public Product() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProdName(), getPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return getPrice() == product.getPrice() &&  Objects.equals(getProdName(), product.getProdName());

    }

    @Override
    public String toString() {
        return "Наименование товара: " + prodName + '\'' +
                ", Цена товара = " + price ;
    }
}