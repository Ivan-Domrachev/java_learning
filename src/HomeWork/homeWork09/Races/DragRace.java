package HomeWork.homeWork09.Races;

import HomeWork.homeWork09.Cars.Car;

public class DragRace extends Race {
    public DragRace() {
        super();
    }

    public DragRace(int length, String route, int prize) {
        super(length, route, prize);
    }

    @Override
    public Car determineWinner() {
        Car winner = null;
        int highestHorsepower = 0;

        for (Car car : getParticipants()) {
            if (car.getHorsePower() > highestHorsepower) {
                highestHorsepower = car.getHorsePower();
                winner = car;
            }
        }

        return winner;
    }
}

