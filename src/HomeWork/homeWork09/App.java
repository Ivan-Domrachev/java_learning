package HomeWork.homeWork09;

import HomeWork.homeWork09.Cars.Car;
import HomeWork.homeWork09.Cars.PerformanceCars;
import HomeWork.homeWork09.Cars.ShowCar;
import HomeWork.homeWork09.Races.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Car> cars = readCarsFromFile("C:\\Users\\Professional\\IdeaProjects\\java_learning\\src\\HomeWork\\homeWork09\\cars.txt");

        // Создаем объекты гонок
        DragRace dragRace = new DragRace(500, "DirectRoad", 15000);
        DriftRace driftRace = new DriftRace(400, "DriftRoad", 10000);
        CasualRace casualRace = new CasualRace(300, "CasualRoad", 3, 15000);

        for (Car car : cars) {
            dragRace.getParticipants().add(car);
            driftRace.getParticipants().add(car);
            casualRace.getParticipants().add(car);
        }

        Car DragRaceWin = dragRace.determineWinner();
        Car DriftRaceWin = driftRace.determineWinner();
        Car CasualRaceWin = casualRace.determineWinner();

        List<String> result = new ArrayList<>();
        result.add("В заезде DragRace:\nПобеду одержала машина: " + DragRaceWin);
        result.add("В заезде DriftRace:\nПобеду одержала машина: " + DriftRaceWin);
        result.add("В заезде CasualRace:\nПобеду одержала машина: " + CasualRaceWin);

        // Записываем результаты в файл
        writeResultsToFile("C:\\Users\\Professional\\IdeaProjects\\java_learning\\src\\HomeWork\\homeWork09\\race_results.txt",result);
    }

    private static List<Car> readCarsFromFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    cars.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
                } else if (parts.length == 8 && parts[7].equals("PerformanceCars")) {
                    cars.add(new PerformanceCars(parts[0], parts[1], Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
                } else if (parts.length == 9 && parts[8].equals("Show")) {
                    cars.add(new ShowCar(parts[0], parts[1], Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    private static void writeResultsToFile(String fileName, List<String> results) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String result : results) {
                bw.write(result);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

