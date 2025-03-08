package HomeWork.homeWork09.Cars;

import java.util.Objects;

public class Car {
    private String CarBrand;
    private String CarModel;
    private int YearOfIssuer;
    private int HorsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car() {
    }

    public Car(String CarBrand, String CarModel, int YearOfIssuer, int HorsePower, int acceleration, int suspension, int durability) {
        this.CarBrand = CarBrand;
        this.CarModel = CarModel;
        this.YearOfIssuer = YearOfIssuer;
        this.HorsePower = HorsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String carBrand) {
        CarBrand = carBrand;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    public int getYearOfIssuer() {
        return YearOfIssuer;
    }

    public void setYearOfIssuer(int yearOfIssuer) {
        YearOfIssuer = yearOfIssuer;
    }

    public int getHorsePower() {
        return HorsePower;
    }

    public void setHorsePower(int horsePower) {
        HorsePower = horsePower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarBrand='" + CarBrand + '\'' +
                ", CarModel='" + CarModel + '\'' +
                ", YearOfIssuer=" + YearOfIssuer +
                ", HorsePower=" + HorsePower +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return YearOfIssuer == car.YearOfIssuer && HorsePower == car.HorsePower && acceleration == car.acceleration && suspension == car.suspension && durability == car.durability && Objects.equals(CarBrand, car.CarBrand) && Objects.equals(CarModel, car.CarModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CarBrand, CarModel, YearOfIssuer, HorsePower, acceleration, suspension, durability);
    }
}
