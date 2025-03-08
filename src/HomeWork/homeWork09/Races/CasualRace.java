package HomeWork.homeWork09.Races;

import HomeWork.homeWork09.Cars.Car;

import java.util.Objects;

public class CasualRace extends Race {

    public CasualRace() {
    }

    private int NumOfCircles;

    public CasualRace(int length, String route,int NumOfCircles, int prize) {
        super(length, route, prize);
        this.NumOfCircles = NumOfCircles;
    }

    public int getNumOfCircles() {
        return NumOfCircles;
    }

    public void setNumOfCircles(int numOfCircles) {
        NumOfCircles = numOfCircles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CasualRace that = (CasualRace) o;
        return NumOfCircles == that.NumOfCircles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), NumOfCircles);
    }

    @Override
    public Car determineWinner() {
        return super.getParticipants().stream().findFirst().orElse(null);
    }
}
