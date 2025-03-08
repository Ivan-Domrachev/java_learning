package HomeWork.homeWork09.Cars;

import java.util.Objects;

public class ShowCar extends Car {
    private int stars; // Переименовано в stars

    // Конструктор по умолчанию
    public ShowCar() {
        super();
        this.stars = 0;
    }

    // Конструктор с параметрами
    public ShowCar(String carBrand, String carModel, int yearOfIssuer, int horsePower, int acceleration, int suspension, int durability, int stars) {
        super(carBrand, carModel, yearOfIssuer, horsePower, acceleration, suspension, durability);
        this.stars = stars;
    }

    // Геттер и сеттер для stars
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "carBrand='" + getCarBrand() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", yearOfIssue=" + getYearOfIssuer() +
                ", horsePower=" + getHorsePower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", stars=" + stars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}