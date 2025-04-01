package HomeWork.homeWork11.Model;

public class Car {
    private String AutoNum;
    private String AutoModel;
    private String Color;
    private int Mileage;
    private int Price;

    public Car(String autoNum, String autoModel, String Color, int mileage, int price) {
        this.AutoNum = autoNum;
        this.AutoModel = autoModel;
        this.Color = Color;
        this.Mileage = mileage;
        this.Price = price;
    }

    public String getAutoNum() {
        return AutoNum;
    }

    public void setAutoNum(String autoNum) {
       this.AutoNum = autoNum;
    }

    public String getAutoModel() {
        return AutoModel;
    }

    public void setAutoModel(String autoModel) {
        this.AutoModel = autoModel;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
       this.Color = color;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        this.Mileage = mileage;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
       this.Price = price;
    }

    @Override
    public String toString() {
        return String.format("AutoNum: %s, AutoModel: %s, Color: %s, Mileage: %d, Price: %d", AutoNum, AutoModel, Color, Mileage, Price);
    }
}
