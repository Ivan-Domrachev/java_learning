package HomeWork.homeWork09.Races;

import HomeWork.homeWork09.Cars.Car;

public class DriftRace extends Race {
    public DriftRace() {
        super();
    }
    public DriftRace(int length, String route, int prize) {
        super(length, route, prize);
    }

    @Override
    public Car determineWinner(){
        Car winner = null;
        int Highestsuspension = 0;
        for (Car car: getParticipants()){
            if (car.getSuspension() > Highestsuspension){
                Highestsuspension = car.getSuspension();
                winner = car;
            }
        }
        return winner;
    }
}
