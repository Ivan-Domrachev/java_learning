package HomeWork.homeWork09.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerformanceCars extends Car {
    private  List<String> addOne;

    public PerformanceCars() {
        super();
        this.addOne = new ArrayList<>();
    }

    public PerformanceCars(String carBrand, String carModel, int yearOfIssue, int horsePower, int acceleration, int suspension, int durability) {
        super(carBrand, carModel, yearOfIssue, horsePower, acceleration, suspension, durability);
        this.addOne = new ArrayList<>();
        applyPerformanceModifications();
    }

    private void applyPerformanceModifications() {
        setHorsePower((int) (getHorsePower() * 1.5));
        setSuspension((int) (getSuspension() * 0.75));
    }

    public List<String> getAddOne() {
        return addOne;
    }

    public void setAddOne(List<String> addOne) {
        this.addOne = addOne;
    }

    @Override
    public String toString() {
        return "PerformanceCars{" +
                "brand='" + getCarBrand() + '\'' +
                ", model='" + getCarModel() + '\'' +
                ", yearOfIssue=" + getYearOfIssuer() +
                ", horsePower=" + getHorsePower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", addOne=" + addOne +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCars that = (PerformanceCars) o;
        return Objects.equals(addOne, that.addOne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addOne);
    }
}