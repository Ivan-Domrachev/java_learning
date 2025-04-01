package HomeWork.homeWork11.Test;

import HomeWork.homeWork11.Repository.CarsRepository;
import HomeWork.homeWork11.Repository.CarsRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CarsRepository carsRepository = new CarsRepositoryImpl();

        String inputFileName = "C:\\Users\\Professional\\IdeaProjects\\java_learning\\src\\HomeWork\\homeWork11\\DataBaseAuto\\cars.txt";
        String outputFileName = "C:\\Users\\Professional\\IdeaProjects\\java_learning\\src\\HomeWork\\homeWork11\\DataBaseAuto\\result.txt";

        carsRepository.loadFromFile(inputFileName);
        try (PrintStream out = new PrintStream(new FileOutputStream(outputFileName))) {

            System.setOut(out);
            System.out.println("База авто: ");
            carsRepository.getAllCars().forEach(System.out::println);

            String colorToFind = "Black";
            int mileageToFind = 0;
            List<String> CarAutoNumOfColorOrMileage = carsRepository.getCarNumbersByColorOrMileage(colorToFind, mileageToFind);
            System.out.println("\nНомера автомобилей по цвету или пробегу: " + String.join(", ", CarAutoNumOfColorOrMileage));

            int min = 700000;
            int max = 800000;
            long UniqueModelsInTheRange = carsRepository.countUniqueModelsInRange(min, max);
            System.out.println("\nУникальные автомобили: " + UniqueModelsInTheRange + " шт.");

            String ColorToMinPrice = carsRepository.getColorOfMinCostCar();
            System.out.println("Цвет с минимальной стоимость: " + ColorToMinPrice);

            String ModelToFind = "Toyota";
            double AveragePriceOfTheBrand = carsRepository.getAverageCostOfModel(ModelToFind);
            System.out.printf("Средняя стоимость модели %s: %.2f%n", ModelToFind, AveragePriceOfTheBrand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
