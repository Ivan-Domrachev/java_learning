package HomeWork.homeWork11.Repository;

import HomeWork.homeWork11.Model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<String> getCarNumbersByColorOrMileage(String color, int mileage) {
        return cars.stream()
                .filter(car -> car.getColor().equals(color) || car.getMileage() == mileage)
                .map(Car::getAutoNum) // Исправлено: Car::getAutoNum вместо cars::getAutoNum
                .collect(Collectors.toList());
    }

    @Override
    public long countUniqueModelsInRange(int minPrice, int maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .map(Car::getAutoModel)
                .distinct()
                .count();
    }

    @Override
    public String getColorOfMinCostCar() {
        return cars.stream()
                .min(Comparator.comparingInt(Car::getPrice))
                .map(Car::getColor)
                .orElse("Unknown");
    }

    @Override
    public double getAverageCostOfModel(String model) {
        return cars.stream()
                .filter(car -> car.getAutoModel().equals(model))
                .mapToInt(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    @Override
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    try {
                        String number = parts[0];
                        String model = parts[1];
                        String color = parts[2];
                        int mileage = Integer.parseInt(parts[3]);
                        int price = Integer.parseInt(parts[4]);
                        cars.add(new Car(number, model, color, mileage, price));
                    } catch (NumberFormatException e) {
                        System.err.println("Неверный формат номеров в строке: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Car car : cars) {
                pw.println(car.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}