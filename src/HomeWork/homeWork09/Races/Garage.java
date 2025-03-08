package HomeWork.homeWork09.Races;

import HomeWork.homeWork09.Cars.Car;

import java.util.List;
import java.util.Objects;

public class Garage {
    private List<Car> ParkingСar;

    public Garage() {
    }

    public List<Car> getParkingСar() {
        return ParkingСar;
    }

    public void setParkingСar(List<Car> parkingСar) {
        ParkingСar = parkingСar;
    }

    // методы добавления и удаления авто
    public void add(Car car) {
        this.ParkingСar.add(car);
    }

    public void remove(Car car) {
        this.ParkingСar.remove(car);
    }

    // метод апгрейда машины
    public void upgradeCar(Car car, int UpHorsePower, int UpAcceleration, int UpSuspension, int UpDurability) {
        if (this.ParkingСar.contains(car)) {
            car.setHorsePower(UpHorsePower);
            car.setAcceleration(UpAcceleration);
            car.setSuspension(UpSuspension);
            car.setDurability(UpDurability);
        } else {
            System.out.println("Машина не в гараже");
        }
    }

    @Override
    public String toString() {
        return "Garage{" +
                "ParkingСar=" + ParkingСar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(ParkingСar, garage.ParkingСar);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ParkingСar);
    }
}