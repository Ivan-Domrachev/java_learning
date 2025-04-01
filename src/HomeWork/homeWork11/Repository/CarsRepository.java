package HomeWork.homeWork11.Repository;

import HomeWork.homeWork11.Model.Car;

import java.util.List;

public interface CarsRepository {
    List<Car> getAllCars();

    void addCar(Car car);

    List<String> getCarNumbersByColorOrMileage(String color, int mileage);

    long countUniqueModelsInRange(int minPrice, int maxPrice);

    String getColorOfMinCostCar();

    double getAverageCostOfModel(String model);

    void loadFromFile(String fileName);

    void saveToFile(String fileName);
}
